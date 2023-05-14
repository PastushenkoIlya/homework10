package homework13;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String getUrl = "https://jsonplaceholder.typicode.com/users";
        int id = 6;
        String userName = "Leopoldo_Corkery";
        Task1Part2 requestSender = new Task1Part2();
        try {
            requestSender.getInfoUsers(getUrl);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            requestSender.getInfoUserById(getUrl, id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            requestSender.getInfoUserByUserName(getUrl, userName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
