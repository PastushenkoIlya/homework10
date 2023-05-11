package homework10.task3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("C:\\Users\\777\\IdeaProjects\\goit\\src\\main\\java\\homework10\\task3\\words.txt")){
            //creating a string that contains all the text
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            //creating a list of unique words
            String text = new String(buffer).trim();
            String[] wordsArr = text.split("\\W+");
            List<String> words = new ArrayList<String>();
            for(String word : wordsArr){
                if(!words.contains(word)) words.add(word);
            }
            //calculating a number of matcher in the text for every word
            int[] freqCount = new int[words.size()];
            for(int freqCounter : freqCount){
                freqCounter = 0;
            }
            int numberOfWord = 0;
            for(String word : words){
                for(String line : wordsArr){
                    if(line.equals(word)) freqCount[numberOfWord]++;
                }
                numberOfWord++;
            }
            for(int i=0;i<words.size();i++){
                System.out.println(words.get(i)+" "+freqCount[i]);
            }

        } catch ( IOException e) {
            System.out.println("File not found!");
        }


    }

}
/*
1) загрузити все в байтовий буфер, перетворити у строку
2) зробити список слів з строки
3)для кожного слова у списку перевірити кількість збігів у тексті та зберегти результат
4)вивести все


 */