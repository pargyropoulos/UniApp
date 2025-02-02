package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.searchModel;
import model.uniGridModel;
import model.webDataPOJO;

import view.searchDialogView;
import view.uniGridView;
import view.utils;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class uniGridController{
    private final uniGridView view;
    private final uniGridModel model;
    
    public uniGridView getView() {
        return view;
    }

    public uniGridModel getModel() {
        return model;
    }

    public uniGridController(uniGridView view, uniGridModel model) {
        this.view = view;
        this.model = model;
        view.addSearchButtonListener(this::loadSearchForm);
//        view.addViewEditButtonListener(e-> loadViewEditForm());
        view.addViewEditButtonListener((ActionEvent e) -> {
            loadViewEditForm();
        });
        model.dataUpdatedEventSource.addEventListener(this.view);
    }
    
    private void loadViewEditForm(){
        int index=this.view.getSelecedRowIndex();
        System.out.println("view edit btn pressed...");
        if (index==-1) return;
        webDataPOJO selectedUniModel = new webDataPOJO();
        selectedUniModel=this.model.getData().get(index);
        System.out.println(selectedUniModel);
    }
    
    private void loadSearchForm(ActionEvent e){
        //center the new for inside main frame
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
        searchDialogView sView= new searchDialogView(  parentFrame,true);
        sView.setLocation(utils.getParentCenterLocation(parentFrame, sView));        
        
        searchController ctrl=new searchController(sView, new searchModel());
        ctrl.dataFetchedEventSource.addEventListener(this.model);
        sView.setVisible(true);
    }
}
