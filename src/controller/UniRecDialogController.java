package controller;

import model.uniRecModel.UniRecDialogModel;
import view.UniRecDialogView;
import view.Utils;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.uniRecModel.UniRecDialogModel;
import model.SearchModel;
import model.UniGridModel;
import HTTP.WebData;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.UniRecDialogView;
import repository.University;
import view.SearchDialogView;
import view.UniGridView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author tasos
 */
public class UniRecDialogController {

    private UniRecDialogModel model;
    private UniRecDialogView view;
    private javax.swing.JButton saveBtn;

    public UniRecDialogController(UniRecDialogView view, UniRecDialogModel model) {
        this.model = model;
        this.view = view;

        WebData universityWeb = model.getUniversityData();
        // Παίρνουμε το πανεπιστήμιο από το μοντέλο
        University university = model.getUniversity();

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
        view.addSaveButtonListener(e -> {
            saveUniversityInfo();
            System.out.println("Save button pressed!");
            view.setComponentsEnabled(false);
        });

        view.addAddSchoolButtonListener(e -> addSchool());
        view.addDeleteSchoolButtonListener(e -> deleteSchool());
        view.addSchoolSelectionListener(e -> updateDepartmentsGrid());
        view.addAddDepartmentButtonListener(e -> addDepartment());
        view.addDeleteDepartmentButtonListener(e -> deleteDepartment());
        view.addEditButtonListener(e -> {
            System.out.println("Edit button pressed!");
            view.setComponentsEnabled(true);
        });

        // Δημιουργούω το μοντέλο και αποθηκεύουω το πανεπιστήμιο αν χρειάζεται
        this.model = new UniRecDialogModel(universityWeb);

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

        view.setComponentsEnabled(false);
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

    private void updateDepartmentsGrid() {
        String selectedSchool = view.getSelectedSchool();

        if (selectedSchool == null || selectedSchool.isEmpty()) {
            System.out.println("No school selected.");
            view.populateDepartmentsGrid(List.of());
            return;
        }

        List<String> departments = model.getDepartments(selectedSchool);

        if (departments == null || departments.isEmpty()) {
            System.out.println("No departments found for school: " + selectedSchool);
            view.populateDepartmentsGrid(List.of()); //  Αν δεν υπάρχουν τμήματα, καθαρίζω
        } else {
            view.populateDepartmentsGrid(departments);
        }
    }

    private void addDepartment() {
        String departmentName = view.getDepartmentText(); // Παίρνουμε το όνομα του τμήματος
        String selectedSchool = view.getSelectedSchool(); // Παίρνουμε την επιλεγμένη σχολή από το grid3

        if (departmentName.isEmpty()) {
            System.out.println("Error: Department name cannot be empty.");
            return;
        }

        if (selectedSchool == null || selectedSchool.isEmpty()) {
            System.out.println("Error: No school selected.");
            return;
        }

        // Αποθήκευση στη βάση δεδομένων
        boolean success = model.addDepartmentToDatabase(departmentName, selectedSchool);

        if (success) {
            System.out.println("Department added: " + departmentName);

            //  Ενημέρωση του JTable με τα νέα departments
            List<String> departments = model.getDepartments(selectedSchool);
            view.populateDepartmentsGrid(departments);

            //  Καθαρίζουμε το TextField μετά την προσθήκη
            view.clearDepartmentTextField();
        } else {
            System.out.println("Failed to add department to database.");
        }
    }

    private void deleteDepartment() {
        String selectedDepartment = view.getSelectedDepartment(); // Παίρνουμε το επιλεγμένο τμήμα από το grid4
        String selectedSchool = view.getSelectedSchool(); // Παίρνουμε την επιλεγμένη σχολή από το grid3

        if (selectedDepartment == null || selectedDepartment.isEmpty()) {
            System.out.println("Error: No department selected.");
            return;
        }

        if (selectedSchool == null || selectedSchool.isEmpty()) {
            System.out.println("Error: No school selected.");
            return;
        }

        // Διαγραφή από τη βάση δεδομένων
        boolean success = model.deleteDepartmentFromDatabase(selectedDepartment, selectedSchool);

        if (success) {
            System.out.println("Department deleted: " + selectedDepartment);

            //  Ενημέρωση του JTable με τα νέα departments
            List<String> departments = model.getDepartments(selectedSchool);
            view.populateDepartmentsGrid(departments);
        } else {
            System.out.println("Failed to delete department from database.");
        }
    }

    public void run() {
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view));
        view.setVisible(true);
        view.setComponentsEnabled(false);
        //view.selectFirstSchool();
        //updateDepartmentsGrid();
    }

    public void closeDialog() {
        System.out.println("Closing frame...");
        view.dispose();
    }

}
