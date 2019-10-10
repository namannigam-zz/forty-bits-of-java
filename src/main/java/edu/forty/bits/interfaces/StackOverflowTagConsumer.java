package com.stackoverflow.nullpointer.interfaces;

import java.util.ArrayList;
import java.util.List;

public class StackOverflowTagConsumer {

    public static void main(String[] args) {
        List<Question> currentQuestions = new ArrayList<>();

        // if some action to sort by votes
        displaySortedByVotes(currentQuestions);

        // if another action to sort by newest
        displaySortedByNewest(currentQuestions);
    }

    private static void displaySortedByVotes(List<Question> currentQuestions) {
        System.out.println(StackOverflowTag.sortByNewest(currentQuestions));
    }

    private static void displaySortedByNewest(List<Question> currentQuestions) {
        System.out.println(StackOverflowTag.sortByNewest(currentQuestions));
    }
}
