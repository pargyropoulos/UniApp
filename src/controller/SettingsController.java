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
 * Controller part of the Settings MVC
 */
public class SettingsController {
    private final ISettingsModel model;
    private final ISettingsView view;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();

    /**
     * Adds event listener to the close form event
     * @param listener 
     */    
    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
    
    /**
     * Class Constructor. Maps event listeners and populates country's list
     * @param view
     * @param model 
     */
    public SettingsController(ISettingsView view,ISettingsModel model) {
        this.model = model;
        this.view = view;  
        mapListeners();
        model.populateCountryList();
    }
    
    /**
     * Event listeners mapping
     */
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
    
    /**
     * Returns the view's instance
     * @return 
     */
    public JPanel getView(){
        return view.getView();
    }

    /**
     * Deletes an entry from the model and the view
     */
    private void deleteEntry(){
        int index= this.view.getSelectedRowIndex();
        if (index==-1) return;
        this.model.deleteCountry(index);
    }
    
    /**
     * Adds an entry from the model and the view
     */    
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


