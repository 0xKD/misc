package mixedquantum.blogspot.com.weather.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Clouds {
    @SerializedName("all")
    @Expose
    private Long all;

    /**
     *
     * @return
     * The all
     */
    public Long getAll() {
        return all;
    }

    /**
     *
     * @param all
     * The all
     */
    public void setAll(Long all) {
        this.all = all;
    }
}