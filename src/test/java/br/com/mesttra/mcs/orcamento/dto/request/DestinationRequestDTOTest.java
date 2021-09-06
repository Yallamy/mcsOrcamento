package br.com.mesttra.mcs.orcamento.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;

/**
 * Classe de teste que representa os cenários de testes da classe {@link DestinationRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class DestinationRequestDTOTest {

	private Validator validator;

	private DestinationTypeEnum destinationType;
	
	private DestinationRequestDTO request;
	
	@BeforeEach
	public void setup() {

		this.destinationType = DestinationTypeEnum.EDUCATION;

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
		
		this.request = DestinationRequestDTO.builder().destinationType(this.destinationType).build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(request);
		assertEquals(this.destinationType, request.getDestinationType());
	}	
	
	@Test
	public void getInstanceVaziaTest() {

		request = new DestinationRequestDTO();

		assertNotNull(request);
		assertEquals(null, request.getDestinationType());
	}

	@Test
	public void getInstanceSpentAmountNullTest() {
		
		request.setDestinationType(null);

		assertNotNull(request);
		Set<ConstraintViolation<DestinationRequestDTO>> violations = 
				validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void setAndGetAllFieldsTest() {

		request = DestinationRequestDTO.builder().build();
		request.setDestinationType(this.destinationType);

		assertEquals(this.destinationType, request.getDestinationType());
	}

	@Test
	public void getEqualsTest() {

		DestinationRequestDTO request2 = 
				DestinationRequestDTO.builder().destinationType(this.destinationType).build();

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}

	@Test
	public void getHashCodeTest() {

		DestinationRequestDTO request2 = 
				DestinationRequestDTO.builder().destinationType(this.destinationType).build();

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
