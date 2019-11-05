package util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CitiesFile
{
    //private final static String CITIES_FILE = "cities_20000json/cities_1.json";
    private final static String CITIES_FILE = "src/main/resources/cities_20000csv/cities_20000.csv";

    public static List<String[]> getGeoData()
    {

        List<String[]> geoData = new LinkedList<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(CITIES_FILE), StandardCharsets.UTF_8)))
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