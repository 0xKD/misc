package mixedquantum.blogspot.com.weather.utils;

import java.util.List;

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

    public void getWeatherDetails(Long id) {
        NetworkDAO.getInstance().getWeatherDetails(id);
    }
}
