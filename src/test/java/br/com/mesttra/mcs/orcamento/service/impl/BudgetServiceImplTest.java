package br.com.mesttra.mcs.orcamento.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;
import java.util.List;

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
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.BudgetRepository;

/**
 * Classe de teste que representa os cenários de testes da classe {@link BudgetServiceImpl}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
@SpringBootTest
public class BudgetServiceImplTest {

	@InjectMocks
	private BudgetServiceImpl service;
	
	@Mock
	private BudgetRepository repository;
	
	@Mock
	private DestinationServiceImpl destinationService;
	
	private Budget request;
	
	private Budget response;
	
	private Destination responseDestination;
	
	private List<Destination> destinations;
	
	@BeforeEach
	public void setup() {
		
		this.destinations = new LinkedList<Destination>();
		this.destinations.add(
				Destination.builder().destinationType(DestinationTypeEnum.EDUCATION).build());
		
		this.request = Budget
				.builder()
				.totalAmount(EntityGenericUtil.getBigDecimal())
				.source(SourceEnum.FEDERAL)
				.destinations(destinations)
				.build();
		
		this.response = Budget
				.builder()
				.id(EntityGenericUtil.getLong())
				.totalAmount(EntityGenericUtil.getBigDecimal())
				.source(SourceEnum.FEDERAL)
				.destinations(destinations)
				.dtBudget(EntityGenericUtil.getDateTime())
				.build();
		
		this.responseDestination = Destination
				.builder().id(EntityGenericUtil.getLong())
				.destinationType(DestinationTypeEnum.EDUCATION).build();

		Mockito.when(this.repository.save(
				Mockito.any(Budget.class))).thenReturn(this.response);
		Mockito.when(this.destinationService.create(
				Mockito.any(Destination.class))).thenReturn(this.responseDestination);
	}
	
	//create
	@Test
	public void createTest() {

		Budget response = this.service.create(request);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.response, response);
	}

	@Test()
	public void createBudgetNullTest() {

		assertThrows(ApplicationException.class, () -> {
			this.service.create(null);
		});
	}
	
	@Test()
	public void createTotalAmountNullTest() {

		this.request.setTotalAmount(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.create(request);
		});
	}
	
	@Test()
	public void createSourceNullTest() {

		this.request.setSource(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.create(request);
		});
	}
	
	@Test()
	public void createDestinationsNullTest() {

		this.request.setDestinations(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.create(request);
		});
	}
}
