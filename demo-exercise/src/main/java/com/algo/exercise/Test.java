package com.algo.exercise;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Integer [] arr = {1, 2, 3, 4, 5};
        Integer integer = Arrays.asList(arr).stream()
                .reduce((a, b) -> a * b)
                .orElse(0);
        System.out.println("Final output: " + integer);
    }
}

class Parent {
    public static void foo () {
        System.out.println("I'm foo in Supper");
    }

    public void bar () {
        System.out.println("I'm bar in Supper");
    }
}


class Child extends Parent {
    public static void foo () {
        System.out.println("I'm foo in Child");
    }

    public void bar () {
        System.out.println("I'm bar in Child");
    }

    public static void main(String[] args) {
        Parent parent = new Child();
        Child  child = new Child();

        parent.foo();
        parent.bar();

        child.foo();
        child.bar();
    }
}

class Employee /*implements Comparable<Employee>*/ {
    private String name;
    private String city;
    private Integer age;

    public Employee(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /*@Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }*/
}


class MultipleSort {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Sam", "Sydne", 25);
        Employee employee2 = new Employee("Adam", "Adilade", 30);
        Employee employee3 = new Employee("Tom", "Melbone", 21);
        Employee employee4 = new Employee("Serena", "Pert", 25);
        Employee employee5 = new Employee("Adam", "Adilade", 20);

        List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4, employee5);

        //Sort by name
        System.out.println("Sort by Name");
        list.sort(Comparator.comparing(Employee::getName));
        list.forEach(System.out::println);

        System.out.println("Sort by Age");
        list.sort(Comparator.comparing(Employee::getAge));
        list.forEach(System.out::println);

        System.out.println("Sort by Name and Age");
        list.sort(Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
        list.forEach(System.out::println);

        List<String> list1 = list.stream()
                .map(Employee::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        list1.forEach(System.out::println);

        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));

        collect.forEach((s, aLong) -> {
            System.out.println("Key :- " + s + " Value :- " + aLong);
        });


        Map<Employee, Long> collect1 = list.stream()
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

        collect1.forEach((s, aLong) -> {
            System.out.println("Key :- " + s + " Value :- " + aLong);
        });

        Map<Employee, Long> collect3 = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        collect3.forEach((s, aLong) -> {
            System.out.println("Key :- " + s + " Value :- " + aLong);
        });

        Map<Boolean, List<Employee>> collect4 = list.stream()
                .collect(Collectors.partitioningBy(t -> t.getAge() > 25));

        collect4.forEach((s, aLong) -> {
            System.out.println("Key :- " + s + " Value :- " + aLong);
        });

        List<Employee> collect5 = collect4.entrySet()
                .stream()
                .filter(t -> t.getKey() == true)
                .map(Map.Entry::getValue)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        Map<Boolean, Long> collect6 = list.stream()
                .collect(Collectors.partitioningBy(t -> t.getAge() > 25, Collectors.counting()));
        collect6.forEach((s, aLong) -> {
            System.out.println("Key :- " + s + " Value :- " + aLong);
        });



    }
}
