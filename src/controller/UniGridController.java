package controller;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import model.uniRecModel.UniRecDialogModel;
import model.SearchModel;
import model.UniGridModel;
import HTTP.WebData;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.UniRecDialogView;
import view.SearchDialogView;
import view.UniGridView;



/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class UniGridController{
    private final UniGridView view;
    private final UniGridModel model;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();
  //

    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
    public UniGridController(UniGridView view, UniGridModel model) {
        this.view = view;
        this.model = model;
        
        //map event listeners to Model and View
        view.addSearchButtonListener(e -> loadSearchForm());
        view.addViewEditButtonListener(e-> loadViewEditForm());
        view.addCloseButtonListener(e-> closeForm());
        model.addDataUpdatedEventListener(e-> view.populateGrid(e.getEventMessage()));
//        view.addSearchButtonListener(this::loadSearchForm);

    }    

    public UniGridView getView() {
        return view;
    }
    
    public void run(){
        this.view.setVisible(true);
    }
    
    private void loadViewEditForm(){
        int index=this.view.getSelecedRowIndex();
//        System.out.println("view edit btn pressed...");
        if (index==-1) return;
        WebData selectedUniModel = this.model.getData().get(index);
//        System.out.println(selectedUniModel);
        UniRecDialogController ctrl=new UniRecDialogController(new UniRecDialogView((JFrame)SwingUtilities.getWindowAncestor(view),true), new UniRecDialogModel(selectedUniModel));
        ctrl.run();
        
    }
    
    private void loadSearchForm(){
        SearchDialogView sView =new SearchDialogView((JFrame)SwingUtilities.getWindowAncestor(view),true);
        SearchModel sModel=new SearchModel();
        SearchController ctrl=new SearchController(sView, sModel);
//        ctrl.dataFetchedEventSource.addEventListener(event -> model.setData(event.getEventMessage()));
        ctrl.addDataFetchedEventListener(event -> model.setData(event.getEventMessage()));
        ctrl.addDataFetchedEventListener(event -> view.setEntriesCount(event.getEventMessage().size()));
        
        ctrl.run();
    }

    private void closeForm() {
        view.setVisible(false);
        view.revalidate();
        view.repaint();
        closeFormEventSource.notifyEventListeners();
    }
}
