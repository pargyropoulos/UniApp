
package repository.service;

import repository.entities.Department;
import repository.entities.School;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import repository.exceptions.NonexistentEntityException;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class DepartmentJpaController implements Serializable {

    public DepartmentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Department department) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            School schoolId = department.getSchoolId();
            if (schoolId != null) {
                schoolId = em.getReference(schoolId.getClass(), schoolId.getId());
                department.setSchoolId(schoolId);
            }
            em.persist(department);
            if (schoolId != null) {
                schoolId.getDepartmentCollection().add(department);
                schoolId = em.merge(schoolId);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Department department) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Department persistentDepartment = em.find(Department.class, department.getId());
            School schoolIdOld = persistentDepartment.getSchoolId();
            School schoolIdNew = department.getSchoolId();
            if (schoolIdNew != null) {
                schoolIdNew = em.getReference(schoolIdNew.getClass(), schoolIdNew.getId());
                department.setSchoolId(schoolIdNew);
            }
            department = em.merge(department);
            if (schoolIdOld != null && !schoolIdOld.equals(schoolIdNew)) {
                schoolIdOld.getDepartmentCollection().remove(department);
                schoolIdOld = em.merge(schoolIdOld);
            }
            if (schoolIdNew != null && !schoolIdNew.equals(schoolIdOld)) {
                schoolIdNew.getDepartmentCollection().add(department);
                schoolIdNew = em.merge(schoolIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = department.getId();
                if (findDepartment(id) == null) {
                    throw new NonexistentEntityException("The department with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Department department;
            try {
                department = em.getReference(Department.class, id);
                department.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The department with id " + id + " no longer exists.", enfe);
            }
            School schoolId = department.getSchoolId();
            if (schoolId != null) {
                schoolId.getDepartmentCollection().remove(department);
                schoolId = em.merge(schoolId);
            }
            em.remove(department);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Department> findDepartmentEntities() {
        return findDepartmentEntities(true, -1, -1);
    }

    public List<Department> findDepartmentEntities(int maxResults, int firstResult) {
        return findDepartmentEntities(false, maxResults, firstResult);
    }

    private List<Department> findDepartmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Department.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Department findDepartment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Department.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepartmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Department> rt = cq.from(Department.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
