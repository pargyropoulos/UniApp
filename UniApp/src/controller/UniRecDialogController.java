/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UniRecDialogModel;
import view.UniRecDialogView;

/**
 *
 * @author tasos
 */
public class UniRecDialogController {
    private UniRecDialogModel model;
    private UniRecDialogView view;

    public UniRecDialogController(UniRecDialogModel model, UniRecDialogView view) {
        this.model = model;
        this.view = view;
        
    }
    
    public void run(){
        view.setVisible(true);
    }
}
