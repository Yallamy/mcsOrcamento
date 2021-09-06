package br.com.mesttra.mcs.orcamento.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link AllocationRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class AllocationRequestDTOtest {
	
	private Validator validator;
	
	private BigDecimal spentAmount;
	
	private AllocationRequestDTO request;
	
	@BeforeEach
	public void setup() {

		this.spentAmount = EntityGenericUtil.getBigDecimal();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
		
		this.request = AllocationRequestDTO.builder().spentAmount(this.spentAmount).build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(request);
		assertEquals(this.spentAmount, request.getSpentAmount());
	}	
	
	@Test
	public void getInstanceVaziaTest() {

		request = new AllocationRequestDTO();

		assertNotNull(request);
		assertEquals(null, request.getSpentAmount());
	}

	@Test
	public void getInstanceSpentAmountNullTest() {
		
		request.setSpentAmount(null);

		assertNotNull(request);
		Set<ConstraintViolation<AllocationRequestDTO>> violations = 
				validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void setAndGetAllFieldsTest() {

		request = AllocationRequestDTO.builder().build();
		request.setSpentAmount(this.spentAmount);

		assertEquals(this.spentAmount, request.getSpentAmount());
	}

	@Test
	public void getEqualsTest() {

		AllocationRequestDTO request2 = 
				AllocationRequestDTO.builder().spentAmount(this.spentAmount).build();

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}

	@Test
	public void getHashCodeTest() {

		AllocationRequestDTO request2 = 
				AllocationRequestDTO.builder().spentAmount(this.spentAmount).build();

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request.hashCode(), request2.hashCode());
	}

	@Test
	public void getToStringTest() {

		assertNotNull(request);
		assertNotNull(request.toString());
	}

}
