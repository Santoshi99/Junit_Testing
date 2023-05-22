package test;

import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import test.PasswordValidatorTest;
import test.EmailValidatorTest;


@RunWith(JUnitPlatform.class)
@SelectClasses({PasswordValidatorTest.class, EmailValidatorTest.class})
@IncludeTags({"email" , "password"})
public class TestSuite {

}