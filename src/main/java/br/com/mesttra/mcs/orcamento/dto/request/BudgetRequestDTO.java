package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

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

 * Classe que encapsula os dados de request do orçamento para transferência
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = ConstantsSwagger.BUDGET_REQUEST_DTO)
public class BudgetRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 8251455118980724338L;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_REQUEST_TOTAL_AMOUNT_DTO, position = 1)
	@NotNull(message = Message.TOTAL_AMOUNT_REQUIRED)
	private BigDecimal totalAmount;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_REQUEST_SOURCE_DTO, position = 2)
	@NotNull(message = Message.SOURCE_REQUIRED)
	private String source;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_REQUEST_DESTINATIONS_DTO, position = 3)
	@NotNull(message = Message.DESTINATIONS_REQUIRED)
	private List<DestinationRequestDTO> destinations;
	
}
