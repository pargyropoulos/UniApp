
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
        List<webDataPOJO> universityList = dao.getAllWebUnis();
        
        customEventSource.notifyEventListeners(universityList);
        view.getInfoLabel().setVisible(false);
        System.out.println(model.getUniversityName());
        System.out.println(model.getCountry());
        if (universityList!=null) view.dispose();
    }

    private void populateModel(){
        model.setUniversityName(view.getUniversityName().getText());
        model.setCountry(view.getCountry().getText());
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
        
        if (!model.isAlphanumeric(view.getCountry().getText())) {
            view.getCountryErrorLabel().setVisible(true);
            view.getCountry().setToolTipText("Only alphanumeric characters are valid!");
            validated= false;
        } else {
            view.getCountryErrorLabel().setVisible(false);
            view.getCountry().setToolTipText(null);
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
