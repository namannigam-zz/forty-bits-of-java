package edu.forty.bits.lvti;
import java.util.List;
import java.util.Optional;

public class Q49603807 {

    public static void main(String[] args) {
        Optional<?> first = List.of("a", "b", "c").stream().map(String::length).findFirst();
        var second = List.of("a", "b", "c").stream().map(String::length).findFirst();
        System.out.println(first);
        System.out.println(second);
    }
}