package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class UserNameApi
{
    private static String FILENAME = "I:/Dokumenty/api_key/userNameApi.data";

    public UserNameApi()
    {

    }

    public static String getUserName() throws FileNotFoundException
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
