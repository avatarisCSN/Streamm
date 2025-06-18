package goit;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        String[] mass = {"1, 2, 0", "4, 5"};
        Arrays.stream(mass)
                .map(s->s.split(","))
                .forEach(arr -> System.out.println(Arrays.toString(arr)));

        Arrays.stream(mass)
                .flatMap(s -> Arrays.stream(s.split(","))) // разбиваем и объединяем
                .map(String::trim) // убираем пробелы
                .sorted()
                .forEach(System.out::println); // печатаем результат
    }

}

