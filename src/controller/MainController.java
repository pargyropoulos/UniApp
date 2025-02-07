package controller;

import view.settingsForm.SettingsView;
import model._SettingsModel.SettingsModel;
import javax.swing.JPanel;
import model.*;
import view.*;

/**
 * 
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public final class MainController{
    private final MainView view;
    private JPanel activePanel=null;
    
    /**
     * 
     * @param view 
     */
    public MainController(MainView view) {
        this.view = view;
        view.addUniBtnListener(e->loadUniGridForm());
        view.addAboutBtnListener(e->loadAboutForm());
        view.addSettingsBtnListener(e->loadSettingsForm());
        view.addExitBtnListener(e->System.exit(0));
    }
    
    public void run(){
        this.view.setVisible(true);
    }
    
    /**
     * Creates a new UniGridController
     */
    private void loadUniGridForm(){
        if (activePanel instanceof UniGridView) return;
        removePanel(activePanel);
        UniGridController ctrl=new UniGridController(new UniGridView(), new  UniGridModel());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
//        ctrl.closeFormEventSource.addEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }
    
    private void loadAboutForm(){
        if (activePanel instanceof AboutView) return;
        removePanel(activePanel);
        AboutController ctrl=new AboutController(new AboutView());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }    
    
    private void loadSettingsForm(){
        if (activePanel instanceof SettingsView) return;
        removePanel(activePanel);
        SettingsController ctrl=new SettingsController(new SettingsView(),new SettingsModel());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }    
        
    private void addPanel(JPanel view){
        this.view.addPanel(view);
        this.activePanel=view;
    }

    private void removePanel(JPanel view){
        if (this.activePanel==null) return;
        this.view.removePanel(view);
        this.activePanel=null;

    }
}
