/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.service;

/**
 *
 * @author xe-di
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class UniversityRankingRepository {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("UniAppPU");

    // Get the EntityManager
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<UniversityDTO> findUniversitiesWithCounterGreaterThanEqualTen() {
        EntityManager em = getEntityManager();
        try {
//      
            String query = "SELECT new repository.UniversityDTO(u.name, u.counter, u.description, u.info) " +
                           "FROM University u WHERE u.counter >= 1 ORDER BY u.counter DESC, u.name ASC";
            TypedQuery<UniversityDTO> typedQuery = em.createQuery(query, UniversityDTO.class);
            return typedQuery.getResultList();
        } finally {
            em.close();
        }
    }
}

