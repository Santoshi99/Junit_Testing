package test;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Assertions;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest {
	@Test
	@Tag("email")
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		//add your code here
		EmailValidator email = new EmailValidator();
		boolean isEmailValid = email.validateEmailId("Jame_Potter@Infy.com");
		Assertions.assertTrue(isEmailValid);
		
	}
    @Test
    @Tag("email")
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		//add your code here
    	EmailValidator email = new EmailValidator();
		boolean isEmailValid = email.validateEmailId("Jame_Potter@infy.org");
		Assertions.assertFalse(isEmailValid);
	}
    @Test
    @Tag("email")
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		//add your code here
    	EmailValidator email = new EmailValidator();
		
    	InfyAcademyException exception =Assertions.assertThrows(InfyAcademyException.class, ()->email.validateEmailId(" ") );
    	Assertions.assertEquals("Invalid Email ID", exception.getMessage());
	}
    @ParameterizedTest
    @Tag("email")
	@CsvSource(value = {"false, Sirius_Black","true,Lily_Evans@Hoggy.in","false,Remus_Lups","true,NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(boolean expected, String emailId) throws InfyAcademyException {
		//add your code here
    	EmailValidator email = new EmailValidator();
    	boolean actual = email.validateEmailId(emailId);
    	Assertions.assertEquals(expected,actual);
		
	}
}
