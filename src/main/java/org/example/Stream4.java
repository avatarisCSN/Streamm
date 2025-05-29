package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream4 {
    public static void main(String[] args) {
        Optional<String> result;

        try (Stream<String> stream1 = Files.lines(Paths.get("Cities"))){

            result = stream1.reduce((x,y)->x.concat(" "+y));

        }
        catch(IOException e){
            System.out.println(e+" e");
            result = Optional.empty();
        }
        String str = result.orElse("");
        System.out.println("str "+str);

        // новый кусок кода

        try(Stream<String> stream2 = Files.lines(Paths.get("Cities"))){
            stream2
                    .sorted(Comparator.reverseOrder())
                    .forEach(s -> System.out.println(s));

        }catch(IOException e){
            System.out.println("e "+e);
        }
        // новый кусок кода
        try(Stream<String> stream3 = Files.lines(Paths.get("Cities"))){
            stream3
                    .sorted(Comparator.reverseOrder())
                    .distinct()
                    .forEach(s -> System.out.println(s));

        }catch(IOException e){
            System.out.println("e "+e);
        }
    }




}
