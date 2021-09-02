package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;
import java.util.List;

import org.javamoney.moneta.Money;

import br.com.mesttra.mcs.orcamento.enums.SourceEnum;
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
public class BudgetRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 8251455118980724338L;
	
	private Money totalAmount;
	
	private SourceEnum source;
	
	private List<DestinationRequestDTO> destinations;//TODO
	
	

}
