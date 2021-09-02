package br.com.mesttra.mcs.orcamento.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;

/**
 * Interface que define os métodos do serviço para manter um {@link Budget}.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public interface BudgetService {
	
	/**
	 * Método que cria um novo orçamento.
	 * @param budget - orçamento
	 * @return Budget
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public Budget create(Budget budget) throws ApplicationException;
	
	/**
	 * Método que cria uma nova alocação de orçamento.
	 * @param id - id do orçamento
	 * @param allocation - alocação do orçamento
	 * @return Budget
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public Budget createBudgetAllocation(Long id, BudgetAllocation allocation) throws ApplicationException;
	
	/**
	 * Método que recupera um orçamento
	 * @param id - id do orçamento
	 * @return Budget
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public Budget retrieve(Long id) throws ApplicationException;
	
	/**
	 * Método que lista os orçamentos de acordo com os filtros
	 * @param budget - orçamento
	 * @param pageable - page
	 * @return Page<Budget>
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public Page<Budget> list(Budget budget, Pageable pageable) throws ApplicationException;
	

}
