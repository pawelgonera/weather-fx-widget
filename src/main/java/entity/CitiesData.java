package entity;

import javax.json.bind.annotation.JsonbProperty;
import java.util.List;

public class CitiesData
{
    @JsonbProperty("geo_data")
    private List<Cities> citiesList;

    public List<Cities> getCitiesList() {
        return citiesList;
    }

    public void setCitiesList(List<Cities> citiesList) {
        this.citiesList = citiesList;
    }
}
