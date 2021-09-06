package br.com.mesttra.mcs.orcamento.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Classe de teste que representa os cenários de testes da classe {@link DestinationTypeEnum}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class DestinationTypeEnumTest {

	@Test
	public void typeHealthTest() {
		
		assertEquals(DestinationTypeEnum.HEALTH, DestinationTypeEnum.getEnum(DestinationTypeEnum.HEALTH.getDestinationType()));
	}
	
	@Test
	public void typeEducationTest() {
		
		assertEquals(DestinationTypeEnum.EDUCATION, DestinationTypeEnum.getEnum(DestinationTypeEnum.EDUCATION.getDestinationType()));
	}
	
	@Test
	public void typeSportsTest() {
		
		assertEquals(DestinationTypeEnum.SPORTS, DestinationTypeEnum.getEnum(DestinationTypeEnum.SPORTS.getDestinationType()));
	}
	
	@Test
	public void typeInfrastructureTest() {
		
		assertEquals(DestinationTypeEnum.INFRASTRUCTURE, DestinationTypeEnum.getEnum(DestinationTypeEnum.INFRASTRUCTURE.getDestinationType()));
	}
	
	@Test
	public void typeOthersTest() {
		
		assertEquals(DestinationTypeEnum.OTHERS, DestinationTypeEnum.getEnum(DestinationTypeEnum.OTHERS.getDestinationType()));
	}
}
