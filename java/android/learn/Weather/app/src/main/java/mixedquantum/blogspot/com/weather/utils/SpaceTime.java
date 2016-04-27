package mixedquantum.blogspot.com.weather.utils;

import java.util.Calendar;

public class SpaceTime {
    public static String getPreciseName() {
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        if ((hour >= 23 && hour < 24) || (hour >= 0 && hour < 1)) {
            return "midnight";
        }
        if (hour >= 5 && hour < 11) {
            return "morning";
        }
        if (hour >= 11 && hour < 13) {
            return "noon";
        }
        if (hour >= 13 && hour < 17) {
            return "afternoon";
        }
        if (hour >= 17 && hour < 21) {
            return "evening";
        }
        if (hour >= 21 && hour <= 23) {
            return "night";
        }
        return "";
    }
}
