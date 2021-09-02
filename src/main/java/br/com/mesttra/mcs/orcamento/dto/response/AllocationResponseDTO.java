package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.javamoney.moneta.Money;

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
public class AllocationResponseDTO implements Serializable {

	private static final long serialVersionUID = 5286594258994034207L; //TODO
	
	private Long id;
	
	private Money spentAmount;
	
	private LocalDateTime dtAllocation;
	
}
