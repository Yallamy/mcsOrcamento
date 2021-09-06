package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.javamoney.moneta.Money;

import br.com.mesttra.mcs.orcamento.useful.ConstantsSwagger;
import br.com.mesttra.mcs.orcamento.useful.Message;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados de request da alocação de orçamento para transferência 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = ConstantsSwagger.ALLOCATION_REQUEST_DTO)
public class AllocationRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 2568596479131479776L;
	
	@ApiModelProperty(value = ConstantsSwagger.ALLOCATION_REQUEST_SPENT_AMOUNT_DTO, position = 1)
	@NotNull(message = Message.SPENT_AMOUNT_REQUIRED)
	private Money spentAmount;

}
