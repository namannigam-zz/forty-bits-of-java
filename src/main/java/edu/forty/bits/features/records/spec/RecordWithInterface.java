package edu.forty.bits.features.records.spec;

public class RecordWithInterface {

    interface Able {
        default void method() {
            System.out.println("interface able");
        }
    }

    record Summable(String msg) implements Able {
        @Override
        public void method() {
            System.out.println("record able");
        }
    }

    public static void main(String[] args) {
        new Summable("message").method();
    }
}
