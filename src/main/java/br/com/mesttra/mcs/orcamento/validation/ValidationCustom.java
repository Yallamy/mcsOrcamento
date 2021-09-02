package br.com.mesttra.mcs.orcamento.validation;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import br.com.mesttra.mcs.orcamento.exception.ServiceEnumValidation;
import br.com.mesttra.mcs.orcamento.useful.Useful;
import br.com.mesttra.mcs.orcamento.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que possui as validações comuns do projeto
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 2 de set de 2021
 */
@Slf4j
public class ValidationCustom {
	
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	/**
	 * Método que valida o modelo de dados
	 * @param <E> - Tipo de classe
	 * @param <T> - Objeto do modelo a ser avaliado
	 * @param source - Objeto do modelo a ser avaliado
	 * @param destinationType - Tipo de classe
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static <E, T> void validateDataViolation(T source, Class<E> destinationType) throws ApplicationException {
		
		E sourceConv = Useful.convert(source, destinationType);
		
		Set<ConstraintViolation<E>> violations = validator.validate(sourceConv);

		if(violations.size() > BigDecimal.ZERO.intValue()) {
			
			for (ConstraintViolation<E> violation : violations) {
				log.error(violation.getMessage());
			}
			
			throw new ApplicationException(ServiceEnumValidation.DATA_VALIDATION);
		}
	}
	
	/**
	 * Método que realiza a validação dos objetos verificando se os mesmos estão
	 * null, e se sim, lança um SigadException.
	 * @param <T> - tipo do objeto
	 * @param source - objetos a serem validados
	 * @throws ApplicationException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	@SuppressWarnings("unchecked")
	public static <T> void validateConsistency(T... source) throws ApplicationException {
		
		for (T objeto : source) {
			if(Objects.isNull(objeto)) {
				throw new ApplicationException(ServiceEnumValidation.CONSISTENCY_ERROR);
			}
		}
	}
	
	/**
	 * Método que realiza a validação regex
	 * @param regex - regex
	 * @param data - dado a ser validado
	 * @return boolean - true se ocorreu um matche com o regex.
	 * false se o valor não for compatível com o regex
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 2 de set de 2021
	 */
	public static boolean validateRegex(String regex, String data) {
		
		if(Objects.isNull(regex) || Objects.isNull(data)) {
			return false;
		}
		
		return Pattern.compile(regex).matcher(data).matches();
	}

}
