package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */


public class CustomEventSource {
    private final List<CustomEventListener> listeners = new ArrayList<>();

    public void addEventListener(CustomEventListener listener) {
        listeners.add(listener);
    }

    public void removeEventListener(CustomEventListener listener) {
        listeners.remove(listener);
    }

    public void notifyEventListeners(Object message, String eventName) {
        CustomEvent event = new CustomEvent(this, message,eventName); 
        for (CustomEventListener listener : listeners) {
            listener.onCustomEvent(event);
        }
    }
    
    public void notifyEventListeners(Object message) {
        CustomEvent event = new CustomEvent(this, message); 
        for (CustomEventListener listener : listeners) {
            listener.onCustomEvent(event);
        }
    }
}

