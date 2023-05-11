package homework10.task1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
public class Task1 {
    public static void main(String[] args) {


        try(Scanner scanner = new Scanner(new File("C://Users//777//IdeaProjects//goit//src//main//java//homework10//task1//file"))){
            Pattern pattern = Pattern.compile("^\\d{3}|\\(\\d{3}\\)-\\d{3}-\\d{4}");
            Matcher matcher;
            boolean matchFound;
            String line;
            while(scanner.hasNextLine()){
                line = scanner.nextLine();
                matcher = pattern.matcher(line);
                matchFound = matcher.find();
                if(matchFound){
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

