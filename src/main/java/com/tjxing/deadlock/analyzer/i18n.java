package com.tjxing.deadlock.analyzer;

import java.util.ResourceBundle;

public class i18n {

    private final static ResourceBundle bundle = ResourceBundle.getBundle("messages");

    public static String get(String key, String... params) {
        String msg = bundle.getString(key);
        for (int i = 0; i < params.length; ++i) {
            msg = msg.replaceAll("\\{" + i + "\\}", params[i]);
        }
        return msg;
    }

}
