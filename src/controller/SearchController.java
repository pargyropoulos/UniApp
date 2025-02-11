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
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class SearchController implements ActionListener, FocusListener{
    private final SearchModel model;
    private final SearchDialogView view;
    private final CustomEventSource<List<WebData>> dataFetchedEventSource = new CustomEventSource<>();
    
    public void addDataFetchedEventListener (ICustomEventListener<List<WebData>> listener){
        dataFetchedEventSource.addEventListener(listener);
    }
    
    public SearchController(SearchDialogView view,SearchModel model) {
        this.model = model;
        this.view = view;
        view.populateComboBox(model.getListOfCountries());
        view.addSearchBtnActionListener(e->actionPerformed(e));
        view.addCancelBtnActionListener(e-> view.dispose());
        view.addUniversityNameTextBoxActionListener(e->actionPerformed(e));
        view.addCountryComboBoxFocusListener(this);
////        public final CustomEventSource<List<Country>> dataUpdatedEventSource = new CustomEventSource<>();
    }
    
    public void run(){
        //center the new for inside main frame
        this.view.setLocation(Utils.getParentCenterLocation(this.view.getParent(), this.view)); 
        this.view.setVisible(true);
    }
    
    private void search(){
//        view.getInfoLabel().setText("Please wait while fetching data...");
//        view.getInfoLabel().setVisible(true);
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

    private void populateModel(){
        model.setUniversityName(view.getUniversityName());
        model.setCountry(view.getCountry());
        System.out.println(model.getUniversityName());
        System.out.println(model.getCountry());
    }

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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        populateModel();
        if (isTextValidated()) search();
    }

    @Override
    public void focusLost(FocusEvent e) {
        populateModel();
    }

    @Override
    public void focusGained(FocusEvent e){
        populateModel();
    };

}
