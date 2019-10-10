package edu.forty.bits.jdk09.challenges;

import java.util.Optional;

public class Challenge7 {

    public static void main(String[] args) throws Throwable {
        String finalOpt = "";
        Optional<String> opt = null;

        try {
            opt = Optional.of(null);
        } catch (RuntimeException e) {
            System.out.println(opt.orElseThrow(() -> new Throwable()));
        } catch (Throwable throwable) {
            finalOpt = opt.orElse("lol");
        }

        System.out.println(finalOpt);
    }
}