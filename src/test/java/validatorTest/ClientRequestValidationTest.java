package validatorTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;

import exception.WrongCityNameRequestException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import validator.ClientRequestValidation;
import static validator.ClientRequestValidation.*;

public class ClientRequestValidationTest
{
    private ClientRequestValidation validation;

    @BeforeEach
    public void setUp()
    {
        validation = new ClientRequestValidation();
    }

    @Test
    public void checkIsCityNameRequestValidateRegExTest()
    {
        String properCityNameRequestTest = "Kalisz";
        final boolean checkProperReguest = properCityNameRequestTest.matches(APPROPRIATE_CHARS.pattern());
        assertTrue(checkProperReguest);
    }

    @Test
    public void checkIsCityNameRequestValidateRegExWithUnicodeCharsTest()
    {
        String properCityNameRequestTest = "Chrząszczyżewoszyce";
        final boolean checkProperReguest = properCityNameRequestTest.matches(APPROPRIATE_CHARS.pattern());
        assertTrue(checkProperReguest);
    }

    @Test
    public void checkIsCityNameRequestNotValidateRegExWithNumbersTest()
    {
        String wrongCityNameRequestTest = "Kalisz48";
        final boolean checkWrongReguest = wrongCityNameRequestTest.matches(APPROPRIATE_CHARS.pattern());
        assertFalse(checkWrongReguest);
    }

    @Test
    public void checkIsCityNameRequestNotValidateRegExWithSpecialCharsTest()
    {
        String wrongCityNameRequestTest = "Kalisz^%";
        final boolean checkWrongRequest = wrongCityNameRequestTest.matches(APPROPRIATE_CHARS.pattern());
        assertFalse(checkWrongRequest);
    }

    @Test
    public void validateCityNameRequestTest() throws WrongCityNameRequestException
    {
        String properCityNameRequestTest = "Chrząszczyżewoszyce";
        final boolean isValidated = validation.validateCityNameRequest(properCityNameRequestTest);;
        assertTrue(isValidated);
    }

    @Test
    public void notValidateCityNameRequestTest()
    {
        String properCityNameRequestTest = "Kalisz-123";
        assertThrows(WrongCityNameRequestException.class, () -> validation.validateCityNameRequest(properCityNameRequestTest));
    }
}
