package com.stackoverflow.nullpointer.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorInference {

    public static void main(String[] args) {
        List<BlogPost> posts = new ArrayList<>();
        Function<? super BlogPost, ? extends BlogPostType> classifier = BlogPost::getType;
        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream()
                .collect(Collectors.groupingBy(classifier));
    }

    private static class BlogPostType {

    }

    private static class BlogPost {
        BlogPostType type;

        public BlogPostType getType() {
            return type;
        }
    }
}