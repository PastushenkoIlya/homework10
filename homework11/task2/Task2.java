package homework11.task2;

import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> names = List.of("Inna", "Oled", "John", "Hope", "Igor", "Vlad");
        names.stream().map(String::toUpperCase).sorted((p1, p2) -> p2.compareTo(p1)).forEach(s -> System.out.println(s));
    }
}
