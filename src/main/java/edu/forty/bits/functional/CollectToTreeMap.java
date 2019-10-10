package edu.forty.bits.functional;

import java.util.*;
import java.util.stream.Collectors;

public class CollectToTreeMap {


    private Map<String, Skill> skillMap = new HashMap<>();

    public SortedMap<String, Long> skill_nApplicants() {
        return new TreeMap<>(skillMap.values().stream().collect(Collectors.toMap(Skill::getName, Skill::getNumApplicants)));
    }


    public static class Skill {

        private String name;
        private Long numApplicants;

        public void plusOneApplicant() {
            this.numApplicants++;
        }

        public Long getNumApplicants() {
            return numApplicants;
        }

        public Skill(String name) {
            super();
            this.name = name;
            this.numApplicants = 0L;
        }

        public String getName() {
            return name;
        }
    }
}