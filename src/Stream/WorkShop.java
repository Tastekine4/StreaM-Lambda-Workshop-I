package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WorkShop {
    public static void main(String[] args) {
        // Different ways to create a stream:

        // From Collection
        List<Integer> salaryList = Arrays.asList(3000, 4000, 8000, 17000);
        Stream<Integer> streamFromIntegerList = salaryList.stream();

        // From Array
        Integer[] salaryArr = {3000, 4000, 8000, 17000};
        Stream<Integer> streamFromIntegerArray = Arrays.stream(salaryArr);

        // From static Method

        Stream<Integer> streamFromStaticMeth = Stream.of(3000, 4000, 8000, 17000);

        /**********************************************/

        // mapToInt helps to work with primitive "int" data types
        List<String> numbers = Arrays.asList("2", "1", "4", "7");
        IntStream numberStream = numbers.stream().mapToInt(n -> Integer.parseInt(n));
        int[] numberArr = numberStream.toArray();
        System.out.println(Arrays.toString(numberArr));
        // output 2,1,4,7

        int[] numbersArr = {2, 1, 4, 7};
        IntStream numbersStream = Arrays.stream(numbersArr);

        int[] filteredArr = numbersStream.filter(n -> n > 2).toArray();
        System.out.println(Arrays.toString(filteredArr));

        // same for mapToLong and mapToDouble


        // Why we call Intermediate operation "Lazy"
        // Streams code execute when the streams invoked
/*        List<Integer> numbList = Arrays.asList(2, 1, 4, 7, 11);
        Stream<Integer> numbStream = numbList.stream().filter(n -> n >= 3)
                .peek(n -> System.out.println(n));

                This code does not print anything while we call numbStream !!!
*/
        List<Integer> numbList = Arrays.asList(2, 1, 4, 7, 11);
        Stream<Integer> numbStream = numbList.stream().filter(n -> n >= 3)
                .peek(n -> System.out.println(n));
        numbStream.count(); // now we can execute stream (when we call it) !
        // output will be 4 , 7 , 11

        /****************************************************************/

        // toArray  collects the elements of the stream into an Array

        Object[] filteredNumbArrType1 = numbList.stream().filter(n -> n >=3).toArray();

        // for creating array with spesific type we need to change code like this:

        Integer[] filteredNumbArrType2 =  numbList.stream()
                .filter(n -> n >=3)
                .toArray((int size) -> new Integer[size]);

        /****************************************/
        // anyMatch(Predicate<T> predicate) check if any value match with predicate return true
        boolean flag = numbList.stream().anyMatch(n -> n >=3);
        System.out.println(flag);
        // allMatch(Predicate<T> predicate) , noneMatch(Predicate<T> predicate) same as above

        /****************************************/

        // findFirst first one with optional and second set default value with orElse example

        Optional<Integer> firstVal = numbList.stream().filter(n -> n >= 3).findFirst();

        System.out.println(firstVal.get());

        Integer firstValue = numbList.stream().filter(n -> n >= 3).findFirst().orElse(0);

        System.out.println(firstValue);

    }
}
