package edu.forty.bits.findings;

/**
 * @link <href>https://stackoverflow.com/questions/48215194</href>
 * A.java:5: error: invalid method reference
 * new Thread(((new I() {}))::test);
 *           ^
 * compiler message file broken: key=compiler.misc.cant.resolve.args arguments=method, test, , , {4}, {5}, {6}, {7}
 */
public class Q48215194 {
    public static void main(String[] args) {

        // uncomment the below
//        new Thread((new I() {
//        })::test);
    }

    interface I {
        private void test() {
        }
    }
    // <href>https://bugs.openjdk.java.net/browse/JDK-8194997</href>
}