package exception;

public class WrongCityNameRequestException extends Exception
{
    public WrongCityNameRequestException()
    {
    }

    public WrongCityNameRequestException(String message)
    {
        super(message);
    }
}
