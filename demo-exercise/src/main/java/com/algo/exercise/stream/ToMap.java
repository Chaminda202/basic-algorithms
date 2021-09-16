package com.algo.exercise.stream;

import com.algo.exercise.model.User;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ToMap {
    public static void main(String[] args) {
        exercise1();
        exercise2();
    }

    public static void exercise1() {
        UserData.getUserList().stream()
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.toMap(User::getName, Function.identity()))
                .forEach((k, v) -> {
                    System.out.println("User name :- " + k + " user details :- " +v);
                });
    }

    public static void exercise2() {
        UserData.getUserList().stream()
                .filter(u -> u.getAge() > 30)
                .collect(Collectors.toMap(User::getName, u -> {
                    if (u.getCountry().equalsIgnoreCase("US")) {
                        return u.getCity();
                    }else {
                        return u.getCountry();
                    }
                }))
                .forEach((k,v) -> System.out.println("User name :- " + k + " Country or City :- " + v));
    }

    public Map<Integer, User> listToMapWithDupKey(List<User> users) {
        return users.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (existing, replacement) -> existing));
    }

    public Map<Integer, User> listToConcurrentMap(List<User> users) {
        return users.stream().collect(Collectors.toMap(User::getAge, Function.identity(), (o1, o2) -> o1, ConcurrentHashMap::new));
    }

    public TreeMap<String, User> listToSortedMap(List<User> users) {
        return users.stream()
                .collect(Collectors.toMap(User::getName, Function.identity(), (o1, o2) -> o1, TreeMap::new));
    }
}
