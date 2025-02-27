package model.SettingsModel;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import repository.entities.Country;
import repository.service.CountryJpaController;
import repository.service.Emf;

/**
 * 
 * DAO class to support the Settings Model Class
 */
public class SettingsDAO extends CountryJpaController{
    private final CountryJpaController countryJpaController;
    
    public SettingsDAO(EntityManagerFactory emf) {
        super(emf);
        this.countryJpaController = new CountryJpaController(emf);
        
    }
    
    /**
     * Returns a list with all the available countries
     * @return 
     */
    public List<Country> findAllOrdered() {
    EntityManager em = Emf.getEntityManagerFactory().createEntityManager();    
        try {
            Query query = em.createQuery("SELECT c FROM Country c order by c.name ASC");
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }    

    /**
     * Clears the database records. Leeaves intact the countries table fro future use
     */
    public void deleteAllEntries() {
        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();
            em.createQuery("DELETE FROM University").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
                System.out.println("All data are deleted!");
            }
        }
    }

    
}
