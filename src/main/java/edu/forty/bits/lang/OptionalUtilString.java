package com.stackoverflow.nullpointer.lang;

import java.util.Optional;

public class OptionalUtilString {


    public static void main(String[] args) {
        Entity entity = new Entity("com/stackoverflow/nullpointer");
        Service service = new Service("stackoverflow");

        String presentImpl = Optional.ofNullable(entity.getName()).filter(s -> !s.isEmpty())
                .map(OptionalUtilString::trimWhiteSpaces).filter(s -> !s.isEmpty())
                .or(service::getMostCommonNameOptional).filter(s -> !s.isEmpty())
                .orElse("success");
        System.out.println(String.format("present implementation - %s", presentImpl));

        String customImpl = OptionalString.of(entity.getName())
                .map(OptionalUtilString::trimWhiteSpaces)
                .or(service::getMostCommonName)
                .orElse("learning");
        System.out.println(String.format("custom implementation - %s", customImpl));
    }

    private static Optional<String> ofEmptyable(String string) {
        return isNullOrEmpty(string) ? Optional.empty() : Optional.of(string);
    }

    private static boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }



    private static String trimWhiteSpaces(String x) {
        return x.trim();
    }

    private static class Entity {
        String name;

        Entity(String name) {
            this.name = name;
        }

        String getName() {
            return name;
        }
    }

    private static class Service {
        String mostCommonName;

        Service(String mostCommonName) {
            this.mostCommonName = mostCommonName;
        }


        String getMostCommonName() {
            return mostCommonName;
        }

        Optional<String> getMostCommonNameOptional() {
            return Optional.of(mostCommonName);
        }
    }
}