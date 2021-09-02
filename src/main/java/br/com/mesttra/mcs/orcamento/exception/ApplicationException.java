package br.com.mesttra.mcs.orcamento.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;

import lombok.Getter;


/**
 * Classe que representa a customização das exceptions do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Getter
public class ApplicationException extends ResponseStatusException {

	private static final long serialVersionUID = 5101008253945611515L;
	
	private GenericValidation error;
	private List<String> parameters = new ArrayList<String>();

	/**
	 * Construtor da classe.
	 * @param error
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public ApplicationException(GenericValidation error) {
		
		super(error.getHttpStatus(), error.getErrorCode());
		
		this.error = error;
		this.parameters = new ArrayList<String>();
	}

	/**
	 * Construtor da classe.
	 * @param error
	 * @param ex
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public ApplicationException(GenericValidation error, Exception ex) {
		
		super(error.getHttpStatus(), error.getErrorCode(), ex);
		this.error = error;
		this.parameters = new ArrayList<String>();
	}

	/**
	 * Construtor da classe.
	 * @param erro
	 * @param parameters
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public ApplicationException(GenericValidation error, String... parameters) {
		
		super(error.getHttpStatus(), error.getErrorCode());
		this.error = error;
		this.parameters = Arrays.asList(parameters);
	}

	/**
	 * Construtor da classe.
	 * @param erro
	 * @param ex
	 * @param parameters
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public ApplicationException(GenericValidation error, Exception ex, String... parameters) {
		
		super(error.getHttpStatus(), error.getErrorCode(), ex);
		this.error = error;
		this.parameters = Arrays.asList(parameters);
	}

	/**
	 * Método que retorna a pilha de erros da excecução.
	 * @param t
	 * @return String - Uma String com a pilha de erros.
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static final String getErrorStack(Throwable t) {
		
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		t.printStackTrace(printWriter);
		
		return writer.toString();
	}
}
