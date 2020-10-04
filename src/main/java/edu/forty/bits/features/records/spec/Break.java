package edu.forty.bits.features.records.spec;

import java.util.Arrays;

//It is a compile-time error for a record declaration to declare a record component with the name:
// clone, finalize, getClass, hashCode, notify, notifyAll, toString, or wait (8.10.3).


public record Break<R extends Record>(R record, String... notifications) {

    public Break(R record, String... notifications) {
        System.out.println("record: " + record + " and notifications: " + Arrays.toString(notifications));
        this.record = record;
        this.notifications = notifications;
    }

//    public Break(R record) {
//        System.out.println("record: " + record);
//        this.record = record;
//    }

    public Break() {
        this(null); // this works
        // actually intelliJ suggests it uses the constructor that is not compiling
    }

    public static void main(String[] args) {
        new Break<>(new Break<>());
    }
}