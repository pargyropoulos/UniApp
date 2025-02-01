package controller;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.*;
import view.*;

/**
 * 
 * @author Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public final class mainController {
    private final mainView view;
    private final List<String> openPanelsList=new ArrayList<>();
    
    public mainView getView() {
        return view;
    }

    
    /**
     * 
     * @param view 
     */
    public mainController(mainView view) {
        this.view = view;
        view.getUniBtn().addActionListener(e->loadUniGridForm());
        view.getExitBtn().addActionListener(e->System.exit(0));
    }
    
    /**
     * Creates as new UniGridController
     */
    private void loadUniGridForm(){
        uniGridController ctrl=new uniGridController(new uniGridView(), new  uniGridModel());
        this.showPanel(ctrl.getView());
    }
    
    public void showPanel(JPanel panel) {
        if (isPanelAlreadyAdded("uniGridView")) return;

        this.view.getMainPanel().add(panel);
        this.view.getMainPanel().revalidate();
        this.view.getMainPanel().repaint();
        openPanelsList.add("uniGridView");
    }
    
    private boolean isPanelAlreadyAdded(String viewName) {
        for (var item: this.openPanelsList){
            if (item==viewName) return true;
        }
        return false;
    } 
    
}
