package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.searchModel;
import model.uniGridModel;
import model.webDataPOJO;
import utils.CustomEventSource;

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
    public final CustomEventSource closeFormEventSource;
    
    public void run(){
        this.view.setVisible(true);
    }
    
    public uniGridController(uniGridView view, uniGridModel model) {
        this.view = view;
        this.model = model;
        this.closeFormEventSource = new CustomEventSource();
        
//        view.addSearchButtonListener(this::loadSearchForm);
        view.addSearchButtonListener(e -> loadSearchForm(e));
        view.addViewEditButtonListener(e-> loadViewEditForm());
        view.addCloseButtonListener(e-> closeForm());
        model.dataUpdatedEventSource.addEventListener(this.view);
//        view.addViewEditButtonListener((ActionEvent e) -> {
//            loadViewEditForm();
//        });

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
        searchController ctrl=new searchController(new searchDialogView((JFrame)SwingUtilities.getWindowAncestor(view),true), new searchModel());
        ctrl.dataFetchedEventSource.addEventListener(this.model);
        ctrl.run();
    }

    private void closeForm() {
        view.setVisible(false);
        view.revalidate();
        view.repaint();
        closeFormEventSource.notifyEventListeners(this);
    }
}
