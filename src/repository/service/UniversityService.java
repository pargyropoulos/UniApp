package repository.service;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import repository.entities.University;


public class UniversityService {
    /**
     * Return the top most viewed universities
     * @return 
     */
    public List<University> getTop10UniversitiesOrderByCounterDescNameAsc() {
        EntityManagerFactory emf= repository.service.Emf.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        List<University> universities = em.createNamedQuery("University.findAllOrderByCounterDesc", University.class)
                                          .setMaxResults(10) // Limit results to top 10
                                          .getResultList();
        em.close();
        return universities;
    }    
}
