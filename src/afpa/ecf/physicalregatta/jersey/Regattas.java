package afpa.ecf.physicalregatta.jersey;

import afpa.ecf.physicalregatta.model.Regatta;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "routes" path)
 */
@Path("regatta")
public class Regattas {
    
    // Persistance
    private static final String PERSISTENCE_UNIT_NAME = "PhysicalRegattaPU";
    private static EntityManagerFactory factory;
    
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "application/json" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getRegattas() {
        
        // Initialisation de la persistance
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        // Peuplement des données
        Query qRegatta = em.createNamedQuery("Regatta.findAll");

        List<Regatta> regattas = qRegatta.getResultList();
        Gson gson = gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(regattas);
        return json;
    }
}
