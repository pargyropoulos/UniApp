/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import HTTP.WebData;
import repository.UniversityJpaController;
import repository.Emf;
import repository.University;
import java.util.List;

/**
 *
 * @author tasos
 */
public class UniRecDialogModel {
    private WebData universityData;

    public UniRecDialogModel(WebData universityData) {  // Constructor με WebData
        this.universityData = universityData;
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
}
