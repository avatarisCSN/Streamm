package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream3 {
    public static void main(String[] args) {
        try(Stream<String> stream = Files.lines(Paths.get("Cities"))){
            stream
                    .filter(s -> s.length()>6)
                    .map(s -> s.toUpperCase())
                    .forEach(s -> System.out.println(s));
        }
            catch(IOException e){
                System.out.println(e);
            }
        // новый кусок кода

        long count=0;
        try(Stream<String> stream2 = Files.lines(Paths.get("Cities"))){
             count = stream2
                    .filter(s -> s.length()>6)
                    .count();

        }
        catch(IOException e){
            System.out.println(e);
        }
        System.out.println(count+" count");

        // новый кусок кода

        Optional<String> result;

        try(Stream<String> stream3 = Files.lines(Paths.get("Cities"))){
            result = stream3
                    .reduce((x,y)->x.concat(" "+y));
        }
        catch(IOException e){
            System.out.println(e);
            result = Optional.empty();
        }

        String str = result.orElse("");
        System.out.println(str + " result");

    }
}
