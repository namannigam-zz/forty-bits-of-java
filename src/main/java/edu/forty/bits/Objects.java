package edu.forty.bits;

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
    public static class Author {
        String lastName;
        int age;
    }

    @Getter
    @AllArgsConstructor
    public static class Book {
        Author author;
    }

    @Getter
    @AllArgsConstructor
    public static class CarShop {
        private String carName;
        private int cost;
        private Set<String> colors;
    }

    @Getter
    public static class Employee extends Person {
        public Employee(String name) {
            super(name);
        }

        private int id;
        private int salary;
        private List<Employee> subordinates;
        Department department;
        String gender;
    }

    @Getter
    public static class Department {
    }


    @Getter
    @Setter
    public static class Person {
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
    public static class EmployeeContract {
        private Long id;
        private Date date;
    }

    @Getter
    public static class LineItem {
    }

    @Getter
    @AllArgsConstructor
    public static class MyDTO {
        private int amount;
    }

    @Getter
    @AllArgsConstructor
    public static class Node {
        int degree;
    }

    @Getter
    @AllArgsConstructor
    public static class Order {
        String customerName;
        List<LineItem> lineItems;
    }

    @Getter
    public static class ProductCatalogue {
        private Integer pId;
        private Integer cId;
    }

    @Getter
    public static class Stake {
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
    public static class Subject {
        String name;
        Integer marks;
        boolean optional;
    }

    @Getter
    public static class XYZProfile {
        private String name;
        private Integer code;

        public XYZProfile(String name, Integer code) {
            this.name = name;
            this.code = code;
        }
    }

    @Getter
    @AllArgsConstructor
    public static class User {
        private String name;
        private String id;
        private String email;
        private List<Integer> lists;
        int age;

        public User(String email, List<Integer> lists) {
            this.email = email;
            this.lists = lists;
        }
    }
}