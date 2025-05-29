package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream10 {

    public static void main(String[] args) {
        List<String> stopWords=List.of("небо", "землі", "людина", "пташина");
        try(Stream<String> stream1 = Files.lines(Paths.get("LINES"))) {


            Map<String,Long> map1= stream1
                    .flatMap(s-> Arrays.stream(s.split("[^а-яА-ЯёЁ]+")))
                    .map(s->s.toLowerCase())
                    .filter(s->!stopWords.contains(s))
                    .collect(Collectors.groupingBy(Function.identity(),
                            Collectors.counting()))
                    .entrySet().stream()
                    .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                    .limit(10)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue,
                            (a, b) -> a,
                            LinkedHashMap::new // чтобы сохранить порядок

                    ));
            System.out.println(map1);
        }catch(IOException e){
            System.out.println(e+" exception");
        }

    }
    List<String> list1 = List.of("А й правда, крилатим ґрунту не треба.");
    List<String> list2 = List.of("Землі немає, то буде небо.");
    List<String> list3 = List.of("Немає поля, то буде воля.");
    List<String> list4 = List.of("Немає пари, то будуть хмари.");
    List<String> list5 = List.of("В цьому, напевно, правда пташина…");
    List<String> list6 = List.of("А як же людина? А що ж людина?");
    List<String> list7 = List.of("Живе на землі. Сама не літає.");
    List<String> list8 = List.of("А крила має. А крила має!");
}
