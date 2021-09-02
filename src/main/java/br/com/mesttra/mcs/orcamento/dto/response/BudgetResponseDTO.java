package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.javamoney.moneta.Money;

import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
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
public class BudgetResponseDTO implements Serializable {

	private static final long serialVersionUID = 117364367715712019L; //TODO
	
	private Long id;
	
	private Money totalAmount;
	
	private Money spentAmount;
	
	private LocalDateTime dtBudget;

	private SourceEnum source;

	private List<Destination> destinations;
	
	private List<BudgetAllocation> allocations;

}
