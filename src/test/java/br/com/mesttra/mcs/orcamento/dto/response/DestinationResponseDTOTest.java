package br.com.mesttra.mcs.orcamento.dto.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.mesttra.mcs.orcamento.EntityGenericUtil;
import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;

/**
 * Classe de teste que representa os cenários de testes da classe {@link DestinationResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class DestinationResponseDTOTest {
	
	private Long id;

	private DestinationTypeEnum destinationType;

	private DestinationResponseDTO response;

	@BeforeEach
	public void setup() {

		this.id = EntityGenericUtil.getLong();
		this.destinationType = DestinationTypeEnum.EDUCATION;

		response = DestinationResponseDTO
				.builder()
				.id(this.id)
				.destinationType(this.destinationType)
				.build();
	}

	@Test
	public void getInstanceTest() {

		assertNotNull(response);
		assertEquals(this.id, response.getId());
		assertEquals(this.destinationType, response.getDestinationType());
	}	

	@Test
	public void getInstanceVaziaTest() {

		response = new DestinationResponseDTO();

		assertNotNull(response);
		assertEquals(null, response.getId());
		assertEquals(null, response.getDestinationType());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		response = DestinationResponseDTO.builder().build();

		response.setId(this.id);
		response.setDestinationType(this.destinationType);

		assertEquals(this.id, response.getId());
		assertEquals(this.destinationType, response.getDestinationType());
	}

	@Test
	public void getEqualsTest() {

		DestinationResponseDTO response2 = DestinationResponseDTO
				.builder()
				.id(this.id)
				.destinationType(this.destinationType)
				.build();

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response, response2);
	}

	@Test
	public void getHashCodeTest() {

		DestinationResponseDTO response2 = DestinationResponseDTO
				.builder()
				.id(this.id)
				.destinationType(this.destinationType)
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
