package br.com.mesttra.mcs.orcamento.dto.request;

import java.io.Serializable;

import org.javamoney.moneta.Money;

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
public class AllocationRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 2568596479131479776L;
	
	private Money spentAmount; //TODO

}
