package br.com.mesttra.mcs.orcamento.useful;

import static java.util.Objects.isNull;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 *  Classe que providencia um produtor de Validator
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 10 de set. de 2021
 */
public class ValidatorProducer {

	private static Validator validator;

	private ValidatorProducer() {}

	/**
	 * Construtor da classe.
	 * @return Validator
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 10 de set. de 2021
	 */
	public static Validator getValidator() {
		if(isNull(validator)) {
			init();
		}
		return validator;
	}

	/**
	 * Método que inicializa o Validator
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 10 de set. de 2021
	 */
	private static void init() {
		validator = Validation.buildDefaultValidatorFactory().getValidator();
	}
}
