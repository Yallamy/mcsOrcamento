package br.com.mesttra.mcs.orcamento.exception;

import org.springframework.http.HttpStatus;

/**
 * Interface que representa as validações genericas do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public interface GenericValidation {
	
	/**
	 * Método que retorna o código de erro referente a exception.
	 * @return String
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public String getErrorCode();
	
	/**
	 * Método que retorna o HttpStatus referente a Exception
	 * @return HttpStatus
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public HttpStatus getHttpStatus();

}
