package util;

import java.io.*;

public class SaveCityName
{
    private static SaveCityName instance = null;

    private final static String LOCATION = "city";
    private final static String FILE_NAME = LOCATION + "/city_name.data";

    private static File DIR;
    private static File FILE;

    public static SaveCityName getInstance()
    {
        if(instance == null)
            instance = new SaveCityName();

        return instance;
    }

    public SaveCityName()
    {
        DIR = new File(LOCATION);
        FILE = new File(FILE_NAME);

        DIR.mkdirs();

        try
        {
            FILE.createNewFile();

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void saveCityName(String cityName)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE)))
        {
            writer.write(cityName);

        }catch (IOException e)
        {
            e.printStackTrace();
        }

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
