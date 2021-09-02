package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;

import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados de request do destino do orçamento para transferência
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DestinationRequestDTO implements Serializable {

	private static final long serialVersionUID = 149825511475798281L;
	
	private DestinationTypeEnum destinationType; //TODO

}
