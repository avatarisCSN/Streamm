package goit;

import java.util.stream.Stream;

public class Task4 {
    public static void main(String[] args) {
        long a = 25214903917L;
        long c = 11;
        long m = 1L << 48; // 2^48
        long seed = 42;

        Stream.iterate(seed, x -> (a * x + c) % m)
                .limit(10)
                .forEach(System.out::println);
    }
}
