package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream8 {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product("iPhone 13", "Electronics", 999.99),
                new Product("MacBook Pro", "Electronics", 1999.99),
                new Product("Bananas", "Groceries", 1.49),
                new Product("Shampoo", "Personal Care", 5.99),
                new Product("Notebook", "Stationery", 2.49),
                new Product("TV Samsung", "Electronics", 499.99),
                new Product("Apples", "Groceries", 1.99),
                new Product("Toothpaste", "Personal Care", 3.99)
        );
        List<Product> list2= products.stream()
                .filter(s->s.category.equals("Electronics"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(
                                Product::getName,          // ключ — имя
                                Function.identity(),       // значение — сам продукт
                                (existing, replacement) -> existing // если дубликат — оставить первый
                        ),
                        map -> new ArrayList<>(map.values())
                ));

        double avgPrice = products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .collect(Collectors.collectingAndThen(
                        Collectors.toMap(Product::getName, Function.identity(), (p1, p2) -> p1),
                        map -> map.values().stream()
                                .mapToDouble(Product::getPrice)
                                .average()
                                .orElse(0)
                ));

        avgPrice = Math.round(avgPrice * 100.0) / 100.0;
        System.out.println(avgPrice);


    }
    static class Product {
        String name;
        String category;
        double price;

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }

        public Product(String name,String category, double price ) {
            this.name = name;
            this.category = category;
            this.price = price;
        }
    }
}
