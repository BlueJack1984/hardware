package com.example.library.packer.sms.lang;


public class Assert {
    public Assert() {
    }

    public static boolean isNotEmpty(String s) {
        return s != null && !s.equals("");
    }

    public static boolean isEmpty(String s) {
        return s == null || s.equals("");
    }
}
