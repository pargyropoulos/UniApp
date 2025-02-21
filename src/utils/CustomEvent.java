package utils;

import java.util.EventObject;

/**
 *
 * Custom Event Class
 * Use it to create custom events
 * @param <T>
 */
public class CustomEvent <T> extends EventObject {
    private final T messageObject;
    

    public CustomEvent(Object source, T messageObject) {
        super(source);  // Call EventObject constructor
        this.messageObject = messageObject;
    }

    public T getEventMessage() {
        return messageObject;
    }
}
