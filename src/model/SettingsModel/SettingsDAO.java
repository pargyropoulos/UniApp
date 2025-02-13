package model.SettingsModel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import repository.Country;
import repository.CountryJpaController;
import repository.Emf;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class SettingsDAO extends CountryJpaController{
    private final CountryJpaController countryJpaController;
    
    public SettingsDAO(EntityManagerFactory emf) {
        super(emf);
        this.countryJpaController = new CountryJpaController(emf);
        
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
