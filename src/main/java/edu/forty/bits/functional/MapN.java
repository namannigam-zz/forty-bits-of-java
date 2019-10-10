package edu.forty.bits.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapN {

    private static Map<String, ArrayList<String>> mapN = new HashMap<>();
    public static void main(String[] args) {

        ArrayList<String>  values = new ArrayList<>();
//        for (String val: values) {
//            ArrayList<String> tempList= mapN.get(functiongetKey()); //1
//            if (tempList == null) {  // 2
//                tempList = new ArrayList<>();
//            }else {
//                tempList.add(val);
//            }
//            mapN.put(functiongetKey(), tempList);  //3
//        }

        for (String val: values) {
            Types type = functiongetKey(val);
            if (type != null) {
                String key = type.name();
                if (key.equals("camp2"))
                    key = "camp1";
                ArrayList<String> tempList= mapN.get(key); //1
                if (tempList == null) {  // 2
                    tempList = new ArrayList<>();
                }
                tempList.add(val);
                mapN.put(key, tempList);  //3
            }
        }
    }


    private enum Types {
        ENUM
    }
    private static Types functiongetKey(String val) {
        return Types.ENUM;
    }


}
