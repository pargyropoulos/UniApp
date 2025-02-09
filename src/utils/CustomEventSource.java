package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 * @param <T>
 */

public class CustomEventSource <T> {
    private final List<ICustomEventListener<T>> listeners = new ArrayList<>();

    public void addEventListener(ICustomEventListener<T> listener) {
        listeners.add(listener);
    }

    public void removeEventListener(ICustomEventListener<T> listener) {
        listeners.remove(listener);
    }
    
    //overloading method for listeners that return nothing
    public void notifyEventListeners() {
        this.notifyEventListeners(null);
    }
    
    public void notifyEventListeners(T message) {
        CustomEvent<T> event = new CustomEvent<> (this, message); 
        for (ICustomEventListener<T> listener : listeners) {
            listener.onCustomEvent(event);
        }
    }
}

