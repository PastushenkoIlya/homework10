package homework10.task2;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class MyObjectReader {
    public int doSmth(){
        return -1;
    }
    public List<User> deserializeObjects(String filePath) {
        List list = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            String[] param = line.split(" ");
            if (param[0].equals("name") && param[1].equals("age")) {
                line = reader.readLine();
                list = new LinkedList<User>();
                while (line != null) {
                    param = line.split(" ");
                    list.add(new User(param[0], Integer.parseInt(param[1])));
                    line = reader.readLine();
                }
            } else return list;

        } catch (IOException e) {
            System.out.println("Exception");
        }
        return list;
    }
}