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

    /**
     * 
     * @param view 
     */
    public mainController(mainView view) {
        this.view = view;
        view.getUniBtn().addActionListener(e->loadUniGridForm());
        view.getExitBtn().addActionListener(e->System.exit(0));
        this.showView();
    }
    
    public void showView() {
        view.setVisible(true);
    }    
    
    /**
     * Creates as new UniGridController
     */
    public void loadUniGridForm(){
        if (isPanelAlreadyAdded("uniGridView")) return;
        uniGridController ctrl=new uniGridController(new uniGridView(), new webDataPOJO());
        this.view.getMainPanel().add(ctrl.getView());
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
