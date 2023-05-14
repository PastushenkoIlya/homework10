package homework13;

import org.jsoup.Jsoup;

import java.io.IOException;

public class Task1Part2 {
    //test

    public void getInfoUsers(String url) throws IOException {
        String response = Jsoup
                .connect(url)
                .ignoreContentType(true)
                .execute()
                .body();
        System.out.println(response);
    }
    public void getInfoUserById(String url, int id) throws IOException {
        String completeUrl = url +"/"+ String.valueOf(id);
        String response = Jsoup
                .connect(completeUrl)
                .ignoreContentType(true)
                .execute()
                .body();
        System.out.println(response);
    }
    //https://jsonplaceholder.typicode.com/users?username={username}
    public void getInfoUserByUserName(String url, String userName) throws IOException {
        String completeUrl = url+"?username="+userName;
        String response = Jsoup
                .connect(completeUrl)
                .ignoreContentType(true)
                .execute()
                .body();
        System.out.println(response);
    }
}
