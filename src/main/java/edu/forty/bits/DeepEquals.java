package edu.forty.bits;


import java.util.Objects;

/**
 * Created by naman.nigam on 23/03/17.
 */
public class DeepEquals {

    public static void main(String[] args) {
        edu.forty.bits.Objects.Person sampleModel1 = new edu.forty.bits.Objects.Person("naman");
        edu.forty.bits.Objects.Person sampleModel2 = new edu.forty.bits.Objects.Person("nmn");
        System.out.println(Objects.deepEquals(sampleModel1,sampleModel2));
    }
}
