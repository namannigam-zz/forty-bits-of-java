package edu.forty.bits.functional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PutIfPresentInMap {

    static Map<String, String> map = new HashMap<>();

    static void addToMapIfKeyExistsOneLiner(String k, String v) {
        if (map.containsKey(k) && v != null) { // if key exists and value is not null
            map.put(k, v); // Put in the map
        } else { // else throw exception
            throw new IllegalArgumentException("Else throwing exception.");
        }
    }

    static void addToMapIfKeyExists(String k, String v) {
        map.put(k, Optional.ofNullable(v)
                .filter(ignore -> map.containsKey(k))
                .orElseThrow(IllegalArgumentException::new));
    }

    public static void main(String[] args) {
        map.put("a", "trying");
        map.put("b", "crying");

        addToMapIfKeyExists("a", "works");
        System.out.println(map.get("a").equals("works"));

        addToMapIfKeyExistsOneLiner("a", "works");
        System.out.println(map.get("a").equals("works"));


        addToMapIfKeyExists("b", null); // null value throw exception
        addToMapIfKeyExists("e", "new key throws exception");

        addToMapIfKeyExistsOneLiner("b", null); // null value throw exception
        addToMapIfKeyExistsOneLiner("e", "new key throws exception");
    }
}