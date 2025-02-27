package model;

import HTTP.WebData;
import java.util.List;
import utils.CustomEventSource;
import utils.ICustomEventListener;
/**
 * 
 * Model part of the UniGrid MVC
 */
public class UniGridModel { 
    private List<WebData> data;
    private final CustomEventSource<List<WebData>> dataUpdatedEventSource = new CustomEventSource<>();

    public void addDataUpdatedEventListener(ICustomEventListener<List<WebData>> listener){
        dataUpdatedEventSource.addEventListener(listener);
    }
            
    public void setData(List<WebData> data) {
        this.data = data;
        dataUpdatedEventSource.notifyEventListeners(data);
    }

    public List<WebData> getData() {
        return data;
    }
    
    public UniGridModel(){
        this.data = null;
    }
    
    public UniGridModel(List<WebData> data) {
        this.data = data;
    }        
}
