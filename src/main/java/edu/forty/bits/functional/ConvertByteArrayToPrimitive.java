package edu.forty.bits.functional;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.IntStream;

public class ConvertByteArrayToPrimitive {

    /**
     * type widening to int and conversion to ByteArrayOutputStream
     */
    public static byte[] toByteArray(IntStream stream) {
        return stream.collect(ByteArrayOutputStream::new, (baos, i) -> baos.write((byte) i),
                (baos1, baos2) -> baos1.write(baos2.toByteArray(), 0, baos2.size()))
                .toByteArray();
    }

    public static byte[] toByteArrayFunctional(List<Byte> listByte) {
        return listByte.stream().collect(ByteArrayOutputStream::new, ByteArrayOutputStream::write,
                (baos1, baos2) -> baos1.writeBytes(baos2.toByteArray()))
                .toByteArray();
    }

    public static byte[] toByteArrayIterative(List<Byte> listByte) {
        byte[] arrayBytes = new byte[listByte.size()];
        IntStream.range(0, listByte.size()).forEach(i -> arrayBytes[i] = listByte.get(i));
        return arrayBytes;
    }
}