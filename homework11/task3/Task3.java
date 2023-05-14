package homework11.task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task3 {
    public static void main(String[] args) {
        String[] strArr = {"1, 2, 0", "4, 5"};
        List<Integer> numbers = new ArrayList<>();

//        for(String str : strArr){
//            numbers.addAll(Arrays.stream(str.split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList()));
//        }
//        System.out.println(numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
        String res = Arrays.stream(strArr)
                .flatMapToInt(str -> Arrays.stream(str.split(", ")).sorted().mapToInt(num -> Integer.parseInt(num)))
                .boxed().map(num -> String.valueOf(num)).collect(Collectors.joining(", "));
        System.out.println(res);

    }

}
