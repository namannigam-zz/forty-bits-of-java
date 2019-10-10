package edu.forty.bits.intrface;

public class InterfaceUtility {

    interface G {
        void s();
    }

    enum H implements G {
        ONE, TWO;

        @Override
        public void s() {
        }
    }
}