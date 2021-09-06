package br.com.mesttra.mcs.orcamento.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Classe de teste que representa os cenários de testes da classe {@link SourceEnum}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2021
 */
public class SourceEnumTest {
	
	@Test
	public void sourceFederalTest() {
		
		assertEquals(SourceEnum.FEDERAL, SourceEnum.getEnum(SourceEnum.FEDERAL.getSource()));
	}
	
	@Test
	public void sourceStateTest() {
		
		assertEquals(SourceEnum.STATE, SourceEnum.getEnum(SourceEnum.STATE.getSource()));
	}
	
	@Test
	public void sourceCountyTest() {
		
		assertEquals(SourceEnum.COUNTY, SourceEnum.getEnum(SourceEnum.COUNTY.getSource()));
	}

}
