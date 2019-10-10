package com.stackoverflow.nullpointer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Objects {

    @Getter
    class Address {
        private String city;
        private String houseNumber;
    }

    @Getter
    @AllArgsConstructor
    public class Author {
        String lastName;
        int age;
    }

    @Getter
    @AllArgsConstructor
    public class Book {
        Author author;
    }

    @Getter
    @AllArgsConstructor
    public class CarShop {
        private String carName;
        private int cost;
        private Set<String> colors;
    }

    @Getter
    public class Employee extends Person {
        public Employee(String name) {
            super(name);
        }

        private int id;
        private int salary;
        private List<Employee> subordinates;
        Address address;
        Department department;
        String gender;
    }

    @Getter
    public class Department {
    }


    @Getter
    @Setter
    public class Person {
        String name;
        LocalDateTime date;
        boolean attend;
        int age;
        private List<String> languagesSpoken;
        List<Address> addresses;
        String address;

        public Person(String name) {
            this.name = name;
        }
    }

    @Getter
    @AllArgsConstructor
    public class EmployeeContract {
        private Long id;
        private Date date;
    }

    @Getter
    public class LineItem {
    }

    @Getter
    @AllArgsConstructor
    public class MyDTO {
        private int amount;
    }

    @Getter
    @AllArgsConstructor
    public class Node {
        int degree;
    }

    @Getter
    @AllArgsConstructor
    public class Order {
        String customerName;
        List<LineItem> lineItems;
    }

    @Getter
    class Permission {
        String label;
    }

    @Getter
    public class ProductCatalogue {
        private Integer pId;
        private Integer cId;
    }

    @Getter
    public static class Rider {
        private long rideTime;
        private Type type;

        public enum Type {
            EXPERIENCED;
        }
    }

    @Getter
    public class Stake {
        int customerId;
        int betOfferId;
        int stake;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Student {
        private String name;
        private int age;
        private Country country;
        private int score;
        List<Subject> subjects;

        public Student() {
        }

        public Student(String name, int age, Country country, int score) {
            this.name = name;
            this.age = age;
            this.country = country;
            this.score = score;
        }

        public Student(int score, String name, int age) {
            this.name = name;
            this.age = age;
            this.score = score;
        }

        public enum Country {POLAND, UK, GERMANY}
    }

    @Getter
    @Setter
    public class Subject {
        String name;
        Integer marks;
        boolean optional;
    }

    @Getter
    public class XYZProfile {
        private String name;
        private Integer code;

        public XYZProfile(String name, Integer code) {
            this.name = name;
            this.code = code;
        }
    }

    @Getter
    @AllArgsConstructor
    public class User {
        private String name;
        private String id;
        private String email;
        private List<Integer> lists;
        int age;

        public User(String email, List<Integer> lists) {
            this.email = email;
            this.lists = lists;
        }

        public User(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    @Getter
    public class Unicorn {
        private List<Rider> riders;
    }
}