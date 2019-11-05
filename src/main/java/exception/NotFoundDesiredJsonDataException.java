package exception;

public class NotFoundDesiredJsonDataException extends RuntimeException
{
    public NotFoundDesiredJsonDataException() {
    }

    public NotFoundDesiredJsonDataException(String message)
    {
        super(message);
    }
}
