package model.uniRecModel;

import HTTP.WebData;
import repository.UniversityJpaController;
import repository.CountryJpaController;
import repository.Emf;
import repository.University;
import model.SettingsModel.Country;
import java.util.List;
import repository.SchoolJpaController;
import model.uniRecModel.School;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author tasos
 */
public class UniRecDialogModel {

    private WebData universityData;

    // 2
    private University university;
    private UniversityJpaController universityController;
    //-2

    public UniRecDialogModel(WebData universityData) {  // Constructor με WebData
        this.universityData = universityData;

        // Δημιουργία instance του Controller
        this.universityController = new UniversityJpaController(Emf.getEntityManagerFactory());
        CountryJpaController countryController = new CountryJpaController(Emf.getEntityManagerFactory());

        // Αναζητούμε αν υπάρχει ήδη στη βάση
        this.university = universityController.findUniversity(universityData.getName());

        // Αναζητούμε τη χώρα στη βάση
        Country country = countryController.findCountry(universityData.getCountry());

        if (this.university == null) {
            System.out.println("University not found in database. Creating new entry.");

            // Δημιουργούμε νέο University από το WebData
            this.university = new University();
            this.university.setName(universityData.getName());

            //είναι σε άλλο πίνακα
            //this.university.setCountry(universityData.getCountry());
            //this.university.setCounter(1); // Πρώτη φορά που εμφανίζεται
            this.university.setDescription("No additional info");
            this.university.setInfo("No additional info");

            try {
                universityController.create(this.university);
                System.out.println("University saved to database: " + this.university.getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("University already exists. Increasing counter.");

            // Αν το πανεπιστήμιο υπάρχει, αυξάνv το counter
            int currentCounter = this.university.getCounter() != null ? this.university.getCounter() : 0;
            this.university.setCounter(currentCounter + 1);

            try {
                universityController.edit(this.university); // Αποθήκευση αλλαγής
                System.out.println("Counter updated for: " + this.university.getName() + " -> " + this.university.getCounter());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public University getUniversity() {
        return university;
    }

    public WebData getUniversityData() {  // Getter για να το χρησιμοποιήσω η View
        return universityData;
    }

    //λιστα για domains
    public List<String> getDomains() {
        if (universityData != null) {
            return universityData.getDomains();
        }
        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Λιστα για Web_Pages
    public List<String> getWebPages() {
        if (universityData != null) {
            return universityData.getWeb_pages();
        }
        return null; // Αν δεν υπάρχει πανεπιστήμιο, επιστρέφουμε null
    }

    //Για να εμφανίσω τα στοιχεία στο description
    //απο την βάδη δεδομενων
    public String getDescription() {
        if (university != null) {
            return university.getDescription();
        }
        return "No description available";
    }

    //Για να εμφανίσω τα στοιχεία στο info
    //απο την βάδη δεδομενων
    public String getInfo() {
        if (university != null) {
            return university.getInfo();
        }
        return "No description available";
    }

    public List<String> getSchools() {
        if (university != null) {
            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
            List<School> schoolList = schoolController.findSchoolsByUniversity(university.getName());

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
        if (university != null) {
            university.setDescription(newDescription);
            university.setInfo(newInfo);

            try {
                universityController.edit(university);
                System.out.println("University info updated: " + university.getName());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed to update university info.");
            }
        } else {
            System.out.println("No university found to update.");
        }
    }

    public boolean addSchoolToDatabase(String schoolName) {
        if (university == null) {
            System.out.println("Error: No university selected.");
            return false;
        }

        EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // ✅ Ελέγχουμε αν υπάρχει ήδη η σχολή
            SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
            List<School> existingSchools = schoolController.findSchoolsByUniversity(university.getName());

            for (School s : existingSchools) {
                if (s.getName().equalsIgnoreCase(schoolName)) {
                    System.out.println("School already exists in database: " + schoolName);
                    return false; // Αν υπάρχει ήδη, δεν προσθέτουμε ξανά
                }
            }

            // ✅ Δημιουργούμε και αποθηκεύουμε τη νέα σχολή
            School newSchool = new School();
            newSchool.setName(schoolName);
            newSchool.setUniversityName(university); // Σύνδεση με το πανεπιστήμιο

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
    if (university == null) {
        System.out.println("Error: No university selected.");
        return false;
    }

    EntityManager em = Emf.getEntityManagerFactory().createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    try {
        transaction.begin();

       
        SchoolJpaController schoolController = new SchoolJpaController(Emf.getEntityManagerFactory());
        School school = schoolController.findSchoolByNameAndUniversity(schoolName, university.getName());

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
