package com.jinshipark.hfzf.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyUtils {
    private static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String getOrderIdByPlate(String plate, String parkId) {
        String str = plate.substring(0, 1);
        return format.format(new Date()) + parkId + gbEncoding(str).toUpperCase() + plate.substring(1, plate.length());
    }

    public static String gbEncoding(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + hexB;
        }
        return unicodeBytes;
    }
}
