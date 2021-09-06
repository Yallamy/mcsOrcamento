package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;

import br.com.mesttra.mcs.orcamento.enums.DestinationTypeEnum;
import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados de response do destino de orçamento para transferência 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = ConstantsSwagger.DESTINATION_RESPONSE_DTO)
public class DestinationResponseDTO implements Serializable {

	private static final long serialVersionUID = -8951645012997946800L;
	
	@ApiModelProperty(value = ConstantsSwagger.DESTINATION_RESPONSE_ID_DTO, position = 1)
	private Long id;
	
	@ApiModelProperty(value = ConstantsSwagger.DESTINATION_RESPONSE_TYPE_DTO, position = 2)
	private DestinationTypeEnum destinationType;
}
