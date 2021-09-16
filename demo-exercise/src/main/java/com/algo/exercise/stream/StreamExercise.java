package com.algo.exercise.stream;

import com.algo.exercise.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExercise {
    public static void main(String[] args) {
        System.out.println("Find all user name from US");
        exercise1();
        System.out.println("Use <A> A[] toArray(IntFunction<A[]> generator) method");
        exercise2();
        System.out.println("Use Object[] toArray() method");
        exercise3();
        System.out.println("Obtains persons in each country and count using groupBy");
        exercise4();
        System.out.println("Obtains US and non US persons using groupingBy");
        exercise5();
        System.out.println("Obtains US and non US persons using partitionBy");
        exercise6();
        System.out.println("Obtains US and non US persons count using groupingBy and counting");
        exercise7();
        System.out.println("Obtains US and non US persons count using partitionBy and counting");
        exercise8();
        System.out.println("Obtains US and non US persons using groupingBy and map name to uppercase using mapping");
        exercise9();
        System.out.println("Obtains US and non US persons using partitionBy and map name to uppercase using mapping");
        exercise10();
        exercise12();
    }

    // Find all user name from US
    public static void exercise1() {
        UserData.getUserList().stream()
                .filter(u -> u.getCountry().equalsIgnoreCase("US"))
                .map(User::getName)
                .forEach(System.out::println);
    }

    // <A> A[] toArray(IntFunction<A[]> generator)
    public static void exercise2() {
        User[] users = UserData.getUserList().stream()
                .filter(u -> !u.getCountry().equalsIgnoreCase("US"))
                .toArray(User[]::new);

        Arrays.stream(users).forEach(System.out::println);
    }

    // Object[] toArray()
    public static void exercise3() {
        Object[] objects = UserData.getUserList().stream().toArray();
        Arrays.stream(objects)
                .filter(u -> u instanceof User)
                .map(u -> (User)u).forEach(System.out::println);
    }

    // Collectors.groupingBy
    public static void exercise4() {
        final Map<String, List<User>> collect = UserData.getUserList().stream()
                .collect(Collectors.groupingBy(User::getCountry));
        UserData.getUserList().stream()
                .collect(Collectors.groupingBy(User::getCountry, Collectors.counting()))
                .forEach((k, v) -> System.out.println("Country :- " + k + " count :- " + v));
    }

    // Collectors.groupingBy
    public static void exercise5() {
        UserData.getUserList().stream()
                .collect(Collectors.groupingBy(u -> u.getCountry().equalsIgnoreCase("US")))
                .forEach((k, v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US persons list using groupingBy method");
                    } else {
                        System.out.println("Non US persons list using groupingBy");
                    }
                    v.forEach(System.out::println);
                });
    }

    // Collectors.partitioningBy
    public static void exercise6() {
        UserData.getUserList().stream()
                .collect(Collectors.partitioningBy(u -> u.getCountry().equalsIgnoreCase("US")))
                .forEach((k, v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US persons list using partitioningBy");
                    } else {
                        System.out.println("Non US persons list using partitioningBy");
                    }
                    v.forEach(System.out::println);
                });
    }

    // Collectors.groupingBy and Collectors.counting
    public static void exercise7() {
        UserData.getUserList().stream()
                .collect(Collectors.groupingBy(u -> u.getCountry().equalsIgnoreCase("US"), Collectors.counting()))
                .forEach((k, v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US persons count :- " + v);
                    } else {
                        System.out.println("Non US persons count :- " + v);
                    }
                });
    }

    // Collectors.partitioningBy and Collectors.counting
    public static void exercise8() {
        UserData.getUserList().stream()
                .collect(Collectors.partitioningBy(u -> u.getCountry().equalsIgnoreCase("US"), Collectors.counting()))
                .forEach((k,v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US persons count :- " + v);
                    } else {
                        System.out.println("Non US persons count :- " + v);
                    }
                });
    }

    // Collectors.groupingBy and Collectors.mapping
    public static void exercise9() {
        UserData.getUserList().stream()
                .collect(Collectors.groupingBy(u -> u.getCountry().equalsIgnoreCase("US"),
                        Collectors.mapping(StreamExercise::apply,
                                Collectors.toList())))
                .forEach((k,v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US persons list");
                    } else {
                        System.out.println("Non US persons list");
                    }
                    v.forEach(System.out::println);
                });
    }

    // Collectors.partitioningBy and Collectors.mapping
    public static void exercise10() {
        UserData.getUserList().stream()
                .collect(Collectors.partitioningBy(u -> u.getCountry().equalsIgnoreCase("US"),
                        Collectors.mapping(StreamExercise::apply, Collectors.toList())))
                .forEach((k, v) -> {
                    if (Boolean.TRUE.equals(k)) {
                        System.out.println("US person list and map name to upper case using partitionBy and mapping");
                    } else {
                        System.out.println("Non US person list and map name to upper case using partitionBy and mapping");
                    }
                    v.forEach(System.out::println);
                });
    }

    // Collectors.groupingBy
    public static void exercise11() {
        Map<Boolean, List<User>> map = UserData.getUserList().stream()
                .collect(Collectors.groupingBy(u -> u.getCountry().equalsIgnoreCase("US") && u.getAge() == 25));
        System.out.println(map);
    }


    public static void exercise12() {
        Function<User, List<Object>> compositeKey = personRecord ->
                Arrays.<Object>asList(personRecord.getName(), personRecord.getAge());

        Map<Object, List<User>> map =
                UserData.getUserList().stream().collect(Collectors.groupingBy(compositeKey, Collectors.toList()));

        System.out.println(map);
    }

    private static User apply(User u) {
        u.setName(u.getName().toUpperCase());
        return u;
    }
}
