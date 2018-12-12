package validator;

import java.text.Normalizer;

public class FixCityName
{
    private static FixCityName instance = null;

    public static FixCityName getInstance()
    {
        if(instance == null)
            instance = new FixCityName();

        return instance;
    }

    public String fixName(String cityRequest)
    {
        String fixedName = removeEmptySpace(cityRequest);

        fixedName = replaceProblematicChar(fixedName);

        fixedName = replaceSpecialChars(fixedName);

        return fixedName;
    }

    private String removeEmptySpace(String cityRequest)
    {
        return cityRequest.replace(" ", "_");
    }

    private String replaceSpecialChars(String cityRequest)
    {
        return Normalizer.normalize(cityRequest, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

    private String replaceProblematicChar(String cityRequest)
    {
        if(cityRequest.toLowerCase().contains("ł"))
            return cityRequest.toLowerCase().replace("ł", "l");

        return cityRequest;
    }
}
