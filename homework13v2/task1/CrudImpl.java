package homework13v2.task1;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import homework13v2.task1.models.UserEntity;


public class CrudImpl {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/users";

    private static final Gson gson = new Gson();

    //sends POST and returns new entity
    public static UserEntity createUser(){
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            String requestBody = "{\"id\":5,\"name\":\"Bjorn Ironside\",\"username\":\"ironside\",\"email\":\"ragnarsson@example.com\" \"address\":{\"street\" : \"Floridablanca\",\"suite\": \" 3 \", \"city\": \"Madrid\", \"zipcode\": \"30038\", \"geo\": { \"lat\":\"30.21\", \"lng\": \"60.11\"}}}";

            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();
            if(responseCode == HttpURLConnection.HTTP_CREATED){
                return getUserEntity(connection);
            }
            connection.disconnect();
        }
        catch (IOException e) {
            throw new RuntimeException("Something goes wrong");
        }
        return null;
    }

    public static UserEntity updateUser(int id){
        try{
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);
            // якщо додавати адресу то сервер повертає помилку 500
            //String requestBody = "{\"id\":5,\"name\":\"Bjorn Ironside\",\"username\":\"ironside\",\"email\":\"ragnarsson@example.com\" \"address\":{\"street\" : \"Floridablanca\",\"suite\": \" 3 \", \"city\": \"Madrid\", \"zipcode\": \"30038\", \"geo\": { \"lat\":\"30.21\", \"lng\": \"60.11\"}}}";
            String requestBody = "{\"id\":5,\"name\":\"Bjorn Ironside\",\"username\":\"ironside\",\"email\":\"ragnarsson@example.com\"}";
            try(OutputStream outputStream = connection.getOutputStream()){
                outputStream.write(requestBody.getBytes());
                outputStream.flush();
            }

            int responseCode = connection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK) return getUserEntity(connection);

            connection.disconnect();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static int deleteUser(int id) {
        try {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static List<UserEntity> getUsers() {
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    return gson.fromJson(response.toString(), userListType);
                }
            }
            connection.disconnect();
        }catch(IOException e ){
            e.printStackTrace();
        }
    return null;
    }
    public static Optional<UserEntity> getUserByUsername(String username) {
        try {
            URL url = new URL(BASE_URL + "?username=" + username);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (HttpURLConnection.HTTP_OK == responseCode) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    Type userListType = new TypeToken<List<UserEntity>>() {
                    }.getType();
                    List<UserEntity> users = gson.fromJson(response.toString(), userListType);
                    if (!users.isEmpty()) {
                        return Optional.of(users.get(0));
                    }
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    public static Optional<UserEntity> getUserById(int id) {
        try {
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    UserEntity user = gson.fromJson(response.toString(), UserEntity.class);
                    return Optional.ofNullable(user);
                }
            }

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }


   /* public static List<> getLastPostComments(){
        try{
            URL url = new URL(BASE_URL + "/" + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
        }catch(IOException e){
            e.printStackTrace();
        }
    }*/
    private static UserEntity getUserEntity(HttpURLConnection connection) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            line = reader.readLine();
            while (line != null) {
                response.append(line);
                line = reader.readLine();
            }
            return gson.fromJson(response.toString(), UserEntity.class);
        }
    }
}
