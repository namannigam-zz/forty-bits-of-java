package com.stackoverflow.nullpointer.utilities;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArray {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = OutputStream.nullOutputStream();
        outputStream.flush();
        byte[] bytes = new byte[100];
        ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length);
        baos.writeBytes(bytes);


        byte[] source = new byte[14];
        ByteArrayInputStream bis = new ByteArrayInputStream(source);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] sink = bos.toByteArray();
    }
}
