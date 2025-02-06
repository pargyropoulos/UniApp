package HTTP;

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

public class WebDataFetcher implements Serializable  {
    private static final String URL = "http://universities.hipolabs.com/search";
    private List<WebData> list=new ArrayList<>();

    public List<WebData> getList() {
        return list;
    }
    
    public List<WebData> fetchUniversities(String searchString){
        String url=this.URL;
        url+=searchString;
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponseString=response.body().string();
                
                Gson gson = new Gson();
                Type listType = new TypeToken<List<WebData>>() {}.getType();
                this.list = gson.fromJson(jsonResponseString, listType);                
                return this.list;
            }
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        } 
        return null;
    }   
}
