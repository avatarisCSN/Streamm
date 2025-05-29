package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream7 {


    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 30, "IT", 120000),
                new Employee("Bob", 24, "HR", 70000),
                new Employee("Charlie", 28, "IT", 95000),
                new Employee("Diana", 35, "Finance", 130000),
                new Employee("Eve", 27, "IT", 105000),
                new Employee("Frank", 23, "Marketing", 60000),
                new Employee("Grace", 32, "IT", 110000),
                new Employee("Hank", 29, "HR", 72000)
        );
        Comparator<Employee> bySalaryDesc1= (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary());
        Comparator<Employee> bySalaryDesc2 = Comparator.comparing(Employee::getSalary).reversed();
        List<Employee> employees1 = List.of(
            new Employee("rerere",10,"151515",44)
        );
        List<String> list2 = employees.stream()
                .filter(s->s.getAge()>25)
                .filter(s->s.getDepartment().equals("IT"))
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .limit(3)
                .map(s->s.getName())
                .collect(Collectors.toList());
        System.out.println(list2);

    }

   static class Employee {
        String name;
        int age;
        String department;
        double salary;

        public Employee(String name, int age, String department, double salary) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }
        // Геттеры
        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        // toString для вывода
        @Override
        public String toString() {
            return name + " (" + department + ", age " + age + ", $" + salary + ")";
        }
    }
}
