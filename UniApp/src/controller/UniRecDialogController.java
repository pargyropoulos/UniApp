/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UniRecDialogModel;
import view.UniRecDialogView;
import view.utils;

/**
 *
 * @author tasos
 */
public class UniRecDialogController {
    private UniRecDialogModel model;
    private UniRecDialogView view;

    public UniRecDialogController( UniRecDialogView view,UniRecDialogModel model) {
        this.model = model;
        this.view = view;
        
    }
    
    public void run(){
        this.view.setLocation(utils.getParentCenterLocation(this.view.getParent(), this.view)); 
        view.setVisible(true);
    }
}
