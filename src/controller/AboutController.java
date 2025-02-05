/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import utils.CustomEventSource;
import utils.ICustomEventListener;
import view.AboutView;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */
public class AboutController {
    private AboutView view;
    private final CustomEventSource<?> closeFormEventSource =new CustomEventSource<>();
    
    public void addCloseFormEventListener(ICustomEventListener listener){
        closeFormEventSource.addEventListener(listener);
    }
            
    public AboutView getView(){
        return this.view;
    }
    
    public AboutController(AboutView view) {
        this.view=view;
        System.out.println("pressed");
        view.addCloseButtonListener(e-> {
            view.setVisible(false); 
            closeFormEventSource.notifyEventListeners();
        });
    }

    public void run(){
        view.setVisible(true);
        view.revalidate();
        view.repaint();
    }
    
}
