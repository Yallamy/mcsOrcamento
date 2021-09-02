package br.com.mesttra.mcs.orcamento.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mesttra.mcs.orcamento.entity.Destination;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import br.com.mesttra.mcs.orcamento.repository.DestinationRepository;
import br.com.mesttra.mcs.orcamento.service.DestinationService;
import br.com.mesttra.mcs.orcamento.validation.ValidationCustom;
import lombok.RequiredArgsConstructor;

/**
 * Classe que implementa os métodos do serviço para manter a destinação do orçamento.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Service
@Transactional
@RequiredArgsConstructor
public class DestinationServiceImpl implements DestinationService {

	private final DestinationRepository repository;
	
	/*
	 * 
	 * (non-Javadoc)
	 * @see br.com.mesttra.mcs.orcamento.service.DestinationService#create(br.com.mesttra.mcs.orcamento.entity.Destination)
	 */
	@Override
	public Destination create(Destination destination) throws ApplicationException {
		
		ValidationCustom.validateConsistency(destination);
		ValidationCustom.validateDataViolation(destination, destination.getClass());
		
		return repository.save(destination);
	}

}
