package com.yourself;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Util {

    public static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    public static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    public static final PrintStream stdout = System.out;
    public static final PrintStream stderr = System.err;


    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public static void cleanUpStreams() {
        System.setOut(stdout);
        System.setErr(stderr);
    }

    public static void msg(String channel, String msg) {
        for(String line: msg.split("\n")) {
            System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, line));
        }
    }

    public static void success(boolean success) {
        System.out.println(String.format("TECHIO> success %s", success));
    }
}
