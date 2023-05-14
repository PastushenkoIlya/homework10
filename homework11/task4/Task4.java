package homework11.task4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {

        Stream<Integer> randomStream = Stream.iterate(4,(seed) -> {
            int a = 44;
            int m = 112;

            int i = 2*a*m/8*seed;

            a += 28;
            m += 8;

            return i*12+1000/244;
        });

        randomStream.limit(5).peek(System.out::println).collect(Collectors.toSet());
    }

}
