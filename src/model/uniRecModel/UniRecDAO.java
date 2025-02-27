
package model.uniRecModel;

import repository.entities.School;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import repository.entities.Department;
import repository.entities.University;
import repository.service.UniversityJpaController;
import repository.exceptions.PreexistingEntityException;

/**
 * 
 * DAO class to support the Unirec Model
 */
public class UniRecDAO {
    private final EntityManagerFactory emf;
    private final UniversityJpaController universityJpaController;
    
    public UniRecDAO() {
         this.emf= repository.service.Emf.getEntityManagerFactory();
         this.universityJpaController=new UniversityJpaController(emf);
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

    /**
     * Returns a list of all schools matching the university keyID
     * @param universityName
     * @return 
     */
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

    /**
     * Returns a list with all departments matching the school id
     * @param schoolId
     * @return 
     */
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

    /**
     * Updates University entity and inserts new shcools and departments
     * @param university
     * @param schools
     * @param departments 
     */
    public void updateInsert(University university,Set<School> schools,Set<Department> departments){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            University managedUniversity = em.merge(university);
            
            for (School school : schools) {
                school.setUniversityName(managedUniversity); // Set University for each School
                em.persist(school);
            }            
            for (Department department : departments) {
                School managedSchool = em.find(School.class, department.getSchoolId().getId());
                if (managedSchool != null) {
                    department.setSchoolId(managedSchool);
                    em.persist(department);
                } else {
                    throw new RuntimeException("School not found for department: " + department.getName());
                }
            }        
            em.getTransaction().commit();
            System.out.println("University, Schools, and Departments updated successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }   
    
    /**
     * Deletes schools and departments from the DB
     * @param schools
     * @param departments 
     */
    public void deleteSchoolsAndDepartments(List<School> schools, List<Department> departments) {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Delete Departments first (ensure integrity)
            for (Department department : departments) {
                Department managedDepartment = em.merge(department);  // Merge the department to attach it to the persistence context
                em.remove(managedDepartment);  // Remove the department
            }

            // Delete Schools after deleting related departments
            for (School school : schools) {
                School managedSchool = em.merge(school); // Merge the school to attach it to the persistence context
                em.remove(managedSchool); // Remove the school
            }

            // Commit the transaction
            em.getTransaction().commit();
            System.out.println("Schools and Departments deleted successfully!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
}
