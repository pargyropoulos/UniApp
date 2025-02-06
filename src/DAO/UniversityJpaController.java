/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import DAO.exceptions.PreexistingEntityException;
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

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class UniversityJpaController implements Serializable {

    public UniversityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(University university) throws PreexistingEntityException, Exception {
        if (university.getSchoolCollection() == null) {
            university.setSchoolCollection(new ArrayList<School>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<School> attachedSchoolCollection = new ArrayList<School>();
            for (School schoolCollectionSchoolToAttach : university.getSchoolCollection()) {
                schoolCollectionSchoolToAttach = em.getReference(schoolCollectionSchoolToAttach.getClass(), schoolCollectionSchoolToAttach.getId());
                attachedSchoolCollection.add(schoolCollectionSchoolToAttach);
            }
            university.setSchoolCollection(attachedSchoolCollection);
            em.persist(university);
            for (School schoolCollectionSchool : university.getSchoolCollection()) {
                University oldUniversityNameOfSchoolCollectionSchool = schoolCollectionSchool.getUniversityName();
                schoolCollectionSchool.setUniversityName(university);
                schoolCollectionSchool = em.merge(schoolCollectionSchool);
                if (oldUniversityNameOfSchoolCollectionSchool != null) {
                    oldUniversityNameOfSchoolCollectionSchool.getSchoolCollection().remove(schoolCollectionSchool);
                    oldUniversityNameOfSchoolCollectionSchool = em.merge(oldUniversityNameOfSchoolCollectionSchool);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUniversity(university.getName()) != null) {
                throw new PreexistingEntityException("University " + university + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(University university) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            University persistentUniversity = em.find(University.class, university.getName());
            Collection<School> schoolCollectionOld = persistentUniversity.getSchoolCollection();
            Collection<School> schoolCollectionNew = university.getSchoolCollection();
            List<String> illegalOrphanMessages = null;
            for (School schoolCollectionOldSchool : schoolCollectionOld) {
                if (!schoolCollectionNew.contains(schoolCollectionOldSchool)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain School " + schoolCollectionOldSchool + " since its universityName field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<School> attachedSchoolCollectionNew = new ArrayList<School>();
            for (School schoolCollectionNewSchoolToAttach : schoolCollectionNew) {
                schoolCollectionNewSchoolToAttach = em.getReference(schoolCollectionNewSchoolToAttach.getClass(), schoolCollectionNewSchoolToAttach.getId());
                attachedSchoolCollectionNew.add(schoolCollectionNewSchoolToAttach);
            }
            schoolCollectionNew = attachedSchoolCollectionNew;
            university.setSchoolCollection(schoolCollectionNew);
            university = em.merge(university);
            for (School schoolCollectionNewSchool : schoolCollectionNew) {
                if (!schoolCollectionOld.contains(schoolCollectionNewSchool)) {
                    University oldUniversityNameOfSchoolCollectionNewSchool = schoolCollectionNewSchool.getUniversityName();
                    schoolCollectionNewSchool.setUniversityName(university);
                    schoolCollectionNewSchool = em.merge(schoolCollectionNewSchool);
                    if (oldUniversityNameOfSchoolCollectionNewSchool != null && !oldUniversityNameOfSchoolCollectionNewSchool.equals(university)) {
                        oldUniversityNameOfSchoolCollectionNewSchool.getSchoolCollection().remove(schoolCollectionNewSchool);
                        oldUniversityNameOfSchoolCollectionNewSchool = em.merge(oldUniversityNameOfSchoolCollectionNewSchool);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = university.getName();
                if (findUniversity(id) == null) {
                    throw new NonexistentEntityException("The university with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            University university;
            try {
                university = em.getReference(University.class, id);
                university.getName();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The university with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<School> schoolCollectionOrphanCheck = university.getSchoolCollection();
            for (School schoolCollectionOrphanCheckSchool : schoolCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This University (" + university + ") cannot be destroyed since the School " + schoolCollectionOrphanCheckSchool + " in its schoolCollection field has a non-nullable universityName field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(university);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<University> findUniversityEntities() {
        return findUniversityEntities(true, -1, -1);
    }

    public List<University> findUniversityEntities(int maxResults, int firstResult) {
        return findUniversityEntities(false, maxResults, firstResult);
    }

    private List<University> findUniversityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(University.class));
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

    public University findUniversity(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(University.class, id);
        } finally {
            em.close();
        }
    }

    public int getUniversityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<University> rt = cq.from(University.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
