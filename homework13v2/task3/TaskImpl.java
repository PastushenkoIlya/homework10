package homework13v2.task3;
import com.google.gson.Gson;
import homework13v2.task1.models.Task3Entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class TaskImpl {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private static final Gson gson = new Gson();
    public static List<Task3Entity> Task3(int id){
        try{
            URL url = new URL(BASE_URL + "/"+id+"/todos?completed=false");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            try(BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
                if(responseCode == HttpURLConnection.HTTP_OK){
                    Task3Entity[] tasks = gson.fromJson(reader.readLine(), Task3Entity[].class);
                    return Arrays.asList(tasks);
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
