package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados de response do orçamento para transferência 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = ConstantsSwagger.BUDGET_RESPONSE_DTO)
public class BudgetResponseDTO implements Serializable {

	private static final long serialVersionUID = 117364367715712019L; //TODO
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_ID_DTO, position = 1)
	private Long id;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_TOTAL_AMOUNT_DTO, position = 2)
	private BigDecimal totalAmount;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_TOTAL_SPENT_AMOUNT_DTO, position = 3)
	private BigDecimal totalSpentAmount;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_DT_DTO, position = 4)
	private LocalDateTime dtBudget;

	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_SOURCE_DTO, position = 5)
	private SourceEnum source;

	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_DESTINATIONS_DTO, position = 6)
	private List<DestinationResponseDTO> destinations;
	
	@ApiModelProperty(value = ConstantsSwagger.BUDGET_RESPONSE_ALLOCATIONS_DTO, position = 7)
	private List<AllocationResponseDTO> allocations;

}
