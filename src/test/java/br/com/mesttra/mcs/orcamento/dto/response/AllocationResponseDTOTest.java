package br.com.mesttra.mcs.orcamento.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link AllocationResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class AllocationResponseDTOTest {
	
	private Long id;

	private BigDecimal spentAmount;

	private LocalDateTime dtAllocation;

	private AllocationResponseDTO response;

	@BeforeEach
	public void setup() {

		this.id = EntityGenericUtil.getLong();
		this.spentAmount = EntityGenericUtil.getBigDecimal();
		this.dtAllocation = EntityGenericUtil.getDateTime();

		response = AllocationResponseDTO
				.builder()
				.id(this.id)
				.spentAmount(this.spentAmount)
				.dtAllocation(this.dtAllocation)
				.build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(response);
		assertEquals(this.id, response.getId());
		assertEquals(this.spentAmount, response.getSpentAmount());
		assertEquals(this.dtAllocation, response.getDtAllocation());
	}	

	@Test
	public void getInstanceVaziaTest() {

		response = new AllocationResponseDTO();

		assertNotNull(response);
		assertEquals(null, response.getId());
		assertEquals(null, response.getSpentAmount());
		assertEquals(null, response.getDtAllocation());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		response = AllocationResponseDTO.builder().build();

		response.setId(this.id);
		response.setSpentAmount(this.spentAmount);
		response.setDtAllocation(this.dtAllocation);

		assertEquals(this.id, response.getId());
		assertEquals(this.spentAmount, response.getSpentAmount());
		assertEquals(this.dtAllocation, response.getDtAllocation());
	}

	@Test
	public void getEqualsTest() {

		AllocationResponseDTO response2 = AllocationResponseDTO
				.builder()
				.id(this.id)
				.spentAmount(this.spentAmount)
				.dtAllocation(this.dtAllocation)
				.build();

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response, response2);
	}

	@Test
	public void getHashCodeTest() {

		AllocationResponseDTO response2 = AllocationResponseDTO
				.builder()
				.id(this.id)
				.spentAmount(this.spentAmount)
				.dtAllocation(this.dtAllocation)
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
