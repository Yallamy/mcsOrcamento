package br.com.mesttra.mcs.orcamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mesttra.mcs.orcamento.entity.Destination;

/**
 * Repositório da entidade {@link Destination}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Repository
public interface DestinationRepository extends JpaRepository<Destination, Long> {

}
