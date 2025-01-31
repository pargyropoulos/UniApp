package controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.searchModel;
import model.webDataDAO;
import model.webDataPOJO;
import utils.CustomEvent;
import utils.ICustomEventListener;
import view.searchDialogView;
import view.uniGridView;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class uniGridController implements ICustomEventListener {
    private final uniGridView view;
    private final webDataPOJO model;
    
    public uniGridView getView() {
        return view;
    }

    public webDataPOJO getModel() {
        return model;
    }

    public uniGridController(uniGridView view, webDataPOJO model) {
        this.view = view;
        this.model = model;
        view.getSearchBtn().addActionListener(e->loadSearchForm());
//        webDataDAO dao = new webDataDAO();
//        List<webDataPOJO> universityList = dao.getAllWebUnis();
//        view.populateGrid(universityList);
        view.populateGrid(null);
//        model.setName("No Entries");
    }
    
    private void loadSearchForm(){
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
        searchDialogView sView= new searchDialogView(  parentFrame,true);
        
//        System.out.println(parentFrame.toString());
//        System.out.println(parentFrame.getClass().toString());
        //center search window on the center of the parent
        int parentX =parentFrame.getX();
        int parentY = parentFrame.getY();
        int parentWidth = parentFrame.getWidth();
        int parentHeight = parentFrame.getHeight();
        int childWidth = sView.getWidth();
        int childHeight = sView.getHeight();
        int centerX = parentX + (parentWidth - childWidth) / 2;
        int centerY = parentY + (parentHeight - childHeight) / 2;
        sView.setLocation(centerX, centerY);        
        searchController ctrl=new searchController(sView, new searchModel());
        //        view.setAlwaysOnTop(true);
        ctrl.customEventSource.addEventListener(this);
        sView.setVisible(true);
        
    }

    @Override
    public void onCustomEvent(CustomEvent e) {
        System.out.println("got the event!" + " " + e.getMessage());       
        this.view.populateGrid((List<webDataPOJO>) e.getMessage());        
//        this.view.revalidate();
//        this.view.repaint();
    }
}
