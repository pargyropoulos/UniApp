package controller;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.*;
import utils.CustomEvent;
import utils.CustomEventListener;
import view.*;

/**
 * 
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public final class mainController implements CustomEventListener{
    private final mainView view;
    private final List<String> openPanelsList=new ArrayList<>();
    private JPanel activePanel=null;
    
    public mainView getView() {
        return view;
    }

    /**
     * 
     * @param view 
     */
    public mainController(mainView view) {
        this.view = view;
        view.addUniBtnListener(e->loadUniGridForm());
        view.addExitBtnListener(e->System.exit(0));
    }
    
    /**
     * Creates as new UniGridController
     */
    private void loadUniGridForm(){
        if (activePanel instanceof uniGridView) return;
        uniGridView panelView=new uniGridView();
        uniGridController ctrl=new uniGridController(panelView, new  uniGridModel());
        ctrl.closeFormEventSource.addEventListener(this);
     
        addPanel(panelView);
        ctrl.run();
    }
    
    private void addPanel(JPanel view){
        this.view.addPanel(view);
        this.activePanel=view;
    }

    private void removePanel(JPanel view){
        this.view.removePanel(view);
        this.activePanel=null;

    }
    
//    private boolean isPanelAlreadyAdded(String viewName) {
//        for (var item: this.openPanelsList){
//            if (item == null ? viewName == null : item.equals(viewName)) return true;
//        }
//        return false;
//    } 

    @Override
    public void onCustomEvent(CustomEvent e) {
        this.removePanel(activePanel);
    }
}
