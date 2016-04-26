package mixedquantum.blogspot.com.weather.utils;

import java.util.List;

import mixedquantum.blogspot.com.weather.network.NetworkDAO;
import mixedquantum.blogspot.com.weather.network.responses.NetworkVO;

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

    public void getWeatherDetails(Long id) {
        NetworkDAO.getInstance().getWeatherDetails(id);
    }

    public void getCurrentWeather(long id) {
        NetworkDAO.getInstance().getCurrentWeather(id);
    }
}
