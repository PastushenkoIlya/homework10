package homework11.task4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        RandomAlg randomAlg = new RandomAlg(100,20);
        Stream<Integer> randomStream = Stream.iterate(4,(seed) -> randomAlg.c(seed).next());

        randomStream.limit(10).peek(System.out::println).collect(Collectors.toSet());
    }

}
