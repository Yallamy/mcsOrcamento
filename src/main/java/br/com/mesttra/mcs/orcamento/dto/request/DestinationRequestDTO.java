package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import br.com.mesttra.mcs.orcamento.useful.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = ConstantsSwagger.DESTINATION_REQUEST_DTO)
public class DestinationRequestDTO implements Serializable {

	private static final long serialVersionUID = 149825511475798281L;
	
	@ApiModelProperty(value = ConstantsSwagger.DESTINATION_REQUEST_TYPE_DTO, position = 1)
	@NotNull(message = Message.TYPE_DESTINATION_REQUIRED)
	private String destinationType;

}
