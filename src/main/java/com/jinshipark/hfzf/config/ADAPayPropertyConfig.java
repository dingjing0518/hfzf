package com.jinshipark.hfzf.config;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ADAPayPropertyConfig {
    private static String ada_pay_config = "adapay.properties";
    private static Properties adaPayConfig;

    static {
        adaPayConfig = new Properties();
        try {
            Class clazz = ADAPayPropertyConfig.class;
            InputStream is = ADAPayPropertyConfig.class.getClassLoader().getResourceAsStream(ada_pay_config);
            adaPayConfig.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return key != null ? adaPayConfig.getProperty(key) != null ? adaPayConfig
                .getProperty(key) : "" : "";
    }

    public static String getProperty(String key, String defaultValue) {
        String value = adaPayConfig.getProperty(key);
        if (value == null)
            return defaultValue;

        return value;
    }

    public static boolean getBooleanProperty(String name, boolean defaultValue) {
        String value = ADAPayPropertyConfig.getProperty(name);

        if (value == null)
            return defaultValue;

        return (new Boolean(value)).booleanValue();
    }

    public static int getIntProperty(String name) {
        return getIntProperty(name, 0);
    }

    public static int getIntProperty(String name, int defaultValue) {
        String value = ADAPayPropertyConfig.getProperty(name);

        if (value == null)
            return defaultValue;

        return (new Integer(value)).intValue();
    }

    public static int getIntValueByKey(String key) {

        return Integer.parseInt(adaPayConfig.getProperty(key));
    }


    public static String getStrValueByKey(String key) {
        String value = null;
        try {
            value = new String(adaPayConfig.getProperty(key).getBytes("ISO8859-1"),
                    "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;

    }

}
