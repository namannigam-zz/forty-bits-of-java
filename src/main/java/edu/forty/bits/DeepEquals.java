package edu.forty.bits;

import java.awt.image.SampleModel;
import java.util.Objects;

/**
 * Created by naman.nigam on 23/03/17.
 */
public class DeepEquals {

    public static void main(String[] args) {
        SampleModel sampleModel1 = new SampleModel();
        SampleModel sampleModel2 = new SampleModel();
        System.out.println(Objects.deepEquals(sampleModel1,sampleModel2));
    }
}
