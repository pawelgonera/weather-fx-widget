package exception;

public class WrongServerStatusException extends RuntimeException
{
    public WrongServerStatusException(String message)
    {
        super(message);
    }

    public WrongServerStatusException(Throwable cause)
    {
        super(cause);
    }
}
