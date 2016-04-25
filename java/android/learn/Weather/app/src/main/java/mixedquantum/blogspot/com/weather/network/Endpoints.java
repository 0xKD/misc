package mixedquantum.blogspot.com.weather.network;

import mixedquantum.blogspot.com.weather.BuildConfig;
import mixedquantum.blogspot.com.weather.models.WeatherForecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Endpoints {
    String BASE_URL = BuildConfig.BASE_URL;
    String API_WEATHER = "data/2.5/forecast";

    @GET(API_WEATHER)
    Call<WeatherForecast> getForecast(@Query("id") long id);
}