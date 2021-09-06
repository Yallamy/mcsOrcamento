package br.com.mesttra.mcs.orcamento.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.BudgetRepository;
import br.com.mesttra.mcs.orcamento.service.BudgetAllocationService;

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
	
	@Mock
	private BudgetAllocationService budgetAllocationService;
	
	@Mock
	private Pageable pageable;
	
	@Mock
	private Page<Budget> page;
	
	private Budget request;
	
	private Budget response;
	
	private BudgetAllocation requestAllocation;
	
	private BudgetAllocation responseAllocation;
	
	private Destination responseDestination;
	
	private List<Destination> destinations;
	
	@SuppressWarnings("unchecked")
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
		
		this.requestAllocation = BudgetAllocation.builder().spentAmount(EntityGenericUtil.getBigDecimal()).build();
		this.responseAllocation = BudgetAllocation.builder().id(EntityGenericUtil.getLong()).spentAmount(EntityGenericUtil.getBigDecimal()).build();
		
		this.responseDestination = Destination
				.builder().id(EntityGenericUtil.getLong())
				.destinationType(DestinationTypeEnum.EDUCATION).build();

		Mockito.when(this.repository.save(
				Mockito.any(Budget.class))).thenReturn(this.response);
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenReturn(Optional.of(this.response));
		Mockito.when(this.repository.findAll(
				Mockito.any(Example.class), Mockito.any(Pageable.class))).thenReturn(this.page);
		Mockito.when(this.destinationService.create(
				Mockito.any(Destination.class))).thenReturn(this.responseDestination);
		Mockito.when(this.budgetAllocationService.getTotalSpentAmount(
				Mockito.any(Budget.class))).thenReturn(BigDecimal.ZERO);
		Mockito.when(this.budgetAllocationService.create(
				Mockito.any(BudgetAllocation.class))).thenReturn(this.responseAllocation);
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
	
	//create allocation
	@Test
	public void createAllocationTest() {

		Budget response = this.service.createBudgetAllocation(this.response.getId(), this.requestAllocation);

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.response, response);
	}

	@Test()
	public void createAllocationIdNullTest() {

		assertThrows(ApplicationException.class, () -> {
			this.service.createBudgetAllocation(null, this.requestAllocation);
		});
	}
	
	@Test()
	public void createAllocationNullTest() {

		this.request.setTotalAmount(null);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.createBudgetAllocation(response.getId(), null);
		});
	}
	
	@Test()
	public void createAllocationFundosInsuficientesTest() {

		this.response.setTotalAmount(BigDecimal.ONE);
		
		Mockito.when(this.budgetAllocationService.getTotalSpentAmount(
				Mockito.any(Budget.class))).thenReturn(BigDecimal.ONE);
		
		assertThrows(ApplicationException.class, () -> {
			this.service.createBudgetAllocation(response.getId(), this.requestAllocation);
		});
	}

	//retrieve
	@Test
	public void retrieveTest() {

		Budget response = this.service.retrieve(EntityGenericUtil.getLong());

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.response, response);
	}

	@Test()
	public void retrieveNotFoundTest() {

		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenThrow(NoSuchElementException.class);

		assertThrows(ApplicationException.class, () -> {
			this.service.retrieve(EntityGenericUtil.getLong());
		});
	}

	@Test()
	public void retrieveComNullTest() {

		Long id = null;

		assertThrows(ApplicationException.class, () -> {
			this.service.retrieve(id);
		});
	}
	
	//list
	@Test
	public void listTest() {

		Budget request = Budget.builder()
				.build();

		Page<Budget> response = this.service.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}

	@Test
	public void listComInteressadoNullTest() {

		Page<Budget> response = this.service.list(null, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}

	@Test()
	public void listComPageableNullTest() {

		assertThrows(ApplicationException.class, () -> {
			this.service.list(this.request, null);
		});
	}

	@Test
	public void listPorDtBudgetTest() {

		Budget request = Budget.builder()
				.dtBudget(EntityGenericUtil.getDateTime())
				.build();

		Page<Budget> response = this.service.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorSourceTest() {

		Budget request = Budget.builder()
				.source(SourceEnum.FEDERAL)
				.build();

		Page<Budget> response = this.service.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorDestinationTest() {

		Budget request = Budget.builder()
				.destinations(destinations)
				.build();

		Page<Budget> response = this.service.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
}
