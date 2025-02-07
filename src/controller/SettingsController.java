/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import javax.swing.JPanel;
import model._SettingsModel.Country;
import model._SettingsModel.ISettingsModel;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.settingsForm.ISettingsView;


/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class SettingsController {
    private final ISettingsModel model;
    private final ISettingsView view;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();
//    public final CustomEventSource<List<Country>> dataUpdatedEventSource =new CustomEventSource<>();
    
    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
    
    public SettingsController(ISettingsView view,ISettingsModel model) {
        this.model = model;
        this.view = view;  
        mapListeners();
        model.populateCountryList();
        
    }
    
    private void mapListeners(){
//        model.dataUpdatedEventSource.addEventListener(e->view.updateGrid(e.getEventMessage()));
        model.addDataUpdatedEventListener(e->view.updateGrid(e.getEventMessage()));
        view.addCloseEventListener(e->{System.out.println("form closed!"); closeFormEventSource.notifyEventListeners();});
        view.addClearDbEventListener(e->System.out.println("clears db!"));
        view.addSaveEventListener(e->System.out.println("Saves changes"));
        view.addSaveEventListener(e-> {
            try {
                model.saveData();
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        view.addDeleteEntryEventListener(e-> deleteEntry());
        view.addAddEntryEventListener(e-> addEntry());
    }
    
    public JPanel getView(){
        return view.getView();
    }

    
    private void deleteEntry(){
        int index= this.view.getSelectedRowIndex();
        if (index==-1) return;
        this.model.deleteCountry(index);
    }
    
    private void addEntry(){
        Country country=new Country();
        country.setName(view.getCountryTextBox());
        if (country.getName().isEmpty()) return;
        model.addCountry(country);
        view.setCountryTextBox(null);
    }
    
    public void populateList(){
    }
    
    public void run(){
        this.view.show();
    }

}


