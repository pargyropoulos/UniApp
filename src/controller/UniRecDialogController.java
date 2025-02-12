package controller;

import view.Utils;
import model.uniRecModel.UniRecDialogModel;
import HTTP.WebData;
import view.UniRecDialogView;
import repository.University;
import java.util.List;

/**
 *
 * @author tasos
 */
public class UniRecDialogController {
    private final UniRecDialogModel model;
    private final UniRecDialogView view;

    public UniRecDialogController(UniRecDialogView view, UniRecDialogModel model) {
        this.model = model;
        this.view = view;

        WebData universityWeb = model.getUniversityData();
        // Παίρνουμε το πανεπιστήμιο από το μοντέλο
        University university = model.getUniversityModel();

        // Αν υπάρχει πανεπιστήμιο, περνάω τα δεδομένα στη View
        if (universityWeb != null) {
            view.setUniversityData(universityWeb);
        }
        // Φέρνω τα domains απο τι αντικείμενο 
        List<String> domains = universityWeb.getDomains();
        view.populateDomainsGrid(domains);

        // Το ιδιο για web_pages
        List<String> webPages = universityWeb.getWeb_pages();
        view.populateWebPagesGrid(webPages);

        //  Στέλνω τα δεδομένα του πανεπιστημίου στη View
        view.setUniversityData(model.getUniversityData());

        if (university != null) {
            view.setDescriptionField(university.getDescription());
            view.setInfoField(university.getInfo());

            //για τα school
            List<String> schools = model.getSchools();
            view.populateSchoolsGrid(schools);
        }

        // Προσθέτω τον listener για το κουμπί Exit
        view.addExitButtonListener(e -> closeDialog());
        view.addSaveButtonListener(e -> saveUniversityInfo());
        view.addAddSchoolButtonListener(e -> addSchool());
        view.addDeleteSchoolButtonListener(e -> deleteSchool());


        // Δημιουργούω το μοντέλο και αποθηκεύουω το πανεπιστήμιο αν χρειάζεται
        //this.model = new UniRecDialogModel(universityWeb);

//        if (university != null) {
//          
//            view.setUniversityData(university);
//            
//          
//            model.incrementCounter();
//        }
    }

    private void saveUniversityInfo() {
        String newDescription = view.getDescriptionText();
        String newInfo = view.getInfoText();

        model.updateUniversityInfo(newDescription, newInfo);
        System.out.println("Saved new description and info.");
    }

    private void addSchool() {
        String schoolName = view.getSchoolText(); // Παίρνουμε το όνομα της σχολής από το TextField

        if (schoolName.isEmpty()) {
            System.out.println("Error: School name cannot be empty.");
            return;
        }

        
        boolean success = model.addSchoolToDatabase(schoolName);

        if (success) {
            System.out.println("School added: " + schoolName);

            List<String> schools = model.getSchools();
            view.populateSchoolsGrid(schools);

            view.clearSchoolTextField();
        } else {
            System.out.println("Failed to add school to database.");
        }
    }
    
    
    private void deleteSchool() {
    String selectedSchool = view.getSelectedSchool(); // Παίρνουμε την επιλεγμένη σχολή από το JTable

    if (selectedSchool == null || selectedSchool.isEmpty()) {
        System.out.println("Error: No school selected.");
        return;
    }

  
    boolean success = model.deleteSchoolFromDatabase(selectedSchool);

    if (success) {
        System.out.println("School deleted: " + selectedSchool);

     
        List<String> schools = model.getSchools();
        view.populateSchoolsGrid(schools);
    } else {
        System.out.println("Failed to delete school from database.");
    }
}


    public void run() {
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view));
        view.setVisible(true);
    }

    public void closeDialog() {
        System.out.println("Closing frame...");
        view.dispose();
    }

}
