package br.com.mesttra.mcs.orcamento.service.impl;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.exception.ServiceEnumValidation;
import br.com.mesttra.mcs.orcamento.repository.BudgetRepository;
import br.com.mesttra.mcs.orcamento.service.BudgetAllocationService;
import br.com.mesttra.mcs.orcamento.service.BudgetService;
import br.com.mesttra.mcs.orcamento.service.DestinationService;
import br.com.mesttra.mcs.orcamento.validation.ValidationCustom;
import lombok.RequiredArgsConstructor;

/**
 * Classe que implementa os métodos do serviço para manter o orçamento.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Service
@Transactional
@RequiredArgsConstructor
public class BudgetServiceImpl implements BudgetService {
	
	private final BudgetRepository repository;
	
	private final DestinationService destinationService;
	
	private final BudgetAllocationService budgetAllocationService;

	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.BudgetService#create(br.com.mesttra.mcs.orcamento.entity.Budget)
	 */
	@Override
	public Budget create(Budget budget) throws ApplicationException {
		
		ValidationCustom.validateConsistency(budget);
		ValidationCustom.validateDataViolation(budget, budget.getClass());
		
		budget.setDtBudget(LocalDateTime.now());
		Budget newBudget = repository.save(budget);
		
		List<Destination> destinationList = new LinkedList<Destination>();
		
		for (Destination destination : budget.getDestinations()) {
			destination.setBudget(newBudget);
			destinationList.add(destinationService.create(destination));
		}
		
		newBudget.setDestinations(destinationList);
		
		return newBudget;
	}
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.BudgetService#createBudgetAllocation(java.lang.Long, br.com.mesttra.mcs.orcamento.entity.BudgetAllocation)
	 */
	@Override
	public Budget createBudgetAllocation(Long id, BudgetAllocation allocation) throws ApplicationException {
		
		ValidationCustom.validateConsistency(id, allocation);
		
		Budget budget = retrieve(id);
		
		//TODO - validar o valor financeiro
		
		allocation.setBudget(budget);
		
		
		
		budgetAllocationService.create(allocation);
		
		return budget;
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.BudgetService#retrieve(java.lang.Long)
	 */
	@Override
	public Budget retrieve(Long id) throws ApplicationException {
		
		ValidationCustom.validateConsistency(id);
		
		try {

			return repository.findById(id).get();

		} catch(NoSuchElementException ex) {
			throw new ApplicationException(ServiceEnumValidation.BUDGET_NOT_FOUND);
		}
	}

	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.BudgetService#list(br.com.mesttra.mcs.orcamento.entity.Budget, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Budget> list(Budget budget, Pageable pageable) throws ApplicationException {
		
		ValidationCustom.validateConsistency(pageable);

		if(Objects.isNull(budget)) {
			budget = Budget.builder().build();
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		Example<Budget> example = Example.of(budget, matcher);

		return repository.findAll(example, pageable); 
	}

}
