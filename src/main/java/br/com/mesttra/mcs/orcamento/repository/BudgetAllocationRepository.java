package br.com.mesttra.mcs.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.mcs.orcamento.entity.BudgetAllocation;

/**
 * Repositório da entidade {@link BudgetAllocation}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Repository
public interface BudgetAllocationRepository extends JpaRepository<BudgetAllocation, Long>{

}
