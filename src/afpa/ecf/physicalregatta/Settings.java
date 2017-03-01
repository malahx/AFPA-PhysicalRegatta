

package afpa.ecf.physicalregatta;

/**
 *
 * @author Gwenole
 */
public class Settings {
    
    public static final String HOST = "10.105.49.11";
    public static final int PORT = 8080;
    public static final String PREFIX = "/api";
    public static final String GET_REGATTAS = "/currentchallenge";
    
    public static String getUrlAPI() {
        return "http://" + HOST + ":" + PORT + PREFIX;
    }
    
    public static String getUrlRegattas() {
        return getUrlAPI() + GET_REGATTAS;
    }
    
    public static String getURIRegattas() {
        return PREFIX + GET_REGATTAS;
    }
}
