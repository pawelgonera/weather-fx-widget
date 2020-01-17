package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CitiesFile
{
    private static CitiesFile instance = null;
    private final static String CITIES_FILE = "cities_20000csv/cities_20000.csv";

    private CitiesFile()
    {

    }

    public static CitiesFile getInstance()
    {
        if(instance == null)
            instance = new CitiesFile();

        return instance;
    }

    public List<String[]> getGeoData()
    {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(CITIES_FILE);

        List<String[]> geoData = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)))
        {
            String[] record;
            String line;
            while ((line = reader.readLine()) != null)
            {
                record = line.split(",", 8);

                if(record[0].equals("id"))
                    continue;

                //if(record.length == 7)
                    geoData.add(record);
            }


        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return geoData;
    }
}
