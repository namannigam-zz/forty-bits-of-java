package edu.forty.bits.functional;

import java.util.function.Consumer;

/**
 * https://stackoverflow.com/questions/58920215/why-functional-interface-initialize-like-singleton-when-use-lambda-in-factory-me
 */
public class ConsumerComparison {

    public static void main(String[] args) {
        Consumer<String> consumerA = asLambdaPrintStringConsumer();
        Consumer<String> consumerB = asLambdaPrintStringConsumer();


        Consumer<String> consumerA2 = s -> System.out.println(s);
        Consumer<String> consumerB2 = s -> System.out.println(s);


        Consumer<String> consumerA3 = asMethodRefPrintStringConsumer();
        Consumer<String> consumerB3 = asMethodRefPrintStringConsumer();

        Consumer<String> consumerA4 = asMethodRefFromStaticMethodStringConsumer();
        Consumer<String> consumerB4 = asMethodRefFromStaticMethodStringConsumer();


        System.out.println(consumerA.equals(consumerB));
        System.out.println(consumerA2.equals(consumerB2));
        System.out.println(consumerA3.equals(consumerB3));
        System.out.println(consumerA4.equals(consumerB4));
    }


    public static Consumer<String> asMethodRefFromStaticMethodStringConsumer() {
        return ConsumerComparison::print;
    }

    public static void print(String string) {
        System.out.println(string);
    }

    public static Consumer<String> asLambdaPrintStringConsumer() {
        return x -> System.out.println(x);
    }

    public static Consumer<String> asMethodRefPrintStringConsumer() {
        return System.out::println;
    }
}