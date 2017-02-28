/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.spark;

import afpa.ecf.physicalregatta.model.Regatta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

/**
 *
 * @author lionel
 */
public class Main {
    
    static final String PREFIX = "/api";
    
    public static void main(String[] args) {
        //get("/hello", (req, res) -> "Hello World");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PhysicalRegattaPU");
        EntityManager em = emf.createEntityManager();
        
        port(8080);
        staticFiles.location("/public"); // Static files
        
        get(PREFIX + "/regatta", "application/json", (request, response) -> {
            Query qRegatta = em.createNamedQuery("Regatta.findAll");

            List<Regatta> regattas = qRegatta.getResultList();
            System.out.println("GET regattas");
            return regattas;
        }, new JsonTransformer());
      
    }
}