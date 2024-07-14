package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> values = Arrays.asList(4, 5, 6, 7, 8, 9);
        values.forEach(n -> System.out.println(n));

        Stream<Integer> data = values.stream();
        data.forEach(n -> System.out.println(n));
        /* for second call of stream is not allowed it is done once and closed after that!
        data.forEach(n -> System.out.println(n));
        data.count(); give us size of the stream list
        */

        // we create 4 stream object here for (stream, filter, sorted, map)
        values.stream()
                .filter(n -> n % 2 == 1)
                .sorted()
                .map(n -> n * 2)
                .forEach(n -> System.out.println(n));

        values.parallelStream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n).forEach(n -> System.out.println(n));

        List<Integer> square
                = values.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());
        System.out.println(square);
    }
}