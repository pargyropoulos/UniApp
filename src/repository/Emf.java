package repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class Emf {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UniAppPU");

    private Emf() {
        // Private constructor to prevent instantiation
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
