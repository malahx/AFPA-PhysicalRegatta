package afpa.ecf.physicalregatta.android;

/**
 * Created by Afpa on 28/02/2017.
 */

public class Utils {

    public static String time(float time) {
        final float hour = time / 3600;
        final int floorHour = (int)Math.floor(hour);
        final double min = (hour - floorHour) / 60;
        final int floorMin = (int)Math.floor(min);
        final double seconds = (min - floorMin) / 60;
        return floorHour + "h" + floorMin + ":" + seconds;
    }
}
