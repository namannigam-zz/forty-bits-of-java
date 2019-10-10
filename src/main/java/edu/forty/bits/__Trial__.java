package com.stackoverflow.nullpointer;

import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class __Trial__ {

    @Getter
    class Resource {
        String name;
        String category;
        String component;
        String group;
    }

//    1. Count of resources in the category.
//        2. Distinct count of components in each category. (component names can be duplicate)
//            3. Count of resources grouped by category and group.

    public static void main(List<Resource> resources) {
        Map<String, Long> categoryCount = resources.stream()
                .collect(Collectors.groupingBy(Resource::getCategory, Collectors.counting()));
        Map<String, Map<String, Long>> componentPerCategoryCount = resources.stream()
                .collect(Collectors.groupingBy(Resource::getCategory,
                        Collectors.groupingBy(Resource::getComponent, Collectors.counting())));
        Map<List<String>, Long> categoryAndGroupCount = resources.stream()
                .collect(Collectors.groupingBy(resource -> Arrays.asList(resource.getCategory(), resource.getGroup()),
                        Collectors.counting()));
    }
}