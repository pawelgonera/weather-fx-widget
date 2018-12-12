package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApiKey
{
    private static String FILENAME = "api_key/api_key.data";

    public ApiKey()
    {

    }

    public static String getApiKey()
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME)))
        {
            return reader.readLine();

        }catch (IOException e)
        {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
