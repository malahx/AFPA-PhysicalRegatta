package afpa.ecf.physicalregatta.android;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Afpa on 28/02/2017.
 */

public class Utils {

    public final static Gson GSON = new GsonBuilder().create();

    public static String time(float time) {
        final float hour = time / 3600;
        final Integer floorHour = (int)Math.floor(hour);
        final double min = (hour - floorHour) * 60;
        final Integer floorMin = (int)Math.floor(min);
        final Integer floorSeconds = (int)Math.floor((min - floorMin) * 60);
        return floorHour +
                "h" +
                (floorMin.toString().length() == 1 ? "0" + floorMin : floorMin) +
                ":" +
                (floorSeconds.toString().length() == 1 ? "0" + floorSeconds : floorSeconds);
    }
}
