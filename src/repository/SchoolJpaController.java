/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import model.uniRecModel.School;
import model.uniRecModel.Department;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import repository.exceptions.IllegalOrphanException;
import repository.exceptions.NonexistentEntityException;

/**
 *
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or
 * std154845@ac.eap.gr
 */
public class SchoolJpaController implements Serializable {

    public SchoolJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(School school) {
        if (school.getDepartmentCollection() == null) {
            school.setDepartmentCollection(new ArrayList<Department>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            University universityName = school.getUniversityName();
            if (universityName != null) {
                universityName = em.getReference(universityName.getClass(), universityName.getName());
                school.setUniversityName(universityName);
            }
            Collection<Department> attachedDepartmentCollection = new ArrayList<Department>();
            for (Department departmentCollectionDepartmentToAttach : school.getDepartmentCollection()) {
                departmentCollectionDepartmentToAttach = em.getReference(departmentCollectionDepartmentToAttach.getClass(), departmentCollectionDepartmentToAttach.getId());
                attachedDepartmentCollection.add(departmentCollectionDepartmentToAttach);
            }
            school.setDepartmentCollection(attachedDepartmentCollection);
            em.persist(school);
            if (universityName != null) {
                universityName.getSchoolCollection().add(school);
                universityName = em.merge(universityName);
            }
            for (Department departmentCollectionDepartment : school.getDepartmentCollection()) {
                School oldSchoolIdOfDepartmentCollectionDepartment = departmentCollectionDepartment.getSchoolId();
                departmentCollectionDepartment.setSchoolId(school);
                departmentCollectionDepartment = em.merge(departmentCollectionDepartment);
                if (oldSchoolIdOfDepartmentCollectionDepartment != null) {
                    oldSchoolIdOfDepartmentCollectionDepartment.getDepartmentCollection().remove(departmentCollectionDepartment);
                    oldSchoolIdOfDepartmentCollectionDepartment = em.merge(oldSchoolIdOfDepartmentCollectionDepartment);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(School school) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            School persistentSchool = em.find(School.class, school.getId());
            University universityNameOld = persistentSchool.getUniversityName();
            University universityNameNew = school.getUniversityName();
            Collection<Department> departmentCollectionOld = persistentSchool.getDepartmentCollection();
            Collection<Department> departmentCollectionNew = school.getDepartmentCollection();
            List<String> illegalOrphanMessages = null;
            for (Department departmentCollectionOldDepartment : departmentCollectionOld) {
                if (!departmentCollectionNew.contains(departmentCollectionOldDepartment)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Department " + departmentCollectionOldDepartment + " since its schoolId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (universityNameNew != null) {
                universityNameNew = em.getReference(universityNameNew.getClass(), universityNameNew.getName());
                school.setUniversityName(universityNameNew);
            }
            Collection<Department> attachedDepartmentCollectionNew = new ArrayList<Department>();
            for (Department departmentCollectionNewDepartmentToAttach : departmentCollectionNew) {
                departmentCollectionNewDepartmentToAttach = em.getReference(departmentCollectionNewDepartmentToAttach.getClass(), departmentCollectionNewDepartmentToAttach.getId());
                attachedDepartmentCollectionNew.add(departmentCollectionNewDepartmentToAttach);
            }
            departmentCollectionNew = attachedDepartmentCollectionNew;
            school.setDepartmentCollection(departmentCollectionNew);
            school = em.merge(school);
            if (universityNameOld != null && !universityNameOld.equals(universityNameNew)) {
                universityNameOld.getSchoolCollection().remove(school);
                universityNameOld = em.merge(universityNameOld);
            }
            if (universityNameNew != null && !universityNameNew.equals(universityNameOld)) {
                universityNameNew.getSchoolCollection().add(school);
                universityNameNew = em.merge(universityNameNew);
            }
            for (Department departmentCollectionNewDepartment : departmentCollectionNew) {
                if (!departmentCollectionOld.contains(departmentCollectionNewDepartment)) {
                    School oldSchoolIdOfDepartmentCollectionNewDepartment = departmentCollectionNewDepartment.getSchoolId();
                    departmentCollectionNewDepartment.setSchoolId(school);
                    departmentCollectionNewDepartment = em.merge(departmentCollectionNewDepartment);
                    if (oldSchoolIdOfDepartmentCollectionNewDepartment != null && !oldSchoolIdOfDepartmentCollectionNewDepartment.equals(school)) {
                        oldSchoolIdOfDepartmentCollectionNewDepartment.getDepartmentCollection().remove(departmentCollectionNewDepartment);
                        oldSchoolIdOfDepartmentCollectionNewDepartment = em.merge(oldSchoolIdOfDepartmentCollectionNewDepartment);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = school.getId();
                if (findSchool(id) == null) {
                    throw new NonexistentEntityException("The school with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            School school;
            try {
                school = em.getReference(School.class, id);
                school.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The school with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Department> departmentCollectionOrphanCheck = school.getDepartmentCollection();
            for (Department departmentCollectionOrphanCheckDepartment : departmentCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This School (" + school + ") cannot be destroyed since the Department " + departmentCollectionOrphanCheckDepartment + " in its departmentCollection field has a non-nullable schoolId field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            University universityName = school.getUniversityName();
            if (universityName != null) {
                universityName.getSchoolCollection().remove(school);
                universityName = em.merge(universityName);
            }
            em.remove(school);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<School> findSchoolEntities() {
        return findSchoolEntities(true, -1, -1);
    }

    public List<School> findSchoolEntities(int maxResults, int firstResult) {
        return findSchoolEntities(false, maxResults, firstResult);
    }

    private List<School> findSchoolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(School.class));
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

    public School findSchool(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(School.class, id);
        } finally {
            em.close();
        }
    }

    public int getSchoolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<School> rt = cq.from(School.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    // δικο μου, για τα school
    public List<School> findSchoolsByUniversity(String universityName) {
        EntityManager em = getEntityManager();
        try {

            UniversityJpaController universityController = new UniversityJpaController(Emf.getEntityManagerFactory());
            University university = universityController.findUniversity(universityName);

            if (university == null) {
                System.out.println("No university found with name: " + universityName);
                return List.of(); // 
            }

            TypedQuery<School> query = em.createNamedQuery("School.findByUniversity", School.class);
            query.setParameter("universityName", university);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    //δικο μου 
    public School findSchoolByNameAndUniversity(String schoolName, String universityName) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<School> query = em.createNamedQuery("School.findByNameAndUniversity", School.class);
            query.setParameter("schoolName", schoolName);
            query.setParameter("universityName", universityName);

            List<School> results = query.getResultList();
            return results.isEmpty() ? null : results.get(0); // Επιστρέφει το πρώτο αποτέλεσμα ή null αν δεν βρέθηκε
        } finally {
            em.close();
        }
    }
    
    public School findSchoolByName(String schoolName) {
    EntityManager em = getEntityManager();
    try {
        TypedQuery<School> query = em.createNamedQuery("School.findByName", School.class);
        query.setParameter("name", schoolName);

        List<School> results = query.getResultList();
        return results.isEmpty() ? null : results.get(0); // ✅ Επιστρέφει το πρώτο αποτέλεσμα ή null αν δεν βρέθηκε
    } finally {
        em.close();
    }
}

}
