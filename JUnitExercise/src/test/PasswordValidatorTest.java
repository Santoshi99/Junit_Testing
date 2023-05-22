package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.infy.exception.InfyAcademyException;
import application.PasswordValidator;;

public class PasswordValidatorTest {
	
	@Test
	@Tag("password")
	public void validatePasswordValidPassword() throws InfyAcademyException {
		//add your code here
		PasswordValidator password = new PasswordValidator();
		boolean actual = password.validatePassword("Asdf1234");
		Assertions.assertTrue(actual);
		
	}
	@Test
	@Tag("password")
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		//add your code here
		PasswordValidator password = new PasswordValidator();
		boolean actual = password.validatePassword("Asdf");
		Assertions.assertFalse(actual);
	}
	@Test
	@Tag("password")
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		//add your code here
		PasswordValidator password = new PasswordValidator();
		InfyAcademyException exception = Assertions.assertThrows(InfyAcademyException.class, ()->password.validatePassword(null));
	    Assertions.assertEquals("Invalid Password.", exception.getMessage());
	}
	
	@ParameterizedTest
	@Tag("password")
	@CsvSource(value = {"false,Qwerty","true,Qwerty1234","false,QwertyAsdfZxcvVcxzFdsaRewq","true,Zxcvb54321"})
	public void validatePasswordParameterizedPassword(boolean expected, String pass) throws InfyAcademyException {
		//add your code here
		PasswordValidator password = new PasswordValidator();
		boolean actual = password.validatePassword(pass);
		Assertions.assertEquals(expected, actual);
		
	}
}