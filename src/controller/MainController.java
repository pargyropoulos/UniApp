package controller;


import repository.service.Emf;
import view.settingsForm.SettingsView;
import model.SettingsModel.SettingsModel;
import javax.swing.JPanel;
import model.*;
import view.*;

/**
 * 
 * Controller. Part of the MainController MVC
 */
public final class MainController{
    private final MainView view;
    private JPanel activePanel=null;
    
    /**
     * Class constructor. Maps all events listeners to methods
     * @param view 
     */
    public MainController(MainView view) {
        this.view = view;
        view.addUniBtnListener(e->loadUniGridForm());
        view.addAboutBtnListener(e->loadAboutForm());
        view.addSettingsBtnListener(e->loadSettingsForm());
        view.addStatsBtnListener(e->loadStatsForm());
        view.addExitBtnListener(e->{
            Emf.closeEntityManagerFactory();
            System.exit(0);
        });
    }
    
    /**
     * Shows the view in the middle of the screen
     */
    public void run(){
        view.setLocationRelativeTo(null);
        this.view.setVisible(true);
    }
    
    /**
     * Creates a new MVC instance for UniGrid Form
     */
    private void loadUniGridForm(){
        if (activePanel instanceof UniGridView) return;
        removePanel(activePanel);
        UniGridController ctrl=new UniGridController(new UniGridView(), new  UniGridModel());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }

    /**
     * Creates a new MVC instance for About Form
     */
    private void loadAboutForm(){
        if (activePanel instanceof AboutView) return;
        removePanel(activePanel);
        AboutController ctrl=new AboutController(new AboutView());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }    
    
    /**
     * Creates a new MVC instance for Settings Form
     */    
    private void loadSettingsForm(){
        if (activePanel instanceof SettingsView) return;
        removePanel(activePanel);
        SettingsController ctrl=new SettingsController(new SettingsView(),new SettingsModel());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }    

    /**
     * Creates a new MVC instance for Settings Form
     */
    private void loadStatsForm(){
        if (activePanel instanceof StatisticsView) return;
        removePanel(activePanel);
        StatisticsController ctrl=new StatisticsController(new StatisticsView(),new StatisticsModel());
        ctrl.addCloseFormEventListener(e->this.removePanel(activePanel));
        addPanel(ctrl.getView());
        ctrl.run();
    }    
    
    /**
     * Helper function to add a panel inside the main panel
     * @param view 
     */
    private void addPanel(JPanel view){
        this.view.addPanel(view);
        this.activePanel=view;
    }

    /**
     * Helper function to remove a panel from the main panel
     * @param view 
     */
    private void removePanel(JPanel view){
        if (this.activePanel==null) return;
        this.view.removePanel(view);
        this.activePanel=null;

    }
}
