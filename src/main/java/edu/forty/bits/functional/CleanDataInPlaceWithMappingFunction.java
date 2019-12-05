package edu.forty.bits.functional;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CleanDataInPlaceWithMappingFunction {

    public <T> List<T> cleanData(List<T> data, List<Function<T, T>> cleanOps) {
        return data.stream().map((str) -> {
            T cleanData = str;
            for (Function<T, T> function : cleanOps) {
                cleanData = function.apply(cleanData);
            }
            return cleanData;
        }).collect(Collectors.toList());
    }

    public <T> List<T> cleanDataByHolger(List<T> data, List<Function<T, T>> cleanOps) {
        cleanOps.stream()
                .reduce(Function::andThen)
                .ifPresent(f -> data.replaceAll(f::apply));
        return data;
    }

    public <T> List<T> cleanDataByHolgerFurther(List<T> data, List<UnaryOperator<T>> cleanOps) {
        cleanOps.stream()
                .reduce((f1, f2) -> t -> f2.apply(f1.apply(t)))
                .ifPresent(data::replaceAll);
        return data;
    }
}