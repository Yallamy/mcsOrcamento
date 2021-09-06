package br.com.mesttra.mcs.orcamento.dto.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;

/**
 * Classe de teste que representa os cenários de testes da classe {@link BudgetRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class BudgetRequestDTOTest {
	
	private Validator validator;

	private BigDecimal totalAmount;
	
	private SourceEnum source;
	
	private List<DestinationRequestDTO> destinations;
	
	private BudgetRequestDTO request;
	
	@BeforeEach
	public void setup() {

		this.totalAmount = EntityGenericUtil.getBigDecimal();
		this.source = SourceEnum.FEDERAL;
		this.destinations = new LinkedList<DestinationRequestDTO>();
		this.destinations.add(DestinationRequestDTO
				.builder().destinationType(DestinationTypeEnum.EDUCATION).build());     
		

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		this.validator = factory.getValidator();
		
		this.request = BudgetRequestDTO
				.builder()
				.totalAmount(totalAmount)
				.source(source)
				.destinations(destinations)
				.build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(request);
		assertEquals(this.totalAmount, request.getTotalAmount());
		assertEquals(this.source, request.getSource());
		assertEquals(this.destinations, request.getDestinations());
	}	
	
	@Test
	public void getInstanceVaziaTest() {

		request = new BudgetRequestDTO();

		assertNotNull(request);
		assertEquals(null, request.getTotalAmount());
		assertEquals(null, request.getSource());
		assertEquals(null, request.getDestinations());
	}

	@Test
	public void getInstanceTotalAmountNullTest() {
		
		request.setTotalAmount(null);

		assertNotNull(request);
		Set<ConstraintViolation<BudgetRequestDTO>> violations = 
				validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void getInstanceSourceNullTest() {
		
		request.setSource(null);

		assertNotNull(request);
		Set<ConstraintViolation<BudgetRequestDTO>> violations = 
				validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void getInstanceDestinationsNullTest() {
		
		request.setDestinations(null);

		assertNotNull(request);
		Set<ConstraintViolation<BudgetRequestDTO>> violations = 
				validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void setAndGetAllFieldsTest() {

		request = BudgetRequestDTO.builder().build();
		request.setTotalAmount(this.totalAmount);
		request.setSource(this.source);
		request.setDestinations(this.destinations);

		assertEquals(this.totalAmount, request.getTotalAmount());
		assertEquals(this.source, request.getSource());
		assertEquals(this.destinations, request.getDestinations());
	}

	@Test
	public void getEqualsTest() {

		BudgetRequestDTO request2 = 
				BudgetRequestDTO
				.builder()
				.totalAmount(totalAmount)
				.source(source)
				.destinations(destinations)
				.build();

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}

	@Test
	public void getHashCodeTest() {

		BudgetRequestDTO request2 = 
				BudgetRequestDTO
				.builder()
				.totalAmount(totalAmount)
				.source(source)
				.destinations(destinations)
				.build();

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
