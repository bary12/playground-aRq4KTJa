package com.yourself;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import org.junit.Assert;

public class Util {

    public static ByteArrayOutputStream outContent;
    public static ByteArrayOutputStream errContent;
    public static final PrintStream stdout = System.out;
    public static final PrintStream stderr = System.err;
    public static final String ErrorChannel = "שגיאה!"; // If you don't want to support Hebrew, change this.
    public static final boolean suppressStderr = true; // Makes it so that TECHIO will not display stderr.

    public static void setUpStreams() {
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    public static void cleanUpStreams() {
        System.setOut(stdout);
        if (!suppressStderr)
            System.setErr(stderr);
    }

    public static void msg(String channel, String msg) {
        for(String line: msg.split("\n")) {
            System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, line));
        }
    }

    /**
     *
     * @param func - The function to activate
     * @return The output from StdOut
     */
    public static String getFromStdOut(Consumer<Integer> func, int arg) {
        setUpStreams();
        func.accept(arg);
        String content = outContent.toString();
        cleanUpStreams();
        return content;
    }

    public static void success(boolean success) {
        System.out.println(String.format("TECHIO> success %s", success));
    }

    public static void assertTrue(boolean assertion, String message) throws AssertionError {
        assertTrue(assertion, message, ErrorChannel);
    }

    public static void assertTrue(boolean assertion, String message, String channel) throws AssertionError {
        try {
            Assert.assertTrue(message, assertion);
        } catch (AssertionError ae) {
            msg(channel, message);
            success(false);
            throw ae;
        }
    }

}
