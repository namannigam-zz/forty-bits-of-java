package edu.forty.bits.functional;

import java.util.*;
import java.util.stream.Collectors;

public class ListToMap {


    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("nullpointer-id1", "1"));
        people.add(new Person("nullpointer-id2", "2"));
        people.add(new Person("nullpointer-id3", "3"));
        people.add(new Person("stackoverflow-id4", "4"));
        people.add(new Person("stackoverflow-id4", "4"));
        people.add(new Person("stackoverflow-id5", "5"));
        people.add(new Person("random-id10", "10"));

        System.out.println(getEmployees(people));
    }

    public static Map<String, List<Employee>> getEmployees(List<Person> personList) {
        Map<String, List<Employee>> res = personList.stream().map(person -> new Employee(person.getId(), person.getName().split("-")[1]))
                .collect(Collectors.groupingBy(a -> a.getName().split("-")[0]));

        Map<String, List<String>> result = personList.stream()
                .map(s -> s.getName().split("-"))
                .collect(Collectors.groupingBy(a -> a[0],
                        Collectors.mapping(a -> a[1], Collectors.toList())));
        return res;
    }

    private static class Employee {
        String employeeId;
        String name;

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Employee(String name, String employeeId) {
            this.employeeId = employeeId;
            this.name = name;
        }
    }

    private static class Person {
        String name;
        String id;

        public String getId() {
            return id;
        }

        public Person(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }
    }
}