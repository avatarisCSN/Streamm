package goit;



import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task12 {
    public static void main(String[] args) {
        List<String> list1 = List.of("Ethan","Lucas","Mason","Jack","Aiden","Emma","Ava","Luna","Aria","Ivy");
        List<String> list2 = List.of("1.Ethan","2.Lucas","3.Mason","4.Jack","5.Aiden","6.Emma","7.Ava","8.Luna","9.Aria","10.Ivy");


        String result = IntStream.range(0, list1.size())
                .filter(i -> i % 2 == 0) // только нечётные элементы (по индексу)
                .mapToObj(i -> ((i + 1) + ". " + list1.get(i))) // индекс в списке: 1, 2, 3...
                .collect(Collectors.joining(" ")); // склеиваем в строку

        System.out.println(result); //вывод результата

        //task2
        list1.stream()
                .map(s->s.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }

}
