package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Stream6 {
    public static void main(String[] args) {
        List<Integer> list1 = List.of(10,52,48,96,587,63598,4521,-52,-418,-6598,-21504,5412,987605);
        System.out.println(list1.size());

        int count=0;
        for (int i:list1){
            if(i>0){
                count++;
            }
        }
        System.out.println(count);
        long number = list1.stream()
                .filter(integer -> integer>0)
                .count();
        System.out.println(number);
        // новый кусок кода
        boolean status =list1.stream()
                .anyMatch(s->s>1000000);
        boolean status1 =list1.stream()
                .anyMatch(s->s>100000);
        System.out.println("falseee "+status);
        System.out.println("trueee "+status1);
        // новый кусок кода
        String result = list1.stream()
                .map(String::valueOf) // преобразуем Integer -> String
                .collect(Collectors.joining(", "));
        System.out.println("result "+result);

    }
}
