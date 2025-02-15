package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import repository.entities.Country;
import model.SettingsModel.ISettingsModel;
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
        model.addDataUpdatedEventListener(e->view.updateGrid(e.getEventMessage()));
        view.addCloseEventListener(e->closeFormEventSource.notifyEventListeners());
        view.addClearDbEventListener(e->clearDB());
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
    
    private Boolean toggle=false;
    private void clearDB(){
        if (!toggle){
            toggle=!toggle;
            view.setClearDBbtnText("Click if you dare!");
            return;
        }
        
        toggle=!toggle;
        view.setClearDBbtnText("Clear DB");
        
        try {
            model.clearDb();
            } catch (Exception ex) {
                Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    

    public void run(){
        this.view.show();
    }
}


