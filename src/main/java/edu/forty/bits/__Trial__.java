package edu.forty.bits;

import lombok.*;

import java.util.*;
import java.util.stream.*;

public class __Trial__ {

    @Getter
    @AllArgsConstructor
    static class NPE {
        Integer stat;
        Reason reason;
    }

    @Getter
    static class Reason {
        String detail;
    }

    public static void main(String[] args) {
//        JEP-358
//        NPE npe = new NPE(2, null);
//        System.out.println(npe.reason.detail.equalsIgnoreCase("fix"));
        solve();
    }

    private static void solve() {
       List<Entity> getList = List.of();
        Map<String, List<Wrapper>> subjectMap = getList.stream()
                .collect(Collectors.groupingBy(Entity::getSubject,
                        Collectors.mapping(Wrapper::extractAttributes,
                                Collectors.toList())));


    }

    @Builder
    static class Wrapper {
        private final String unit1;
        private final String unit2;
        private final String unit3;

        public static Wrapper extractAttributes(Entity subject) {
            return Wrapper.builder().unit1(subject.getUnit1())
                    .unit2(subject.getUnit2())
                    .unit3(subject.getUnit3()).build();
        }
    }

    @Getter
    @Builder
    static class Entity {
        private final String subject;
        private final String unit1;
        private final String unit2;
        private final String unit3;
    }
}