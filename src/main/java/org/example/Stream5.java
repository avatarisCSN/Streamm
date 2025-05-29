package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream5 {
    public static void main(String[] args) {
        Set<String> result = new TreeSet<>();
        try (Stream<String> stream1 = Files.lines(Paths.get("Cities"))) {
            result = stream1.sorted()

                    .map(s -> s.toLowerCase())
                    .distinct()
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            System.out.println("e " + e);
        }

        System.out.println(result);


        // новый кусок кода
        List<String> list1 = List.of("А й правда, крилатим ґрунту не треба.");
        List<String> list2 = List.of("Землі немає, то буде небо.");
        List<String> list3 = List.of("Немає поля, то буде воля.");
        List<String> list4 = List.of("Немає пари, то будуть хмари.");
        List<String> list5 = List.of("В цьому, напевно, правда пташина…");
        List<String> list6 = List.of("А як же людина? А що ж людина?");
        List<String> list7 = List.of("Живе на землі. Сама не літає.");
        List<String> list8 = List.of("А крила має. А крила має!");

        List<List> bigList1 = List.of(list1, list2, list3, list4);
        List<List> bigList2 = List.of(list5, list6, list7, list8);

        List<String> uniqueWords = Stream.of(bigList1, bigList2)
                .flatMap(Collection::stream)
                .flatMap(list -> Arrays.stream(list.get(0).toString().split(" ")))
                .collect(Collectors.toList());
        System.out.println(uniqueWords);


    }
}
