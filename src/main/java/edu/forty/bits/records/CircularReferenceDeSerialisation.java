package edu.forty.bits.records;

import lombok.Builder;

import java.io.*;

public class CircularReferenceDeSerialisation {

    private record Cyclic(Cyclic cycle) implements Serializable {
        public Cyclic() {
            this(new Cyclic(null));
        }
    }

    @Builder
    private record One(String one, Two two) implements Serializable {
        public One(String one) {
            this(one, null);
        }
    }

    private record Two(Integer two, Three three) implements Serializable {
    }

    private record Three(Long three, One one) implements Serializable {
    }

    public static void main(String... args) throws IOException, ClassNotFoundException {
        One one = new One("tail");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("records.bin"))) {
            out.writeObject(new One("one", new Two(2, new Three(3L, one))));
            out.writeObject(new Cyclic(new Cyclic(new Cyclic(new Cyclic()))));
            out.writeObject(null);
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("records.bin"))) {
            One allInOne;
            while ((allInOne = (One) in.readObject()) != null) {
                System.out.println(allInOne);
            }

            Cyclic cyclic;
            while ((cyclic = (Cyclic) in.readObject()) != null) {
                System.out.println(cyclic);
            }
        }
    }
}