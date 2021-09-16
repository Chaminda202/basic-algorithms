package com.algo.exercise.future;

import com.algo.exercise.model.User;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        User user1 = new User("Sam", "Sydne", 25);
        User user2 = new User("Adam", "Adilade", 30);
        User user3 = new User("Tom", "Melbone", 21);
        User user4 = new User("Serena", "Pert", 25);
        User user5 = new User("Adam", "Adilade", 20);


        List<User> list = Arrays.asList(user1, user2, user3, user4, user5);
        CompletableFuture<List<String>> future1 = processAge(list, 21);
        CompletableFuture<List<String>> future2 = processName(list, "Sam");
        CompletableFuture<List<String>> future3 = processCity(list, "Adilade");

        List<List<String>> response = new ArrayList<>();
        response.add(future1.get());
        response.add(future2.get());
        response.add(future3.get());

        response.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    @Async
    private static CompletableFuture<List<String>> processAge(List<User> userList, Integer age) throws InterruptedException {
        Thread.sleep(2500);
        System.out.println("Call process age function()");
        List<String> collect = userList.stream()
                .filter(u -> u.getAge() > age)
                .map(User::getName)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(collect);
    }

    @Async
    private static CompletableFuture<List<String>> processName(List<User> userList, String name) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Call process name function()");
        List<String> collect = userList.stream()
                .filter(u -> u.getName().equals(name))
                .map(User::getName)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(collect);
    }

    @Async
    private static CompletableFuture<List<String>> processCity(List<User> userList, String city) throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("Call process city function()");
        List<String> collect = userList.stream()
                .filter(u -> u.getCity().equals(city))
                .map(User::getName)
                .collect(Collectors.toList());
        return CompletableFuture.completedFuture(collect);
    }
}
