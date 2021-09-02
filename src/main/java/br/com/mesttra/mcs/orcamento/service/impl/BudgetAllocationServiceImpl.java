package br.com.mesttra.mcs.orcamento.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.BudgetAllocationRepository;
import br.com.mesttra.mcs.orcamento.service.BudgetAllocationService;
import br.com.mesttra.mcs.orcamento.validation.ValidationCustom;
import lombok.RequiredArgsConstructor;

/**
 * Classe que implementa os métodos do serviço para manter a alocação de orçamento.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Service
@RequiredArgsConstructor
public class BudgetAllocationServiceImpl implements BudgetAllocationService {
	
	private final BudgetAllocationRepository repository;

	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.BudgetAllocationService#create(br.com.mesttra.mcs.orcamento.entity.BudgetAllocation)
	 */
	@Override
	public BudgetAllocation create(BudgetAllocation budgetAllocation) throws ApplicationException {
		
		ValidationCustom.validateConsistency(budgetAllocation);
		ValidationCustom.validateDataViolation(budgetAllocation, budgetAllocation.getClass());
		
		budgetAllocation.setDtAllocation(LocalDateTime.now());
		
		return repository.save(budgetAllocation);
	}

}
