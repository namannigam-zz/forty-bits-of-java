package edu.forty.bits.functional;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.stream.Stream;

public class SimilarOperationToAggregateFields {

    private Nutrients nutrientsCalculator(List<FoodNutritional> responseBody) {
        Supplier<Stream<FoodNutritional>> foodNutritionalSupplier = responseBody::stream;
        return Nutrients.builder()
                .carbohydrates(sumNutrition(foodNutritionalSupplier, FoodNutritional::getTotalCarbohydrate))
                .protein(sumNutrition(foodNutritionalSupplier, FoodNutritional::getProtein))
                .fat(sumNutrition(foodNutritionalSupplier, FoodNutritional::getTotalFat))
                .dietaryFiber(sumNutrition(foodNutritionalSupplier, FoodNutritional::getDietaryFiber))
                .build();
//        return Nutrients.builder()
//                .carbohydrates(sumNutrition(responseBody, FoodNutritional::getTotalCarbohydrate))
//                .protein(sumNutrition(responseBody, FoodNutritional::getProtein))
//                .fat(sumNutrition(responseBody, FoodNutritional::getTotalFat))
//                .dietaryFiber(sumNutrition(responseBody, FoodNutritional::getDietaryFiber))
//                .build();
    }

    private Double sumNutrition(Supplier<Stream<FoodNutritional>> foodNutritionalSupplier,
                                ToDoubleFunction<FoodNutritional> nutritionTypeFunction) {
        return foodNutritionalSupplier.get().mapToDouble(nutritionTypeFunction).sum();
    }

    private Double sumNutrition(List<FoodNutritional> foodNutritional,
                                ToDoubleFunction<FoodNutritional> nutritionTypeFunction) {
        return foodNutritional.stream().mapToDouble(nutritionTypeFunction).sum();
    }


    @lombok.Builder
    @ToString
    static class Nutrients {
        private Double carbohydrates;
        private Double protein;
        private Double fat;
        private Double dietaryFiber;
    }

    @Getter
    static class FoodNutritional {
        private Double totalFat;
        private Double totalCarbohydrate;
        private Double dietaryFiber;
        private Double protein;
    }
}