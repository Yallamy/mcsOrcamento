package br.com.mesttra.mcs.orcamento.exception;

import org.springframework.http.HttpStatus;

/**
 * Classe que implementa as validações genéricas do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
public enum ServiceEnumValidation implements GenericValidation{

	CONSISTENCY_ERROR("Objeto requerido null ou vazio", HttpStatus.BAD_REQUEST),
	DATA_VALIDATION("Objeto com violação de regras de dados do banco", HttpStatus.BAD_REQUEST),
	ARGUMENTS_VALIDATION("Validação dos argumentos", HttpStatus.BAD_REQUEST),
	INSUFFICIENT_FUNDS("O valor da alocação é maior do que o valor restante do orçamento", HttpStatus.BAD_REQUEST),
	BUDGET_NOT_FOUND("O orçamento não foi encontrado", HttpStatus.NOT_FOUND);
	
	private String errorCode;
	
	private HttpStatus httpStatus;

	/**
	 * Construtor privado da classe.
	 * @param errorCode
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	private ServiceEnumValidation(String errorCode, HttpStatus httpStatus) {
		this.errorCode = errorCode;
		this.httpStatus = httpStatus;
	}

	/**
	 * Método que retorna o código de erro referente a exception.
	 * @return String
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	@Override
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Método que retorna o código HTTP
	 * @return HttpStatus
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
}
