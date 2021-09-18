package br.com.mesttra.mcs.orcamento.exception;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	public ResponseEntity<ErrorDTO> handleApplicationException(ApplicationException ex) {
		
		ErrorDTO error = 
				ErrorDTO
				.builder()
				.errorCode(ex.getError().getErrorCode())
				.httpStatus(ex.getError().getHttpStatus())
				.timestamp(LocalDateTime.now())
				.detail(new LinkedList<String>())
				.build();
		
		log.error("Error code: " + error.getErrorCode());
		log.error("HTTP Status: " + error.getHttpStatus());
	
		return new ResponseEntity<ErrorDTO>(error, error.getHttpStatus()); 
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException ex) {
		
		List<String> detail = new LinkedList<String>();
		detail.add(ex.getMessage());
		
		ErrorDTO error = 
				ErrorDTO
				.builder()
				.errorCode(ServiceEnumValidation.ARGUMENTS_VALIDATION.getErrorCode())
				.httpStatus(ServiceEnumValidation.ARGUMENTS_VALIDATION.getHttpStatus())
				.timestamp(LocalDateTime.now())
				.detail(detail)
				.build();
		
		log.error("Error code: " + error.getErrorCode());
		log.error("HTTP Status: " + error.getHttpStatus());
	
		return new ResponseEntity<ErrorDTO>(error, error.getHttpStatus()); 
	}

}
