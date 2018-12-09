package util;

import java.io.*;

public class SaveCityName
{
    private final static String LOCATION = "city/city_name.data";

    private static File FILE;

    public SaveCityName()
    {

        FILE = new File(LOCATION);
        try
        {
            FILE.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public String saveCityName(String cityName) throws FileNotFoundException
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE)))
        {
            writer.write(cityName);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        throw new FileNotFoundException("File not found!");
    }

    public String loadCityName() throws FileNotFoundException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE)))
        {
            return reader.readLine();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        throw new FileNotFoundException("File not found!");
    }
}
