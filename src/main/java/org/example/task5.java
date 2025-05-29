package org.example;

import java.util.Map;
import java.util.stream.Stream;


import java.util.Iterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

    public class task5 {

            public static void main(String[] args) {
                Stream<String> stream1 = Stream.of("A", "B", "C");
                Stream<String> stream2 = Stream.of("1", "2", "3", "4");

                Stream<Map.Entry<String,String>> zipped = zip(stream1, stream2);
                zipped.forEach(pair->
                    System.out.println(pair.getKey() + " " + pair.getValue())); // Вывод: A1B2C3
            }



        public static <T, U> Stream<Map.Entry<T, U>> zip(Stream<T> first, Stream<U> second) {

            //стримы в итераторы
            Iterator<T> iterator1 = first.iterator();
            Iterator<U> iterator2 = second.iterator();

            // общий итератор
            Iterator<Map.Entry<T, U>> zippedIterator = new Iterator<>() {
                @Override
                public boolean hasNext() {
                    return iterator1.hasNext() && iterator2.hasNext();
                }

                @Override
                public Map.Entry<T, U> next() {
                    return Map.entry(iterator1.next(), iterator2.next());
                }
            };



            // Преобразуем итератор в стрим
            return StreamSupport.stream(
                    Spliterators.spliteratorUnknownSize(zippedIterator, 0),
                    false
            );
        }
    }