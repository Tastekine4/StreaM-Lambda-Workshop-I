package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionMain {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(4, 5, 6, 7, 8, 9);

        Function<Integer, Integer> func = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                return n * 2;
            }
        };
        // how it works behind
        values.stream()
                .filter(n -> n % 2 == 0)
                .map(func)
                .reduce(0, (c, e) -> c + e);

        // short way to do it.
        values.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, (c, e) -> c + e);
    }
}
