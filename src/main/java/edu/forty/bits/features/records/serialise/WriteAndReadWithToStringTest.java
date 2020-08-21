package edu.forty.bits.features.records.serialise;

import java.io.*;
import java.util.Objects;

public class WriteAndReadWithToStringTest {
    public record PersonRecord(String firstName, String lastName) implements Person, Serializable {
    }

    static class PersonClass implements Person, Serializable {
        final String firstName;
        final String lastName;

        public PersonClass(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String firstName() {
            return firstName;
        }

        public String lastName() {
            return lastName;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass())
                return false;
            PersonClass that = (PersonClass) o;
            return Objects.equals(firstName, that.firstName)
                    && Objects.equals(lastName, that.lastName);
        }

        public int hashCode() {
            return Objects.hash(firstName, lastName);
        }

        public String toString() {
            return "HumanClass{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    public static void main(String... args) throws IOException, ClassNotFoundException {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(
                             new FileOutputStream("persons.bin"))) {
            out.writeObject(new PersonRecord("Heinz", "Kabutz"));
            out.writeObject(new PersonClass("Heinz", "Sommerfeld"));
            out.writeObject(null);
        }

        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("persons.bin"))) {
            Person human;
            while ((human = (Person) in.readObject()) != null) {
                System.out.println(human);
            }
        }
    }
}