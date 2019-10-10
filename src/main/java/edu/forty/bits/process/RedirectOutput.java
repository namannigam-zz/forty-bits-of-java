package edu.forty.bits.process;

import java.io.File;
import java.io.IOException;

public class RedirectOutput {


    public static void main(String[] args) throws IOException, InterruptedException {
        redirectToFileTest();
    }

    private static void redirectToFileTest() throws IOException, InterruptedException {
        File outFile = new File("out.tmp");
        Process p = new ProcessBuilder("ls", "-la")
                .redirectOutput(outFile)
                .redirectError(ProcessBuilder.Redirect.INHERIT)
                .start();
        int status = p.waitFor();
        if (status == 0) {
            p = new ProcessBuilder("cat", outFile.toString())
                    .inheritIO()
                    .start();
            p.waitFor();
        }
    }
}