package homework10.task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyObjectWriter {
    public void serializeObjects(List<User> list) throws IOException {
        //checking if there are objects in the list
        if (list.size() == 0 || list == null) return;
        //creating a file to write

        try {
            new File("C:\\Users\\777\\IdeaProjects\\goit\\src\\main\\java\\homework10\\task2\\fileResult.json").createNewFile();
        } catch (IOException e) {
            System.out.println("File hasn't been created correctly!");
        }
        File file = new File("C:\\Users\\777\\IdeaProjects\\goit\\src\\main\\java\\homework10\\task2\\fileResult.json");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String s;
        FileWriter writer = new FileWriter(file, true);
        for (User user : list) {
            s = gson.toJson(user);
            writer.write(s);
            writer.flush();
        }
        writer.close();
    }
}
