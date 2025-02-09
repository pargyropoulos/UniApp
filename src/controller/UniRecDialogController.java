/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UniRecDialogModel;
import view.UniRecDialogView;
import view.Utils;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.UniRecDialogModel;
import model.SearchModel;
import model.UniGridModel;
import HTTP.WebData;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.UniRecDialogView;
import view.SearchDialogView;
import view.UniGridView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;


/**
 *
 * @author tasos
 */
public class UniRecDialogController {
    private UniRecDialogModel model;
    private UniRecDialogView view;

    public UniRecDialogController( UniRecDialogView view,UniRecDialogModel model) {
        this.model = model;
        this.view = view;
        
        
         WebData universityWeb = model.getUniversityData();
        
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

      
        
             
        // Προσθέτουμε τον listener για το κουμπί Exit
        view.addExitButtonListener(e -> closeDialog());
        
    }
    
   
   
    
    public void run(){
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view)); 
        view.setVisible(true);
    }
    
    public void closeDialog(){
        System.out.println("Closing frame...");
        view.dispose();
    }

   

        
        
}
