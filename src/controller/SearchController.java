package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import model.SearchModel;
import HTTP.WebDataFetcher;
import HTTP.WebData;
import java.io.IOException;
import java.util.ArrayList;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.SearchDialogView;
import view.Utils;

/**
 * 
 * Search Controller. Part of the Search MVC
 */
public class SearchController implements ActionListener, FocusListener{
    private final SearchModel model;
    private final SearchDialogView view;
    private final CustomEventSource<List<WebData>> dataFetchedEventSource = new CustomEventSource<>();
    
    /**
     * Adds event listener to data fetched event
     * @param listener 
     */
    public void addDataFetchedEventListener (ICustomEventListener<List<WebData>> listener){
        dataFetchedEventSource.addEventListener(listener);
    }
    
    /**
     * MVC constructor
     * Maps all evet listeners to methods
     * @param view
     * @param model 
     */
    public SearchController(SearchDialogView view,SearchModel model) {
        this.model = model;
        this.view = view;
        view.populateComboBox(model.getListOfCountries());
        view.addSearchBtnActionListener(this);
        view.addCancelBtnActionListener(e-> view.dispose());
        view.addUniversityNameTextBoxActionListener(this);
        view.addCountryComboBoxFocusListener(this);
    }
    
    /**
     * Shows the view in the center of the parent window
     */
    public void run(){
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view)); 
        this.view.setVisible(true);
    }
    
    /**
     * Initiates an HTTP request
     */
    private void search(){
        WebDataFetcher webDataFetcher = new WebDataFetcher();
        System.out.println(model.getSearchString());
        List<WebData> uniList = new ArrayList<>();
        
        try {
            uniList = webDataFetcher.fetchUniversities(model.getSearchString());
            if (!uniList.isEmpty()) {
                dataFetchedEventSource.notifyEventListeners(uniList);
                view.dispose();
        }else {
            view.setInfoLabelText("Info Message: No entry found!");
            view.setInfoLabelVisible(true);
            }
        }
        catch (IOException e) {
            view.setInfoLabelVisible(true);
            view.setInfoLabelText("Info Message:"+e.getMessage());   
            return;
        }
    }

    /**
     * Populates the model with fetched data
     */
    private void populateModel(){
        model.setUniversityName(view.getUniversityName());
        model.setCountry(view.getCountry());
    }

    /**
     * Checks if the name search string is valid
     * @return 
     */
    private Boolean isTextValidated(){

        Boolean validated=true;
        if (!model.validate(view.getUniversityName(),view.getCountry())) {
            view.setErrorLabelVisible(true);
            view.setInfoLabelText("Info Message: Only alphanumeric characters are valid!");
            validated=false;
        } else {
            view.setErrorLabelVisible(false);
        }
        return validated;
    }
    
    /**
     * Implementation if the ActionListener interface.
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        populateModel();
        if (isTextValidated()) search();
    }

    /**
     * Implementation of the FocusListener interface.
     * @param e 
     */

    @Override
    public void focusLost(FocusEvent e) {
        populateModel();
    }

    /**
     * Implementation of the FocusListener interface.
     * @param e 
     */    
    @Override
    public void focusGained(FocusEvent e){
        populateModel();
    };

}
