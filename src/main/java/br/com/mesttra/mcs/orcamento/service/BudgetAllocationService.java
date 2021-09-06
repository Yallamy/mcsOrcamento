package br.com.mesttra.mcs.orcamento.service;

import java.math.BigDecimal;

import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;

/**
 * Interface que define os métodos do serviço para manter um {@link BudgetAllocation}.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public interface BudgetAllocationService {
	
	/**
	 * Método que cria uma nova alocação para o orçamento.
	 * @param budgetAllocation - alocação de orçamento
	 * @return BudgetAllocation
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public BudgetAllocation create(BudgetAllocation budgetAllocation) throws ApplicationException;
	
	/**
	 * Método que recupera o valor total gasto em um orçamento
	 * @param budget - orçamento
	 * @return BigDecimal
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2021
	 */
	public BigDecimal getTotalSpentAmount(Budget budget) throws ApplicationException;

}
