package model;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */

import java.util.List;

public class uniGridModel {
    private List<webDataPOJO> data;

    public void setData(List<webDataPOJO> data) {
        this.data = data;
    }

    public List<webDataPOJO> getData() {
        return data;
    }
    
    public uniGridModel(){
        this.data = null;
    }
    
    public uniGridModel(List<webDataPOJO> data) {
        this.data = data;
    }
}
