package mixedquantum.blogspot.com.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import mixedquantum.blogspot.com.weather.models.primitive.Clouds;
import mixedquantum.blogspot.com.weather.models.primitive.Coord;
import mixedquantum.blogspot.com.weather.models.primitive.Main;
import mixedquantum.blogspot.com.weather.models.primitive.Sys;
import mixedquantum.blogspot.com.weather.models.primitive.Weather;
import mixedquantum.blogspot.com.weather.models.primitive.Wind;

public class CurrentWeather implements Parcelable {

    @SerializedName("coord")
    @Expose
    private Coord coord;
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = new ArrayList<>();
    @SerializedName("base")
    @Expose
    private String base;
    @SerializedName("main")
    @Expose
    private Main main;
    @SerializedName("visibility")
    @Expose
    private Long visibility;
    @SerializedName("wind")
    @Expose
    private Wind wind;
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    @SerializedName("dt")
    @Expose
    private Long dt;
    @SerializedName("sys")
    @Expose
    private Sys sys;
    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("cod")
    @Expose
    private Long cod;

    /**
     *
     * @return
     * The coord
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     *
     * @param coord
     * The coord
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     *
     * @return
     * The weather
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     *
     * @param weather
     * The weather
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     *
     * @return
     * The base
     */
    public String getBase() {
        return base;
    }

    /**
     *
     * @param base
     * The base
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     *
     * @return
     * The main
     */
    public Main getMain() {
        return main;
    }

    /**
     *
     * @param main
     * The main
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     *
     * @return
     * The visibility
     */
    public long getVisibility() {
        return visibility;
    }

    /**
     *
     * @param visibility
     * The visibility
     */
    public void setVisibility(long visibility) {
        this.visibility = visibility;
    }

    /**
     *
     * @return
     * The wind
     */
    public Wind getWind() {
        return wind;
    }

    /**
     *
     * @param wind
     * The wind
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     *
     * @return
     * The clouds
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     *
     * @param clouds
     * The clouds
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     *
     * @return
     * The dt
     */
    public long getDt() {
        return dt;
    }

    /**
     *
     * @param dt
     * The dt
     */
    public void setDt(long dt) {
        this.dt = dt;
    }

    /**
     *
     * @return
     * The sys
     */
    public Sys getSys() {
        return sys;
    }

    /**
     *
     * @param sys
     * The sys
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     *
     * @return
     * The id
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The cod
     */
    public long getCod() {
        return cod;
    }

    /**
     *
     * @param cod
     * The cod
     */
    public void setCod(long cod) {
        this.cod = cod;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.coord, flags);
        dest.writeList(this.weather);
        dest.writeString(this.base);
        dest.writeParcelable(this.main, flags);
        dest.writeValue(this.visibility);
        dest.writeParcelable(this.wind, flags);
        dest.writeParcelable(this.clouds, flags);
        dest.writeValue(this.dt);
        dest.writeParcelable(this.sys, flags);
        dest.writeValue(this.id);
        dest.writeString(this.name);
        dest.writeValue(this.cod);
    }

    public CurrentWeather() {
    }

    protected CurrentWeather(Parcel in) {
        this.coord = in.readParcelable(Coord.class.getClassLoader());
        this.weather = new ArrayList<Weather>();
        in.readList(this.weather, Weather.class.getClassLoader());
        this.base = in.readString();
        this.main = in.readParcelable(Main.class.getClassLoader());
        this.visibility = (Long) in.readValue(Long.class.getClassLoader());
        this.wind = in.readParcelable(Wind.class.getClassLoader());
        this.clouds = in.readParcelable(Clouds.class.getClassLoader());
        this.dt = (Long) in.readValue(Long.class.getClassLoader());
        this.sys = in.readParcelable(Sys.class.getClassLoader());
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.cod = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Parcelable.Creator<CurrentWeather> CREATOR = new Parcelable.Creator<CurrentWeather>() {
        @Override
        public CurrentWeather createFromParcel(Parcel source) {
            return new CurrentWeather(source);
        }

        @Override
        public CurrentWeather[] newArray(int size) {
            return new CurrentWeather[size];
        }
    };
}
