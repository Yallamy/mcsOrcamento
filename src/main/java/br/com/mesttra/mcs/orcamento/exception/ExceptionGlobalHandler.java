package br.com.mesttra.mcs.orcamento.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mesttra.mcs.orcamento.dto.response.ErrorDTO;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que fornece a customização do controle das exceptions
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@ControllerAdvice
@Slf4j
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(value = ApplicationException.class)
	public ResponseEntity<ErrorDTO> handleValidationException(ApplicationException ex) {
		
		ErrorDTO error = 
				ErrorDTO
				.builder()
				.errorCode(ex.getError().getErrorCode())
				.httpStatus(ex.getError().getHttpStatus())
				.build();
		
		log.error("Error code: " + error.getErrorCode());
		log.error("HTTP Status: " + error.getHttpStatus());
	
		return new ResponseEntity<ErrorDTO>(error, error.getHttpStatus()); 
	}

}
