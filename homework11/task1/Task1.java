package homework11.task1;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        List<String> names = List.of("Inna", "Oled", "John", "Hope", "Igor", "Vlad");
//        AtomicInteger counter = new AtomicInteger(1);
//        long count =  names.stream().count();
//        names.stream().forEach(name -> {
//            if(counter.getAndIncrement() % 2 != 0){
//                System.out.print(counter.get()-1+". "+name);
//                if(counter.get() != count) System.out.print(", ");
//            }
//
//        });
        AtomicInteger counter = new AtomicInteger(1);
        String res = names.stream().map((name) -> {

            return String.valueOf(counter.getAndIncrement())+". "+name;
        }).filter(name -> Character.codePointAt(name, 0) % 2 != 0).collect(Collectors.joining(", "));
        System.out.println(res);

    }
}
