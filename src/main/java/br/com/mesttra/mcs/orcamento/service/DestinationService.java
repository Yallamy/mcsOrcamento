package br.com.mesttra.mcs.orcamento.service;

import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;

/**
 * Interface que define os métodos do serviço para manter um {@link Destination}.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public interface DestinationService {

	/**
	 * Método que cria um novo destino do orçamento
	 * @param destination - Destino do orçamento 
	 * @return Destination
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public Destination create(Destination destination) throws ApplicationException;
}
