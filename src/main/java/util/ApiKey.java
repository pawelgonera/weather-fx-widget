package util;

import java.io.*;
import java.util.Properties;

public class ApiKey
{
    private static String FILENAME = "src/main/resources/api_properties/apikey.properties";

    private static Properties PROPERTIES = new Properties();

    public static String getApiKey()
    {
        try(FileInputStream input = new FileInputStream(FILENAME))
        {
           PROPERTIES.load(input);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty("weather.api.key");
    }
}
