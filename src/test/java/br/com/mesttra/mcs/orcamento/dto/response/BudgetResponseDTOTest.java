package br.com.mesttra.mcs.orcamento.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;

/**
 * Classe de teste que representa os cenários de testes da classe {@link BudgetResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class BudgetResponseDTOTest {

	private Long id;

	private BigDecimal totalAmount;
	
	private BigDecimal totalSpentAmount;
	
	private LocalDateTime dtBudget;
	
	private SourceEnum source;
	
	private List<DestinationResponseDTO> destinations;
	
	private List<AllocationResponseDTO> allocations;

	private BudgetResponseDTO response;

	@BeforeEach
	public void setup() {

		this.id = EntityGenericUtil.getLong();
		this.totalAmount = EntityGenericUtil.getBigDecimal();
		this.totalSpentAmount = EntityGenericUtil.getBigDecimal();
		this.dtBudget = EntityGenericUtil.getDateTime();
		this.source = SourceEnum.FEDERAL;
		this.destinations = new LinkedList<DestinationResponseDTO>();
		this.allocations = new LinkedList<AllocationResponseDTO>();
		
		this.destinations.add(
				DestinationResponseDTO
				.builder()
				.id(this.id)
				.destinationType(DestinationTypeEnum.EDUCATION)
				.build());
		this.allocations.add(
				AllocationResponseDTO
				.builder()
				.id(this.id)
				.spentAmount(this.totalSpentAmount)
				.dtAllocation(EntityGenericUtil.getDateTime())
				.build());
		
		response = BudgetResponseDTO
				.builder()
				.id(this.id)
				.totalAmount(this.totalAmount)
				.totalSpentAmount(this.totalSpentAmount)
				.dtBudget(this.dtBudget)
				.source(this.source)
				.destinations(this.destinations)
				.allocations(this.allocations)
				.build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(response);
		assertEquals(this.id, response.getId());
		assertEquals(this.totalAmount, response.getTotalAmount());
		assertEquals(this.totalSpentAmount, response.getTotalSpentAmount());
		assertEquals(this.dtBudget, response.getDtBudget());
		assertEquals(this.source, response.getSource());
		assertEquals(this.destinations, response.getDestinations());
		assertEquals(this.allocations, response.getAllocations());
	}	

	@Test
	public void getInstanceVaziaTest() {

		response = new BudgetResponseDTO();

		assertNotNull(response);
		assertEquals(null, response.getId());
		assertEquals(null, response.getTotalAmount());
		assertEquals(null, response.getTotalSpentAmount());
		assertEquals(null, response.getDtBudget());
		assertEquals(null, response.getSource());
		assertEquals(null, response.getDestinations());
		assertEquals(null, response.getAllocations());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		response = BudgetResponseDTO.builder().build();

		response.setId(this.id);
		response.setTotalAmount(totalAmount);
		response.setTotalSpentAmount(totalSpentAmount);
		response.setDtBudget(dtBudget);
		response.setSource(source);
		response.setDestinations(destinations);
		response.setAllocations(allocations);

		assertEquals(this.id, response.getId());
		assertEquals(this.totalAmount, response.getTotalAmount());
		assertEquals(this.totalSpentAmount, response.getTotalSpentAmount());
		assertEquals(this.dtBudget, response.getDtBudget());
		assertEquals(this.source, response.getSource());
		assertEquals(this.destinations, response.getDestinations());
		assertEquals(this.allocations, response.getAllocations());
	}

	@Test
	public void getEqualsTest() {

		BudgetResponseDTO response2 = 
				BudgetResponseDTO
				.builder()
				.id(this.id)
				.totalAmount(this.totalAmount)
				.totalSpentAmount(this.totalSpentAmount)
				.dtBudget(this.dtBudget)
				.source(this.source)
				.destinations(this.destinations)
				.allocations(this.allocations)
				.build();

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response, response2);
	}

	@Test
	public void getHashCodeTest() {

		BudgetResponseDTO response2 = 
				BudgetResponseDTO
				.builder()
				.id(this.id)
				.totalAmount(this.totalAmount)
				.totalSpentAmount(this.totalSpentAmount)
				.dtBudget(this.dtBudget)
				.source(this.source)
				.destinations(this.destinations)
				.allocations(this.allocations)
				.build();

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response.hashCode(), response2.hashCode());
	}

	@Test
	public void getToStringTest() {

		assertNotNull(response);
		assertNotNull(response.toString());
	}
}
