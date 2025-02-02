
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import model.searchModel;
import model.webDataDAO;
import model.webDataPOJO;
import utils.CustomEventSource;
import view.searchDialogView;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class searchController implements ActionListener, FocusListener{
    private final searchModel model;
    private final searchDialogView view;
    
    public final CustomEventSource dataFetchedEventSource = new CustomEventSource();
    
    public searchController(searchDialogView view,searchModel model) {
        this.model = model;
        this.view = view;
        view.addSearchBtnActionListener(this::actionPerformed);
        view.addCancelBtnActionListener(e-> view.dispose());
        view.addUniversityNameTextBoxFocusListener(this);
        view.addCountryComboBoxFocusListener(this);
        
    }
    
    public void search(){
//        view.getInfoLabel().setText("Please wait while fetching data...");
//        view.getInfoLabel().setVisible(true);
        webDataDAO dao = new webDataDAO();
        System.out.println(model.getSearchString());
        List<webDataPOJO> universityList = dao.fetchUniversities(model.getSearchString());
        
        dataFetchedEventSource.notifyEventListeners(universityList,"Data_Fetched");
        view.setInfoLabelVisible(false);
        System.out.println(model.getUniversityName());
        System.out.println(model.getCountry());
        System.out.println(universityList);
        if (!universityList.isEmpty()) {
            view.dispose();
        }else {
            view.setInfoLabelText("info message: No entry found!");
            view.setInfoLabelVisible(true);
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
        if (!model.isAlphanumeric(view.getUniversityName())) {
            view.setErrorLabelVisible(true);
//            view.getUniversityName().setToolTipText("Only alphanumeric characters are valid!");
            validated=false;
        } else {
            view.setErrorLabelVisible(false);
//            view.getUniversityName().setToolTipText(null);
        }
                
        return validated;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isTextValidated()) search();
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (isTextValidated()) populateModel();
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

}
