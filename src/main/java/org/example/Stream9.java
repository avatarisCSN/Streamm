package org.example;

import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream9 {
    public static void main(String[] args) {
        int currentYear = Year.now().getValue();
        List<Order> orders =List.of(
                new Order("Alice", LocalDate.of(2025, 5, 1), 250.75),
                new Order("Bob", LocalDate.of(2024, 5, 3), 120.00),
                new Order("Charlie", LocalDate.of(2025, 4, 30), 560.40),
                new Order("Alice", LocalDate.of(2025, 5, 5), 310.00),
                new Order("David", LocalDate.of(2024, 5, 2), 75.20)
        );
        List<Order> orders1 = Arrays.asList(
        );
        Map<String, Double> topCustomers = orders.stream()
                .filter(o -> o.getDate().getYear() == currentYear)
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.summingDouble(Order::getAmount)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
        System.out.println(topCustomers);


    }
    static class Order {
        String customerName;
        LocalDate date;
        double amount;

        public Order(String customerName, LocalDate date, double amount) {
            this.customerName = customerName;
            this.date = date;
            this.amount = amount;
        }

        public String getCustomerName() {
            return customerName;
        }

        public LocalDate getDate() {
            return date;
        }

        public double getAmount() {
            return amount;
        }
    }
}
