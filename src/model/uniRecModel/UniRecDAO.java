
package model.uniRecModel;

import repository.School;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import repository.Department;
import repository.DepartmentJpaController;
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
    private final DepartmentJpaController departmentJpaController;
    private final UniversityJpaController universityJpaController;
    
    public UniRecDAO() {
         this.emf= repository.Emf.getEntityManagerFactory();
         this.schoolJpaController= new SchoolJpaController(emf);
         this.universityJpaController=new UniversityJpaController(emf);
         this.departmentJpaController=new DepartmentJpaController(emf);
    }

    public void createUniversity(University university) throws Exception {
        try {
            universityJpaController.create(university);
        } catch (PreexistingEntityException ex) {
            throw new Exception("University " + university + " already exists.", ex);
        }
    }
    
    public void updateUniversity(University university) {
        try {
            universityJpaController.edit(university);
        } catch (Exception ex) {
            System.out.println("Could not update the university. " + ex.getMessage());
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

    //List<SchoolDepartmentPair> schoolDepartmentPair
    public void deleteSchools(List<School> schools){
        for (var item:schools){
            try {
            schoolJpaController.destroy(item.getId());
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    public void deleteDepartments(List<Department> departments){
        for (var item:departments){
            try {
            departmentJpaController.destroy(item.getId());
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    public void createDepartments(Set<Department> departments){
        for (var item:departments){
            try {
            departmentJpaController.create(item);
            }catch (Exception ex){
                System.out.println(ex);
            }
        }
    }
    public void createSchools(Set<School> schools){
        for (var item:schools){
            try {
            schoolJpaController.create(item);
            }catch (Exception ex){
                System.out.println(ex);
            }
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
