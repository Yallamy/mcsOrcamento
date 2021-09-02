package br.com.mesttra.mcs.orcamento.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@SuppressWarnings("static-access")
public class ValidationCustomTest {
	
	@InjectMocks
	private ValidationCustom validationCustom;
	
	@Test
	public void validarRegexTrue() {
		
		String emailRegex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
		boolean response = validationCustom.validateRegex(emailRegex, "teste@gmail.com");
		
		assertTrue(response);
	}
	
	@Test
	public void validarRegexFalse() {
		
		String emailRegex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
		boolean response = validationCustom.validateRegex(emailRegex, "testegmail.com");
		
		assertFalse(response);
	}
	
	@Test
	public void validarRegexNull() {
		
		boolean response = validationCustom.validateRegex(null, "teste@gmail.com");
		
		assertFalse(response);
	}
	
	@Test
	public void validarRegexDadoNull() {
		
		String emailRegex = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$";
		boolean response = validationCustom.validateRegex(emailRegex, null);
		
		assertFalse(response);
	}

}
