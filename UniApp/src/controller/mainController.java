package controller;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
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
        
        //test Tasos
//        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
        UniRecDialogView uniRecView=new UniRecDialogView(this.view,true);
//        uniRecView.setLocation(utils.getParentCenterLocation(this.view, uniRecView));        
//        searchController ctrl=new searchController(uniRecView, new searchModel());
        uniRecView.setVisible(true);        
        
    }
    
    /**
     * Creates as new UniGridController
     */
    private void loadUniGridForm(){
        if (isPanelAlreadyAdded("uniGridView")) return;
        uniGridController ctrl=new uniGridController(new uniGridView(), new  uniGridModel());
        this.showPanel(ctrl.getView());
        openPanelsList.add("uniGridView");
    }
    
    public void showPanel(JPanel panel) {
        this.view.getMainPanel().add(panel);
        this.view.getMainPanel().revalidate();
        this.view.getMainPanel().repaint();
    }
    
    private boolean isPanelAlreadyAdded(String viewName) {
        for (var item: this.openPanelsList){
            if (item == null ? viewName == null : item.equals(viewName)) return true;
        }
        return false;
    } 
}
