package com.algo.exercise.stream;

import com.algo.exercise.model.User;

import java.util.Arrays;
import java.util.List;

public class UserData {
    private UserData () {
    }

    public static List<User> getUserList() {
        User user1 = new User("Sam", "Sydney", 25, "Australia");
        User user2 = new User("Adam", "Adelaide", 30, "Australia");
        User user3 = new User("Tom", "Melbourne", 21, "Australia");
        User user4 = new User("Serena", "Pert", 27, "Australia");
        User user5 = new User("James", "Adelaide", 20, "Australia");
        User user6 = new User("Tony", "New York", 18, "US");
        User user7 = new User("Alex", "Los Angeles", 32, "US");
        User user8 = new User("Micheal", "Adelaide", 19, "US");
        User user9 = new User("Taylor", "Auckland", 36, "New Zealand");
        User user10 = new User("Tim", "Wellington", 16, "New Zealand");
        User user11 = new User("Jessi", "Toronto", 31, "Canada");
        User user12 = new User("Steve", "Montreal", 17, "Canada");
        User user13 = new User("Tim", "Sydney", 25, "Australia");

        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11, user12, user13);
        return list;
    }
}
