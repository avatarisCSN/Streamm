package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sorting1 {
    public static void main(String[] args) {
        List<String> words = List.of("apple", "", "banana", "avocado", "", "cherry");
        List<String> sorted = new ArrayList<>();
        for(String word:words){
            if(!word.isEmpty()){
                word = word.toUpperCase();
                sorted.add(word);
            }
        }
        sorted.sort(String::compareTo);
        StringBuilder result = new StringBuilder();
                for(String word:sorted){
                    result.append(word);
                    result.append(", ");
                }
        System.out.println(result.toString());
    }
}
