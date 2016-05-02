package mixedquantum.blogspot.com.weather.utils;

import mixedquantum.blogspot.com.weather.network.NetworkDAO;

public class ServiceDelegate {
    private static ServiceDelegate instance;

    private ServiceDelegate() {

    }

    public static ServiceDelegate getInstance() {
        if (instance == null) {
            instance = new ServiceDelegate();
        }
        return instance;
    }

    public void getWeatherForecast(Long id) {
        NetworkDAO.getInstance().getWeatherForecast(id);
    }

    public void getCurrentWeather(long id) {
        NetworkDAO.getInstance().getCurrentWeather(id);
    }

    public void getPhoto(String term) {
        NetworkDAO.getInstance().getPhoto(term);
    }
}
