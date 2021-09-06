package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.javamoney.moneta.Money;

import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados de response da alocação de orçamento para transferência 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = ConstantsSwagger.ALLOCATION_RESPONSE_DTO)
public class AllocationResponseDTO implements Serializable {

	private static final long serialVersionUID = 5286594258994034207L;
	
	@ApiModelProperty(value = ConstantsSwagger.ALLOCATION_RESPONSE_ID_DTO, position = 1)
	private Long id;
	
	@ApiModelProperty(value = ConstantsSwagger.ALLOCATION_RESPONSE_SPENT_AMOUNT_DTO, position = 2)
	private Money spentAmount;
	
	@ApiModelProperty(value = ConstantsSwagger.ALLOCATION_RESPONSE_DT_DTO, position = 3)
	private LocalDateTime dtAllocation;
	
}
