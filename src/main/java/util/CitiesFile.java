package util;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class CitiesFile
{
    //private final static String CITIES_FILE = "cities_20000json/cities_1.json";
    private final static String CITIES_FILE = "src/main/resources/cities_20000csv/cities_20000.csv";

    public static List<String[]> getGeoData()
    {
        /*
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(CITIES_FILE), "UTF-8")))
        {
            return reader.readLine();

        }catch (IOException e)
        {
            e.printStackTrace();
            return e.getMessage();
        }*/

        List<String[]> geodata = new LinkedList<>();
        String[] record;
        try(BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/cities_20000csv/cities_20000.csv")))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                record = line.split(",");
                geodata.add(record);
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return geodata;
    }
}
