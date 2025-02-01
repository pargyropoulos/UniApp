
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
    
    public final CustomEventSource customEventSource = new CustomEventSource();
    
    public searchController(searchDialogView view,searchModel model) {
        this.model = model;
        this.view = view;
        view.getSearchBtn().addActionListener(this);
        view.getCancelBtn().addActionListener(e-> view.dispose());
        view.getUniversityName().addFocusListener(this);
        view.getCountry().addFocusListener(this);
    }
    
    public void search(){
        view.getInfoLabel().setText("Please wait while fetching data...");
        view.getInfoLabel().setVisible(true);
        webDataDAO dao = new webDataDAO();
        System.out.println(model.getSearchString());
        List<webDataPOJO> universityList = dao.fetchUniversities(model.getSearchString());
        
        customEventSource.notifyEventListeners(universityList,"Data_Fetched");
        view.getInfoLabel().setVisible(false);
        System.out.println(model.getUniversityName());
        System.out.println(model.getCountry());
        System.out.println(universityList);
        if (!universityList.isEmpty()) {
            view.dispose();
        }else {
            view.getInfoLabel().setText("info message: No entry found!");
            view.getInfoLabel().setVisible(true);
        }
    }

    private void populateModel(){
        model.setUniversityName(view.getUniversityName().getText());
        model.setCountry(view.getCountry().getSelectedItem().toString());
        System.out.println(model.getUniversityName());
        System.out.println(model.getCountry());
    }

    private Boolean isTextValidated(){
        Boolean validated=true;
        if (!model.isAlphanumeric(view.getUniversityName().getText())) {
            view.getUniversityNameErrorLabel().setVisible(true);
            view.getUniversityName().setToolTipText("Only alphanumeric characters are valid!");
            validated=false;
        } else {
            view.getUniversityNameErrorLabel().setVisible(false);
            view.getUniversityName().setToolTipText(null);
        }
        
//        if (!model.isAlphanumeric(view.getCountry().getSelectedItem().toString())) {
//            view.getCountryErrorLabel().setVisible(true);
//            view.getCountry().setToolTipText("Only alphanumeric characters are valid!");
//            validated= false;
//        } else {
//            view.getCountryErrorLabel().setVisible(false);
//            view.getCountry().setToolTipText(null);
//        }
        
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
