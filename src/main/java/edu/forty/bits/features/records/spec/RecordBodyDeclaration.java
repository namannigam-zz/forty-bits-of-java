package edu.forty.bits.features.records.spec;

import lombok.Getter;
import lombok.NonNull;

public record RecordBodyDeclaration() {

    @Getter
    static class InnerClass {
        int value;
    }

    static int valStat = 10;

    static {
        record InnerRec(@NonNull String innerText) {
            public InnerRec {
                System.out.println(innerText);
            }

            public String innerText() {
                return innerText;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }

            @Override
            public String toString() {
                return "fundoo";
            }
        }
        new InnerRec("inner string");
        System.out.println("static block");
    }

    public static void main(String[] args) {

    }
}