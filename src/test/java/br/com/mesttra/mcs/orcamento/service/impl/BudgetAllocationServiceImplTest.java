package br.com.mesttra.mcs.orcamento.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.BudgetAllocationRepository;

/**
 * Classe de teste que representa os cenários de testes da classe {@link BudgetAllocationServiceImpl}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
@SpringBootTest
public class BudgetAllocationServiceImplTest {

	@InjectMocks
	private BudgetAllocationServiceImpl service;
	
	@Mock
	private BudgetAllocationRepository repository;
	
	private BudgetAllocation request;
	
	private BudgetAllocation response;
	
	@BeforeEach
	public void setup() {
		
		Budget budget = Budget.builder().id(EntityGenericUtil.getLong()).build();
		BigDecimal spentAmount = EntityGenericUtil.getBigDecimal();
		
		this.request = BudgetAllocation
				.builder()
				.spentAmount(spentAmount)
				.dtAllocation(EntityGenericUtil.getDateTime())
				.budget(budget)
				.build();
		
		this.response = BudgetAllocation
				.builder()
				.id(EntityGenericUtil.getLong())
				.spentAmount(spentAmount)
				.dtAllocation(EntityGenericUtil.getDateTime())
				.budget(budget)
				.build();

		Mockito.when(this.repository.save(
				Mockito.any(BudgetAllocation.class))).thenReturn(this.response);
	}
	
	//create
	@Test
	public void createTest() {

		BudgetAllocation response = this.service.create(request);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.response, response);
	}

	@Test()
	public void createAllocationNullTest() {

		assertThrows(ApplicationException.class, () -> {
			this.service.create(null);
		});
	}
	
	@Test()
	public void createSpentAmountNullTest() {

		this.request.setSpentAmount(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.create(request);
		});
	}
	
	@Test()
	public void createBudgetNullTest() {

		this.request.setBudget(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.create(request);
		});
	}
}
