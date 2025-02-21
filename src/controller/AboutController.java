
package controller;

import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.AboutView;


public class AboutController {
    private AboutView view;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();
    
    /**
     * Adds event listener to close button
     * @param listener 
     */
    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
            
    /**
     * Returns the current view instance
     * @return 
     */
    public AboutView getView(){
        return this.view;
    }
    
    
    /**
     * Class constructor
     * @param view 
     */
    public AboutController(AboutView view) {
        this.view=view;
        view.addCloseButtonListener(e-> {
            view.setVisible(false); 
            closeFormEventSource.notifyEventListeners();
        });
    }
    
/**
 * Shows the View
 */   
    public void run(){
        view.setVisible(true);
        view.revalidate();
        view.repaint();
    }
    
}
