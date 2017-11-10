package com.yourself;

public class TechIOUtil {

    public static void msg(String channel, String msg) {
        System.out.println(String.format("TECHIO> message --channel \"%s\" \"%s\"", channel, msg));
    }

    public static void success(boolean success) {
        System.out.println(String.format("TECHIO> success %s", success));
    }
}
