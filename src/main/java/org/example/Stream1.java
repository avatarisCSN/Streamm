package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) {
        List<String> list1 =new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("Cities"))){
            String c;
            while((c=reader.readLine())!=null){
                list1.add(c);
            }
        }
            catch(IOException e){
            System.out.println("exception e");
        }
        for(String str:list1){
            if(str.length()>7){
                System.out.println(str);
            }
        }
          list1.stream()
                  .filter(s -> s.length()>7)
        .forEach(s -> System.out.println(s));

    }
}
