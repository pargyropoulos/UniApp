package utils;

import java.util.EventObject;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 * Custom Event Class
 * Use it to create custom events
 */
public class CustomEvent extends EventObject {
    private final Object messageObject;
    
    // Constructor: Pass the source and event message
    public CustomEvent(Object source, Object messageObject) {
        super(source);  // Call EventObject constructor
        this.messageObject = messageObject;
    }

    public Object getMessage() {
        return messageObject;
    }
}
