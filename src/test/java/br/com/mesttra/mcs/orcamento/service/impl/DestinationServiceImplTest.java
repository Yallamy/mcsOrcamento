package br.com.mesttra.mcs.orcamento.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.DestinationRepository;

/**
 * Classe de teste que representa os cenários de testes da classe {@link DestinationServiceImpl}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
@SpringBootTest
public class DestinationServiceImplTest {

	@InjectMocks
	private DestinationServiceImpl service;
	
	@Mock
	private DestinationRepository repository;
	
	private Destination request;
	
	private Destination response;
	
	@BeforeEach
	public void setup() {
		
		Budget budget = Budget.builder().id(EntityGenericUtil.getLong()).build();
		
		this.request = Destination
				.builder()
				.destinationType(DestinationTypeEnum.EDUCATION)
				.budget(budget)
				.build();
		
		this.response = Destination
				.builder()
				.id(EntityGenericUtil.getLong())
				.destinationType(DestinationTypeEnum.EDUCATION)
				.budget(budget)
				.build();

		Mockito.when(this.repository.save(
				Mockito.any(Destination.class))).thenReturn(this.response);
	}
	
	//create
	@Test
	public void createTest() {

		Destination response = this.service.create(request);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.response, response);
	}

	@Test()
	public void createDestinationNullTest() {

		assertThrows(ApplicationException.class, () -> {
			this.service.create(null);
		});
	}
	
	@Test()
	public void createDestinationTypeNullTest() {

		this.request.setDestinationType(null);
		
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
