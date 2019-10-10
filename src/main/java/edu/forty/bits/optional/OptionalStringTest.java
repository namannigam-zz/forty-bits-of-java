package com.stackoverflow.nullpointer.optional;

import java.util.Optional;

public class OptionalStringTest {

    public static void main(String[] args) {
        Entity entity = new Entity("nullpointer");
        Service service = new Service("stackoverflow");

        String presentImpl = Optional.ofNullable(entity.getName()).filter(s -> !s.isEmpty())
                .map(OptionalStringTest::trimWhiteSpaces).filter(s -> !s.isEmpty())
//                .or(service::getMostCommonNameOptional).filter(s -> !s.isEmpty()) // java-9
                .orElse("success");
        System.out.println(String.format("present implementation - %s", presentImpl));

        String customImpl = OptionalString.of(entity.getName())
                .map(OptionalStringTest::trimWhiteSpaces)
                .or(service::getMostCommonName)
                .orElse("learning");
        System.out.println(String.format("custom implementation - %s", customImpl));
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