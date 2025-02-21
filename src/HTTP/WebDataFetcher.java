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

public class WebDataFetcher implements Serializable  {
    private static final String URL = "http://universities.hipolabs.com/search";
    
    public List<WebData> fetchUniversities(String searchString) throws IOException{
        String url=this.URL;
        url+=searchString;
        System.out.println(url);
        OkHttpClient client=new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        List<WebData> list=new ArrayList<>();
        
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String jsonResponseString=response.body().string();
                Gson gson = new Gson();
                Type listType = new TypeToken<List<WebData>>() {}.getType();
                list=gson.fromJson(jsonResponseString, listType);          
                return list;
            }else {
                return list;
            }
        } catch (IOException e){
            System.out.println("errror");
            throw new IOException(" HTTP error. Failed to fetch data.");
        }
    }   
}
