package homework11.task4;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {

        Stream<Long> randomStream = Stream.iterate(4l,(seed) -> {
            long a = 25214903917l;
            long m = 2^48l;
            long c = 11l;
            return (a*seed+c)%m;
        });

        randomStream.limit(5).peek(System.out::println).collect(Collectors.toSet());
    }

}
