/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model.uniRecModel;

import repository.School;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import repository.SchoolJpaController;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class UniRecDAO {
    private final EntityManagerFactory emf;
    private final SchoolJpaController schoolJpaController;
    
    public UniRecDAO() {
         this.emf= repository.Emf.getEntityManagerFactory();
         this.schoolJpaController= new SchoolJpaController(this.emf);
    }

    public List<School> findAllOrdered() {
        EntityManager em=emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT s FROM School s order by s.name ASC");
            return query.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }  
}
