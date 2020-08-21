package edu.forty.bits.features.records.serialise;

import java.io.*;
import java.util.Objects;

public class ConstructorValidationTest {
    public record PersonRecord(String firstName, String lastName) implements Person, Serializable {
        public PersonRecord(String firstName) {
            this(firstName, null);
        }

        public PersonRecord {
            if ("Heinz".equals(firstName))
                throw new IllegalArgumentException(
                        "\"%s\" is trademarked".formatted(firstName));
        }
    }

    static class PersonClass implements Person, Serializable {
        final String firstName;
        final String lastName;

        public PersonClass(String firstName,
                           String lastName) {
            if ("Heinz".equals(firstName))
                throw new IllegalArgumentException(
                        "\"%s\" is trademarked".formatted(firstName));
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonClass(String firstName) {
            this(firstName, null);
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