package br.com.mesttra.mcs.orcamento.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Enum que apresenta as possíveis origens do orçamento
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SourceEnum {
	
	FEDERAL("FEDERAL"),
	STATE("STATE"),
	COUNTY("COUNTY");
	
	private String source;
	
	/**
	 * Método que retorna a origem de um orçamento
	 * @param source
	 * @return SourceEnum
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static SourceEnum getEnum(String source) {
		
		return Arrays.asList(values()).stream().filter(
				tr -> tr.source.equals(source)).findFirst().orElse(null);
	}

}
