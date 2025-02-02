package model;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */

import java.util.List;
import utils.CustomEvent;
import utils.CustomEventSource;
import utils.CustomEventListener;

public class uniGridModel implements CustomEventListener {
    private List<webDataPOJO> data;
    public final CustomEventSource dataUpdatedEventSource = new CustomEventSource();

    private void setData(List<webDataPOJO> data) {
        this.data = data;
        dataUpdatedEventSource.notifyEventListeners(data);
    }

    public List<webDataPOJO> getData() {
        return data;
    }
    
    public uniGridModel(){
        this.data = null;
    }
    
    public uniGridModel(List<webDataPOJO> data) {
        this.data = data;
    }

    @Override
    public void onCustomEvent(CustomEvent e) {
        //check if proper data casting can be performed
        try {
            @SuppressWarnings("unchecked")
            List<webDataPOJO> data=(List<webDataPOJO>)e.getEventMessage();
            setData(data);
        }catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }
        
}
