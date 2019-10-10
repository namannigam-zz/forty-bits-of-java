package com.stackoverflow.nullpointer.functional;

import java.util.function.Consumer;

class ConsumerJava8 {

    private static void consumerTrial() {

        Consumer<ConsumerJava8> consumer = new Consumer<ConsumerJava8>() {
            @Override
            public void accept(ConsumerJava8 lambda) {

            }

//            @Override
//                private Consumer<T> andThen(Consumer<? super T> after) {
//                    Objects.requireNonNull(after);
//                    return (T t) -> {
//                        accept(t);
//                        after.accept(t);
//                    };
//                }
        };
    }

    public static void main(String[] args) {
        consumerTrial();
    }
}
