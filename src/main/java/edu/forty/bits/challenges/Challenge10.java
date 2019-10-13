package edu.forty.bits.challenges;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Challenge10 {

    public static void main(String[] args) throws NoSuchFieldException {
        System.out.println(Jedi.class.getAnnotation(Table.class).name());
        System.out.println(Jedi.class.getField("attackType").getAnnotation(Column.class).name());
    }


    @Table(name = "jedi")
    static class Jedi {
        @Column(name="attack_type")
        String attackType;

        public String getAttackType() {
            return attackType;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface Table {String name();}
    @Retention(RetentionPolicy.RUNTIME)
    @interface Column{String name();}
}
