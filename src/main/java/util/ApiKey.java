package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ApiKey
{
    private static String FILENAME = "api_properties/apikey.properties";
    private static ApiKey instance = null;

    private ApiKey()
    {

    }

    public static ApiKey getInstance()
    {
        if(instance == null)
            instance = new ApiKey();

        return instance;
    }

    private static Properties PROPERTIES = new Properties();

    public String getApiKey()
    {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(FILENAME);

        try(BufferedReader input = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)))
        {
           PROPERTIES.load(input);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty("weather.api.key");
    }
}
