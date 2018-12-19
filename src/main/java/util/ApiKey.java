package util;

import java.io.*;
import java.util.Properties;

public class ApiKey
{
    //private static String FILENAME = "src/main/resources/api_properties/apikey.properties";
    private static String FILENAME = "api_key/api_key.data";

    private static Properties PROPERTIES = new Properties();

    public ApiKey()
    {
        //PROPERTIES = new Properties();
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

    /*public static String getApiKey()
    {
        try(FileInputStream input = new FileInputStream(FILENAME))
        {
           PROPERTIES.load(input);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return PROPERTIES.getProperty("weather.api.key");
    }*/
}
