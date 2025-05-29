package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Sorting1Stream {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "", "banana", "avocado", "", "cherry");

        String result = words.stream()
                .filter(s -> !s.isEmpty())
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.joining(", "));

        System.out.println(result);
        List<String> fruits = List.of("apple", "banana", "apricot", "avocado");

      /*  Map<Integer, String> result1 = fruits.stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.mapping(String::toUpperCase, Collectors.joining(", "))));
*/
        System.out.println(1);
// {5=APPLE, AVOCADO, 6=BANANA, APRICOT}
    }
}
