package afpa.ecf.physicalregatta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Gwenole
 */
public class Settings {

    public static final String HOST = "10.105.49.11";
    public static final int PORT = 8080;
    public static final String PREFIX = "/api";
    public static final String GET_REGATTAS = "/currentchallenge";
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String JDBC_URL = "jdbc:mysql://localhost/physicalregatta?noAccessToProcedureBodies=true";
    public static final String JDBC_USER = "root";
    public static final String JDBC_PWD = "admin";
    public static final String PERSISTENCE_UNIT_NAME = "PhysicalRegattaPU";

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
