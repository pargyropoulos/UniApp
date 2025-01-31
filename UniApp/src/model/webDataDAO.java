/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 *
 * @author  Panagiotis Argyropoulos - pargyropoulos@gmail.com or std154845@ac.eap.gr
 */

public class webDataDAO implements Serializable  {
    private webDataPOJO webData;
    
    public webDataDAO(){
        this.webData=new webDataPOJO();        
    }
    
    public List<webDataPOJO> getAllWebUnis(){
       String urlToCall = "http://universities.hipolabs.com/search";
        
        OkHttpClient client=new OkHttpClient();
        
        Request request = new Request.Builder().url(urlToCall).build();
        
        List<webDataPOJO> universitiesList = new ArrayList<>();
        List<webDataPOJO> lst = new ArrayList<>();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponseString=response.body().string();
//                System.out.println(jsonResponseString);
                
                Gson gson = new Gson();
                webDataPOJO[] universityArray = gson.fromJson(jsonResponseString, webDataPOJO[].class);
                                
                Type listType = new TypeToken<List<webDataPOJO>>() {}.getType();
                universitiesList = gson.fromJson(jsonResponseString, listType);
                lst = gson.fromJson(jsonResponseString, listType);
                
//                System.out.println( universityArray.toString());
            
// Convert array to list
                if (universityArray != null) {
                    universitiesList = List.of(universityArray);
                }                
//                System.out.println( universitiesList.toString());
                
//                for (webDataPOJO item:universitiesList){
//                    System.out.println( item.toString());
//                }
                
            }
        }
        catch (IOException e){
            e.printStackTrace();
        } 
        
        return lst;
    }
    
}
