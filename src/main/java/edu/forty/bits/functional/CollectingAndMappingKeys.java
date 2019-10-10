package edu.forty.bits.functional;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectingAndMappingKeys {

    private Map<String, List<RelationShip>> groupAndMapRelationships(List<RelationShip> relationShips) {
        return relationShips.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(RelationShip::getRelationshipType),
                        map -> map.entrySet().stream()
                                .map(e -> new AbstractMap.SimpleEntry<>(
                                        e.getValue().size() == 1 ?
                                                e.getKey().getRelationship() : e.getKey().getRelationshipPlural(),
                                        e.getValue()))
                                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))));
    }

    class RelationShip {
        String personA;
        String personB;
        RelationshipType relationshipType;

        public RelationshipType getRelationshipType() {
            return relationshipType;
        }
    }

    class RelationshipType {
        String relationship;
        String relationshipPlural;

        public String getRelationship() {
            return relationship;
        }

        public String getRelationshipPlural() {
            return relationshipPlural;
        }
    }
}