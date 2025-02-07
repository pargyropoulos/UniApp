package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import model.SettingsModel.Country;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class CountryDAO extends CountryJpaController{

    public CountryDAO(EntityManagerFactory emf) {
        super(emf);
    }
    
    public List<Country> findAllOrdered() {
        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        try {
//            Query query = em.createNamedQuery("Country.findAllOrdered");
            Query query = em.createQuery("SELECT c FROM Country c order by c.name ASC");
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    
}
