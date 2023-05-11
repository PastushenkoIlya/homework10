package homework10.task2;

import java.io.IOException;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        MyObjectReader reader = new MyObjectReader();
        MyObjectWriter writer = new MyObjectWriter();
        List<User> list = reader.deserializeObjects("C:\\Users\\777\\IdeaProjects\\goit\\src\\main\\java\\homework10\\task2\\file2.txt.txt");
        /*for( User user : list){
            System.out.println(user.toString());
        }*/
        try {
            writer.serializeObjects(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
