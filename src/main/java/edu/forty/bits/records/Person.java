package edu.forty.bits.records;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Records behave like normal classes: they can be declared top level or nested, they can be generic,
 * they can implement interfaces, and they are instantiated via the new keyword.
 * The record's body may declare static methods, static fields, static initializers, constructors,
 * instance methods, and nested types.
 * The record, and the individual components in a state description, may be annotated.
 * If a record is nested, then it is implicitly static; this avoids an immediately enclosing instance
 * which would silently add state to the record.
 */
public record Person(String name,String lastName) {
    static char gender; // can be assigned value anytime and statically keeps it further

    void print() {
        System.out.println(name + ":" + lastName + "-" + gender);
    }

    /**
     * The constructor may be declared without a formal parameter list (in this case, it is assumed identical
     * to the state description), and any record fields which are definitely unassigned when the constructor body
     * completes normally are implicitly initialized from their corresponding formal parameters (this.x = x) on exit.
     * This allows an explicit canonical constructor to perform only validation and normalization of its parameters,
     * and omit the obvious field initialization.
     */
    public Person {
        if (name.equalsIgnoreCase(lastName)) {
            System.out.println("same-same");
        }
    }
}