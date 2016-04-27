package mixedquantum.blogspot.com.weather.utils;

public class Temperature {
    private Double kelvin;

    public Temperature(Double kelvin) {
        this.kelvin = kelvin;
    }

    public Double getCelsius() {
        return kelvin - 273.15;
    }

    public Double getFahrenheit() {
        return getCelsius() * (9 / 5.0) + 32;
    }

    public static Double kelvinToCelsius(Double k) {
        return k - 273.15;
    }
}
