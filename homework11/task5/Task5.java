package homework11.task5;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task5 {


    public static void main(String[] args) {
        Stream<String> names = Stream.of("Ivan", "Olaf", "Galga", "Dot", "Jan", "Clod");
        Stream<String> indexes = Stream.of("1", "2", "3", "4");

        zip(names,indexes).peek(System.out::println).collect(Collectors.toSet());
    }
    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        List<T> res = new LinkedList<>();

        Iterator<T> iterA = first.iterator();
        Iterator<T> iterB = second.iterator();

        while(iterA.hasNext() && iterB.hasNext()){
            res.add(iterA.next());
            res.add(iterB.next());
        }
        return res.stream();
    }
}
