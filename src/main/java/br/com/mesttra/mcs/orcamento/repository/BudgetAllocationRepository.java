package br.com.mesttra.mcs.orcamento.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.mesttra.mcs.orcamento.entity.Budget;
import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;

/**
 * Repositório da entidade {@link BudgetAllocation}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Repository
public interface BudgetAllocationRepository extends JpaRepository<BudgetAllocation, Long> {

	/**
	 * Método que recupera o valor gasto total de um orçamento
	 * @param budget - orçamento
	 * @return BigDecimal
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2021
	 */
	@Query("SELECT SUM(a.spentAmount) FROM BudgetAllocation a WHERE a.budget = ?1")
	public BigDecimal findByBudget(Budget budget);
}
