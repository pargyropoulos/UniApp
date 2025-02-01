package controller;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.searchModel;
import model.uniGridModel;
import model.webDataPOJO;
import utils.CustomEvent;
import utils.ICustomEventListener;
import view.searchDialogView;
import view.uniGridView;
import view.utils;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class uniGridController implements ICustomEventListener {
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
        view.getSearchBtn().addActionListener(e->loadSearchForm());
        view.getViewEditBtn().addActionListener(e->loadViewEditForm());
        view.populateGrid(null);
    }
    
    private void loadViewEditForm(){
        int index=this.view.getGrid().getSelectedRow();
        System.out.println("view edit btn pressed...");
        if (index==-1) return;
        webDataPOJO selectedUniModel = new webDataPOJO();
        selectedUniModel=this.model.getData().get(index);
        System.out.println(selectedUniModel);
    }
    
    private void loadSearchForm(){
        JFrame parentFrame = (JFrame) SwingUtilities.getWindowAncestor(view);
        searchDialogView sView= new searchDialogView(  parentFrame,true);
        sView.setLocation(utils.getParentCenterLocation(parentFrame, sView));        
        
        searchController ctrl=new searchController(sView, new searchModel());
        ctrl.customEventSource.addEventListener(this);
        sView.setVisible(true);
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onCustomEvent(CustomEvent e) {
        Object eventMessage = e.getEventMessage();
        String eventName=e.getEventName();
        
        switch (eventName){
            case "Data_Fetched":    
                this.model.setData((List<webDataPOJO>) eventMessage);
                this.view.populateGrid(model.getData());       
        }
//        for (var item:this.model.getData()){
//            System.out.println(item.getCountry());
//        }
    }
}
