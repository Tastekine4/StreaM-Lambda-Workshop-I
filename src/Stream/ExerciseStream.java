package Stream;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciseStream {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        //1. Write a Java program to calculate the average of a list of integers using streams.
        double avg =
                list.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

        System.out.println("avg: " + avg);

        // 2.Write a Java program to convert a list of strings to uppercase or lowercase using streams.

        List<String> strList = Arrays.asList("my", "nAme", "iS", "erhAn");

        List<String> strUpperCaseList = strList.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(strUpperCaseList);

        // return type and method name like String :: toLowerCase
        List<String> strLowerCaseList = strList.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(strLowerCaseList);

        //3. Write a Java program to calculate the sum of all even, odd numbers in a list using streams.
        List<Integer> values = Arrays.asList(1, 3, 4, 5, 8, 9, 11, 17, 18);

        int res1 = values.stream().filter(n -> n % 2 == 0).reduce(0, (c, e) -> c + e);
        System.out.println(res1);
        int res2 = values.stream().filter(n -> n % 2 == 1).reduce(0, (c, e) -> c + e);
        System.out.println(res2);
        // one different way to do this.
        int sumOfOdds = values.stream()
                .filter(num -> num % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sumOfOdds);

        // 4. Write a Java program to remove all duplicate elements from a list using streams.

        List<Integer> myList = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7, 8, 8, 9, 9, 9, 9, 10, 10);

        // we can use like that with distinct keyword and collect as a list or
        List<Integer> distinctNumbers = myList.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNumbers);
        // we can use like that as a set to prevent duplication
        Set<Integer> uniqList = myList.stream().collect(Collectors.toSet());
        System.out.println(uniqList);

        //5.Write a Java program to count the number of strings in a list that start with a specific letter using streams.

        List<String> nameList = Arrays.asList("Alex", "Andrew", "Amsterdam", "Berlin", "James", "Box", "X", "Dev");
        long count = nameList.stream()
                .filter(n -> n.startsWith("A")).count();
        System.out.println("Count the List which starts with 'A': " + count);

        //6. Write a Java program to sort a list of strings in alphabetical order, ascending and descending using streams.
        List<String> ascendingOrder = nameList.stream().sorted()
                .collect(Collectors.toList());
        System.out.println(ascendingOrder);

        List<String> descendingOrder = nameList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(descendingOrder);

    // 7. Write a Java program to find the maximum and minimum values in a list of integers using streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 5, 6, 6, 6, 6, 7, 8, 8, 9, 9, 9, 9, 10, 10);

        int maxValue = numbers.stream().max(Integer::compare).orElse(null);
        System.out.println(maxValue);
        int minValue = numbers.stream().min(Integer:: compare).orElse(null);
        System.out.println(minValue);

        Integer secondSmallest = numbers.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondSmallest);
        
        // Find the second largest element
        Integer secondLargest = numbers.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println(secondLargest);
    }

}
