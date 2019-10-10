package edu.forty.bits.functional;

public class RunnableLambda {

    interface Plant {
        void grow();
    }

    //apply interface to class
    static class Eucalyptus implements Plant {
        @Override
        public void grow() {
            System.out.println("This is from Eucalyptus");
        }
    }

    public static void main(String[] args) {

        //Create an instance of Eucalyptus
        Eucalyptus eucalyptus = new Eucalyptus();
        eucalyptus.grow();

        //Anonymous class Myrtle from Plant interface
        Plant myrtle = new Plant() {
            @Override
            public void grow() {
                System.out.println("This was running from anonymous class from Plant Interface");
            }
        };
        myrtle.grow();

        Plant lambdaRep = () -> System.out.println("This is running via lambda from Plant Interface");
        lambdaRep.grow();

        // this is from the overriden implementation
        Eucalyptus eucalyptus1 = new Eucalyptus();
        eucalyptus1.grow();
    }
}