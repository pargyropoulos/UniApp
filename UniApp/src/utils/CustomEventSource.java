package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */


public class CustomEventSource {
    private final List<ICustomEventListener> listeners = new ArrayList<>();

    public void addEventListener(ICustomEventListener listener) {
        listeners.add(listener);
    }

    public void removeEventListener(ICustomEventListener listener) {
        listeners.remove(listener);
    }

    public void notifyEventListeners(Object message) {
        CustomEvent event = new CustomEvent(this, message); // Pass `this` as source
        for (ICustomEventListener listener : listeners) {
            listener.onCustomEvent(event);
        }
    }
}

