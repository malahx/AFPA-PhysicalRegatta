/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta;

import afpa.ecf.physicalregatta.model.Challenge;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Afpa
 */
public class Utils {

    // Persistance
    private static final String PERSISTENCE_UNIT_NAME = "PhysicalRegattaPU";
    private static EntityManagerFactory factory;

    
    public static Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    
    public static Challenge getCurrentChallenge() {

        // Initialisation de la persistance
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        EntityManager em = factory.createEntityManager();

        Query qChallenge = em.createNamedQuery("Challenge.findAll");

        List<Challenge> challenges = qChallenge.getResultList();
        Challenge challenge = null;
        Date now = new Date();

        for (Challenge c : challenges) {
            if (c.getBegin().before(now) && c.getEnd().after(now)) {
                challenge = c;
            }
        }

        System.out.println("GET Regattas from the Current Challenge");
        return challenge;
    }
}
