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
import javax.persistence.TypedQuery;
import repository.Department;
//import javax.persistence.TypedQuery;
import repository.SchoolJpaController;
import repository.University;
import repository.UniversityJpaController;
import repository.exceptions.IllegalOrphanException;
import repository.exceptions.NonexistentEntityException;
import repository.exceptions.PreexistingEntityException;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class UniRecDAO {
    private final EntityManagerFactory emf;
    private final SchoolJpaController schoolJpaController;
    private final UniversityJpaController universityJpaController;
    
    public UniRecDAO() {
         this.emf= repository.Emf.getEntityManagerFactory();
         this.schoolJpaController= new SchoolJpaController(emf);
         this.universityJpaController=new UniversityJpaController(emf);
    }

    public void createUniversity(University university) throws Exception {
        try {
            universityJpaController.create(university);
        } catch (PreexistingEntityException ex) {
            throw new Exception("University " + university + " already exists.", ex);
        }
    }
    
    public void updateUniversity(University university) throws Exception {
        try {
            universityJpaController.edit(university);
        } catch (IllegalOrphanException | NonexistentEntityException ex) {
            throw new Exception("Could not update the university. " + ex.getMessage(), ex);
        }
    }    
    
    public University findUniversity(String primaryKey){
        return universityJpaController.findUniversity(primaryKey);
    }

    
    public List<School> findSchools(String universityName) {
        EntityManager em = this.emf.createEntityManager();
        try {
        TypedQuery<School> query = em.createNamedQuery("School.findByUniversityName", School.class);
        query.setParameter("universityName", universityName); // Match the parameter name
        return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Department> findDepartments(int schoolId) {
        EntityManager em = this.emf.createEntityManager();
        try {
        TypedQuery<Department> query = em.createNamedQuery("Department.findBySchoolId", Department.class);
        query.setParameter("schoolId", schoolId); // Match the parameter name
        return query.getResultList();
        } finally {
            em.close();
        }
    }    

//    public List<Department> findDepartments(String universityName) {
//        EntityManager em = this.emf.createEntityManager();
//        try {
//        TypedQuery<School> query = em.createNamedQuery("School.findByUniversityName", School.class);
//        query.setParameter("universityName", universityName); // Match the parameter name
//        return query.getResultList();
//        } finally {
//            em.close();
//        }
//    }    
}
