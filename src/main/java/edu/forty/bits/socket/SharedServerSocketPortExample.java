package com.stackoverflow.nullpointer.socket;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.StandardSocketOptions;
import java.util.UUID;

public class SharedServerSocketPortExample {

    public static void main(String[] args) throws IOException {

        try (ServerSocket ss = new ServerSocket()) {

            ss.setOption(StandardSocketOptions.SO_REUSEPORT, true);
            ss.bind(new InetSocketAddress(6666));

            UUID instanceId = UUID.randomUUID();
            System.out.printf("Instance: %s listening on: %s%n", instanceId, ss);
            byte[] prefix = ("From " + instanceId + ": ").getBytes();

            Socket client = ss.accept();

            client.getInputStream().transferTo(new FilterOutputStream(client.getOutputStream()) {

                @Override
                public void write(byte[] b, int off, int len) throws IOException {
                    super.write(prefix, 0, prefix.length);
                    super.write(b, off, len);
                }
            });
        }
    }
}