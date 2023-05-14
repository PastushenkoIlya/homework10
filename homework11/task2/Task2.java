package homework11.task2;

import java.util.List;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = List.of("Inna", "Oled", "John", "Hope", "Igor", "Vlad");
        List namesList = names.stream().map(String::toUpperCase).sorted((p1, p2) -> p2.compareTo(p1)).collect(Collectors.toList());
    }
}
