package controller;

import model.StatisticsModel;
import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.StatisticsView;
import view.Utils;


public class StatisticsController {
    private StatisticsView view;
    private StatisticsModel model;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();

    StatisticsController(StatisticsView statisticsView, StatisticsModel statisticsModel) {
        this.model=statisticsModel;
        this.view=statisticsView;
        view.setGridModel(this.model);
        view.addCloseButtonListener(e-> closeForm());
        view.addGraphEventListener(e->Utils.showChart(model.getUniversities()));
    }
    
    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
    
    public StatisticsView getView(){
        return this.view;
    }
    
    public void run(){
        this.view.setVisible(true);
        this.view.revalidate();
        this.view.repaint();
    }

    private void closeForm() {
        view.setVisible(false);
        view.revalidate();
        view.repaint();
        closeFormEventSource.notifyEventListeners();
    }    

}
