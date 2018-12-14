package serviceTest;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.GeoDataImpl;

import java.util.List;

public class GeoDataTest
{
    private final static int AMOUNT_OF_RECORDS = 23524;
    private GeoDataImpl geoData;

    @BeforeEach
    void setUp()
    {
        geoData = GeoDataImpl.getInstance();
    }

    @Test
    public void getDataIdSizeTest()
    {
        final List<Long> idListTest = geoData.getDataId();

        assertThat(idListTest.size(), is(AMOUNT_OF_RECORDS));
    }

    @Test
    public void getDataIdSpecificValueTest()
    {
        final List<Long> idListTest = geoData.getDataId();

        final long idTest = 1263797;

        assertThat(idListTest.get(9999), is(idTest));
    }

    @Test void getCityNameSizeTest()
    {
        final List<String> cityNameListTest = geoData.getCityName();

        assertThat(cityNameListTest.size(), is(AMOUNT_OF_RECORDS));
    }


    @Test
    public void getCityNameSpecificValueTest()
    {
        final List<String> cityNameListTest = geoData.getCityName();

        final String cityNameTest = "Mangalagiri";

        assertThat(cityNameListTest.get(9999), is(cityNameTest));
    }

    @Test void getCountryNameSizeTest()
    {
        final List<String> countryNameListTest = geoData.getCountryName();

        assertThat(countryNameListTest.size(), is(AMOUNT_OF_RECORDS));
    }


    @Test
    public void getCountryNameSpecificValueTest()
    {
        final List<String> countryNameListTest = geoData.getCountryName();

        final String cityNameTest = "India";

        assertThat(countryNameListTest.get(9999), is(cityNameTest));
    }

}
