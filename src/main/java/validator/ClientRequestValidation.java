package validator;

import exception.WrongCityNameRequestException;
import java.util.regex.Pattern;

public class ClientRequestValidation
{
    public final static Pattern APPROPRIATE_CHARS = Pattern.compile("[a-zA-Z]*\\p{IsAlphabetic}*");
    private static ClientRequestValidation instance = null;

    public static ClientRequestValidation getInstance()
    {
        if(instance == null)
            instance = new ClientRequestValidation();

        return instance;
    }

    public boolean validateCityNameRequest(String cityNameRequest) throws WrongCityNameRequestException
    {
        if(!isStartedWithUpperLetter(cityNameRequest))
            throw new WrongCityNameRequestException(cityNameRequest + " is not started with uppercase letter");


        if(!isContainsAppropriateCharacters(cityNameRequest))
            throw new WrongCityNameRequestException(cityNameRequest + " contains not appropriate characters");

        return true;
    }

    private boolean isStartedWithUpperLetter(String cityName)
    {
        if(Character.isUpperCase(cityName.charAt(0)))
        {
            return true;
        }

        return false;
    }

    private boolean isContainsAppropriateCharacters(String cityName)
    {
        if(cityName.matches(APPROPRIATE_CHARS.pattern()))
        {
            return true;
        }

        return false;
    }
}
