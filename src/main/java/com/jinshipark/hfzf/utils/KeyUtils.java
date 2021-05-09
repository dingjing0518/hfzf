package com.jinshipark.hfzf.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KeyUtils {
    private static DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");

    public static String getOrderIdByPlate(String plate, String parkId) {
        return format.format(new Date()) + parkId + plate.substring(1, plate.length());
    }
}
