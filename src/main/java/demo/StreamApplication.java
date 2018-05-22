package demo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApplication {
    public static void main(String args[]) {
        List<String> collection = Arrays.asList("a1", "b2", "a2", "c2", "b1", "c1", "c3");
        // Java 8 enables you to pass references of methods or constructors via the :: keyword. 
        collection.forEach(System.out::print);
        System.out.println();
        // Filter
        collection.stream().filter( (s) -> s.startsWith("a") ).forEach(System.out::print);
        System.out.println();
        // Sorted
        collection.stream().sorted().forEach(System.out::print);
        System.out.println();
        // Map
        collection.stream().map(String::toUpperCase).forEach(System.out::print);
        System.out.println();
        // Match
        boolean allMatch = collection.stream().allMatch( (s) -> s.startsWith("a") );
        System.out.println(allMatch);
        // Count
        long count = collection.stream().count();
        System.out.println(count);
        // Reduce
        Optional<String> reduced = collection
            .stream()
            .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // Collect
        List<String> sortedCollection = collection.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedCollection);
    }

}