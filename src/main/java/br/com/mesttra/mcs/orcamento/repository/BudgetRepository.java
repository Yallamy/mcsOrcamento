package br.com.mesttra.mcs.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.mcs.orcamento.entity.Budget;

/**
 * Repositório da entidade {@link Budget}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
