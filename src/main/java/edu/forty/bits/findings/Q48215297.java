package edu.forty.bits.findings;

/**
 * @link <href>https://stackoverflow.com/questions/48215297</href>
 */
public class Q48215297 {
    public static void main(String[] args) {
        Runnable test1 = ((I) (new I() {
        }))::test;  // compiles OK

        // uncomment the below
//        Runnable test2 = ((new I() {
//        }))::test;     // won't compile
    }

    interface I {
        private void test() {
        }
    }
    // <href>https://bugs.openjdk.java.net/browse/JDK-8194998</href>
}