package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ApiKey
{
    private static String FILENAME = "I:/Dokumenty/api_key/api_key.data";

    public ApiKey()
    {

    }

    public static String getApiKey() throws FileNotFoundException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILENAME)))
        {
            return reader.readLine();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        throw new FileNotFoundException("File not found!");
    }
}
