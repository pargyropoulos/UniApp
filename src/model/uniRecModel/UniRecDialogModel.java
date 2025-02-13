package model.uniRecModel;


import repository.School;
import HTTP.WebData;
import java.util.ArrayList;
import java.util.HashSet;
import repository.UniversityJpaController;
import repository.CountryJpaController;
import repository.Emf;
import repository.University;
import repository.Country;
import repository.SchoolJpaController;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author tasos
 */
public class UniRecDialogModel {

    private WebData webData;
    private University universityModel;
    private Department departmentModel;
    private School schoolModel;
    private UniversityJpaController universityController;

    private final List<School> schoolsList = new ArrayList<>();;
    private final List<School> deletedSchools = new ArrayList<>();
    private final Set<School> insertedSchools = new HashSet<>();
    private final List<Department> departmentsList = new ArrayList<>();;
    private final List<Department> deletedDepartments = new ArrayList<>();
    private final Set<Department> insertedDepartments = new HashSet<>();
    
    public UniRecDialogModel(WebData webData) {  // Constructor με WebData
        this.webData = webData;
        
        // Δημιουργία instance του Controller
        this.universityController = new UniversityJpaController(Emf.getEntityManagerFactory());
        CountryJpaController countryController = new CountryJpaController(Emf.getEntityManagerFactory());

        // Αναζητούμε αν υπάρχει ήδη στη βάση
        this.universityModel = universityController.findUniversity(webData.getName());

        // Αναζητούμε τη χώρα στη βάση
        Country country = countryController.findCountry(webData.getCountry());

        if (this.universityModel == null) {
            System.out.println("University not found in database. Creating new entry.");

            // Δημιουργούμε νέο University από το WebData
            this.universityModel = new University();
            this.universityModel.setName(webData.getName());

            //είναι σε άλλο πίνακα
            //this.universityModel.setCountry(webData.getCountry());
            //this.universityModel.setCounter(1); // Πρώτη φορά που εμφανίζεται
//            this.universityModel.setDescription("No additional info");
//            this.universityModel.setInfo("No additional info");

            try {
                universityController.create(this.universityModel);
                System.out.println("University saved to database: " + this.universityModel.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("University already exists. Increasing counter.");

            // Αν το πανεπιστήμιο υπάρχει, αυξάνv το counter
            int currentCounter = this.universityModel.getCounter() != null ? this.universityModel.getCounter() : 0;
            this.universityModel.setCounter(currentCounter + 1);

            try {
                universityController.edit(this.universityModel); // Αποθήκευση αλλαγής
                System.out.println("Counter updated for: " + this.universityModel.getName() + " -> " + this.universityModel.getCounter());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public University getUniversityModel() {
        return universityModel;
    }

    public WebData getWebData() {  // Getter για να το χρησιμοποιήσω η View
        return webData;
    }

    //λιστα για domains
    public List<String> getDomains() {
        if (webData != null) {
            return webData.getDomains();
        }
        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Λιστα για Web_Pages
    public List<String> getWebPages() {
        if (webData != null) {
            return webData.getWeb_pages();
        }
        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Για να εμφανίσω τα στοιχεία στο description
    //απο την βάδη δεδομενων
    public String getDescription() {
        if (universityModel != null) {
            return universityModel.getDescription();
        }
        return "No description available";
    }

    //Για να εμφανίσω τα στοιχεία στο info
    //απο την βάδη δεδομενων
    public String getInfo() {
        if (universityModel != null) {
            return universityModel.getInfo();
        }
        return "No description available";
    }

    public List<String> getSchools() {
        if (universityModel != null) {
            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
            List<School> schoolList = schoolController.findSchoolsByUniversity(universityModel.getName());

            //debugging
            System.out.println("Loaded schools: " + schoolList.size());

            // Μετατρέπουμε τη λίστα σε Strings
            return schoolList.stream()
                    .map(School::getName)
                    .collect(Collectors.toList());
        }
        return List.of(); // Αν δεν υπάρχουν σχολές, επιστρέφουμε κενή λίστα
    }

    public void updateUniversityInfo(String newDescription, String newInfo) {
        if (universityModel != null) {
            universityModel.setDescription(newDescription);
            universityModel.setInfo(newInfo);

            try {
                universityController.edit(universityModel);
                System.out.println("University info updated: " + universityModel.getName());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to update university info.");
            }
        } else {
            System.out.println("No university found to update.");
        }
    }

    public boolean addSchoolToDatabase(String schoolName) {
        if (universityModel == null) {
            System.out.println("Error: No university selected.");
            return false;
        }

        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // ✅ Ελέγχουμε αν υπάρχει ήδη η σχολή
            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
            List<School> existingSchools = schoolController.findSchoolsByUniversity(universityModel.getName());

            for (School s : existingSchools) {
                if (s.getName().equalsIgnoreCase(schoolName)) {
                    System.out.println("School already exists in database: " + schoolName);
                    return false; // Αν υπάρχει ήδη, δεν προσθέτουμε ξανά
                }
            }

            // ✅ Δημιουργούμε και αποθηκεύουμε τη νέα σχολή
            School newSchool = new School();
            newSchool.setName(schoolName);
            newSchool.setUniversityName(universityModel); // Σύνδεση με το πανεπιστήμιο

            em.persist(newSchool);
            transaction.commit();
            return true;

        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    
    public boolean deleteSchoolFromDatabase(String schoolName) {
    if (universityModel == null) {
        System.out.println("Error: No university selected.");
        return false;
    }

    EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();

       
        SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
        School school = schoolController.findSchoolByNameAndUniversity(schoolName, universityModel.getName());

        if (school == null) {
            System.out.println("No school found with name: " + schoolName);
            return false;
        }

        em.remove(em.contains(school) ? school : em.merge(school));
        transaction.commit();
        return true;

    } catch (Exception e) {
        transaction.rollback();
        e.printStackTrace();
        return false;
    } finally {
        em.close();
    }
}

}
