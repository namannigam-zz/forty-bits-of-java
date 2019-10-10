package com.stackoverflow.nullpointer.function;

import com.stackoverflow.nullpointer.pojo.XYZProfile;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionUtility {

    public static void main(String[] args) {
        BinaryOperator<Integer> foo = (a, b) -> a * a + b * b;
        BiFunction<Integer, Integer, Integer> bar = (a, b) -> a * a + b * b;
        System.out.println(foo.apply(2, 3));
        System.out.println(bar.apply(2, 3));


        // biFunction on custom object
        BiFunction<String, Integer, XYZProfile> xyzProfileBiFunction = (string, integer) -> {
            XYZProfile xyzProfile = new XYZProfile(string, integer);
            // modify xyZProfile
            System.out.println(xyzProfile);
            return xyzProfile;
        };
        XYZProfile xyzProfile1 = xyzProfileBiFunction.apply("com/stackoverflow/nullpointer", 0);
        XYZProfile xyzProfile2 = xyzProfileBiFunction.apply("holger", 1);
        System.out.println(xyzProfile1 + "" + xyzProfile2);

        // function chain
        Function<String, Integer> x = Integer::valueOf;
        Function<Integer, Double> y = Integer::doubleValue;
        Function<Double, String> z = String::valueOf;
        String f = x.andThen(y).andThen(z).apply("1");

        // identity for unaryoperator t -> t
        UnaryOperator<Object> defaultParser2 = UnaryOperator.identity();

        // predicate definition
        Predicate<String> nonEmptyStringPredicate = s -> !s.isEmpty();
        System.out.println(nonEmptyStringPredicate.test("any"));


        Functional<String, Number> functional = (string) -> {
        };
        functional.method("com.stackoverflow.nullpointer.string", (string) -> 1);

        List<String> list = Arrays.asList("Abcd", "Abcd");
        Map<String, Integer> map = list.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, binaryOperatorToChooseAny()));
        System.out.println(map.size());


        BiFunction<Integer, Integer, Integer> biFunction = Integer::compare;
        System.out.println(biFunction.apply(10, 60));
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(10, 60));
        IntBinaryOperator intBinaryOperator = Integer::sum;
        System.out.println(intBinaryOperator.applyAsInt(10, 60));
    }

    interface ThreeConsumer<T, U, V> {
        void accept(T t, U u, V v);
    }

    public static <T, U, V> Consumer<T> bind2and3(ThreeConsumer<? super T, U, V> c, U arg2, V arg3) {
        return (arg1) -> c.accept(arg1, arg2, arg3);
    }

    static <T> boolean validateAllConditions(T object, Predicate<T>... predicates) {
        Predicate<T> init = t -> true;
        Arrays.stream(predicates).forEach(init::and);
        return init.test(object);
    }

    private static <T> BinaryOperator<T> binaryOperatorToChooseAny() {
        ThreadLocalRandom.current().nextBoolean(); // suggested by Holger
        //        return Math.random() < 0.5 ? ((x, y) -> x) : ((x, y) -> y);
        return (a, b) -> Objects.equals(a, b) ? a : b;
    }
}