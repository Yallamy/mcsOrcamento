package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os erros da aplicação 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 02 de set de 2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO implements Serializable {
	
	private static final long serialVersionUID = -8687676596550126059L;

	private String errorCode;
	
	private HttpStatus httpStatus;
	
	private LocalDateTime timestamp;
	
	private List<String> detail;

}
