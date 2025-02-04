/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.List;
import java.util.Map;
import model.SettingsModel;
import utils.CustomEventSource;
import view.SettingsView;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class SettingsController {
    private final SettingsModel model;
    private final SettingsView view;
    public final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();
    private List<SettingsModel> modelList;
    
    
    public SettingsView getView() {
        return view;
    }

    public SettingsController(SettingsView view,SettingsModel model) {
        this.model = model;
        this.view = view;
        view.addCloseButtonListener(e-> {
            System.out.println("Button Close is pressed");
            view.setVisible(false); 
            closeFormEventSource.notifyEventListeners();
        });        
    }
    
    public void populateList(){
        
    }
    
    public void run(){
        this.view.setVisible(true);
        this.view.revalidate();
        this.view.repaint();
    }


}


