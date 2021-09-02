package br.com.mesttra.mcs.orcamento.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum que apresenta os possíveis tipos de destinação do orçamento
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DestinationTypeEnum {
	
	HEALTH("HEALTH"),
	EDUCATION("EDUCATION"),
	SPORTS("SPORTS"),
	INFRASTRUCTURE("INFRASTRUCTURE"),
	OTHERS("OTHERS");
	
	private String destinationType;
	
	/**
	 * Método que retorna o tipo de destinação de um orçamento
	 * @param destinationType
	 * @return DestinationTypeEnum
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static DestinationTypeEnum getTypeDestination(String destinationType) {
		
		return Arrays.asList(values()).stream().filter(
				tr -> tr.destinationType.equals(destinationType)).findFirst().orElse(OTHERS);
	}

}
