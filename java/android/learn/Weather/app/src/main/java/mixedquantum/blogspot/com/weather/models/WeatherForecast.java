package mixedquantum.blogspot.com.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeatherForecast {
    @SerializedName("city")
    @Expose
    private City city;

    /**
     *
     * @return
     * The city
     */
    public City getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    public void setCity(City city) {
        this.city = city;
    }
}