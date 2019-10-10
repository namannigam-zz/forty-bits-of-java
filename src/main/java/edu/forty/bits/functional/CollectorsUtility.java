package com.stackoverflow.nullpointer.stream;

import com.stackoverflow.nullpointer.pojo.ProductCatalogue;
import com.stackoverflow.nullpointer.pojo.Stake;
import com.stackoverflow.nullpointer.pojo.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class CollectorsUtility {

    public static void main(String[] args) {
    }

    private static List<User> userListWithSameEmailAndMergeLists(List<User> users) {
        return new ArrayList<>(users.stream()
                .collect(Collectors.toMap(User::getEmail, Function.identity(), (user1, user2) -> {
                    List<Integer> l1 = user1.getLists();
                    List<Integer> l2 = user2.getLists();
                    List<Integer> merge = IntStream.range(0, l1.size())
                            .mapToObj(i -> (l1.get(i) == 0 && l2.get(i) == 0) ? 0 : 1)
                            .collect(Collectors.toList());
                    return new User(user1.getEmail(), merge);
                })).values());
    }


    private static Map<Integer, List<Integer>> collectGroupingByAndMapping(List<ProductCatalogue> productCatalogueList) {
        return productCatalogueList.stream()
                .collect(Collectors.groupingBy(ProductCatalogue::getPId,
                        Collectors.mapping(ProductCatalogue::getCId, Collectors.toList())));

    }

    private static List<Stake> stakesHighestPerCustomerForParticularStakeLimited(List<Stake> stakes, int maxBetOfferId) {
        return stakes.stream()
                .filter(x -> x.getBetOfferId() == maxBetOfferId) // retains only objects where their offer is if equal to the supplied offerId
                .collect(toMap(Stake::getCustomerId,    // customer ids do not repeat as you've mentioned.
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparingInt(Stake::getStake))))  //   gets the highest stake values customer wise.
                .values()
                .stream()
                .collect(groupingBy(Stake::getStake)) // particular stake
                .values()
                .stream()
                .flatMap(x -> x.stream().limit(20)) //  and limited to 20 customers for a particular stake.
                .collect(Collectors.toList());
    }
}