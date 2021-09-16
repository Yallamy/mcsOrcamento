package br.com.mesttra.mcs.orcamento.dto.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDTO implements Serializable {
	
	private static final long serialVersionUID = -8687676596550126059L;

	private String errorCode;
	
	private HttpStatus httpStatus;

}
