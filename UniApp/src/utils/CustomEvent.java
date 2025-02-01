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
    private final String eventName;
    
    // Constructor: Pass the source and event message
    public CustomEvent(Object source, Object messageObject,String eventName) {
        super(source);  // Call EventObject constructor
        this.messageObject = messageObject;
        this.eventName = eventName;
    }

    public CustomEvent(Object source, Object messageObject) {
        super(source);  // Call EventObject constructor
        this.messageObject = messageObject;
        this.eventName = null;
    }

    public String getEventName() {
        return eventName;
    }
    
    public Object getEventMessage() {
        return messageObject;
    }
}
