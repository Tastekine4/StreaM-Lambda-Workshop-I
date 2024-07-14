package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateMain<I extends Number> {

    public static void main(String[] args) {
        Predicate<Integer> p = new Predicate<Integer>() {
            public boolean test(Integer n) {
                return n % 2 == 0;
            }
        };
        List<Integer> values = Arrays.asList(4, 5, 6, 7, 8, 9);

        values.stream()
                .filter(p)  // this is long way of doing this
                .map(n -> n * 2)
                .reduce(0, (c,e)-> c+e);

        values.stream()
                .filter(n -> n % 2 == 0)  // this is a short way with lambda exp.
                .map(n -> n * 2)
                .reduce(0, (c,e)-> c+e);

    }

}
