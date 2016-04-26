package mixedquantum.blogspot.com.weather.network;

import mixedquantum.blogspot.com.weather.BuildConfig;
import mixedquantum.blogspot.com.weather.models.CurrentWeather;
import mixedquantum.blogspot.com.weather.models.WeatherForecast;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface Endpoints {
    String BASE_URL = BuildConfig.BASE_URL;
    String API_WEATHER_FORECAST = "data/2.5/forecast";
    String API_CURRENT_WEATHER = "data/2.5/weather";

    @GET(API_WEATHER_FORECAST)
    Call<WeatherForecast> getForecast(@Query("id") long id);

    @GET(API_CURRENT_WEATHER)
    Call<CurrentWeather> getCurrentWeather(@Query("id") long id);
}