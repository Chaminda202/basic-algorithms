package com.algo.exercise.model;

public class User {
    private String name;
    private String city;
    private Integer age;
    private String country;

    public User() {
    }

    public User(String name, String city, Integer age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public User(String name, String city, Integer age, String country) {
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }
}
