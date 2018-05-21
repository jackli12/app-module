package com.xp.template.framework.utils;

import android.util.Log;

/**
 * describe
 * date 2018/5/18
 * author xugaopan
 */

public class Logger {
    private static boolean DEBUG;
    private static String TAG = "xp-app";

    public static void openDebug(boolean isDebug) {
        DEBUG = isDebug;
    }

    public static void d(Object... msg) {
        if (DEBUG) {
            Log.d(TAG, buildMessage(msg));
        }
    }

    public static void e(Object... msg) {
        if (DEBUG) {
            Log.e(TAG, buildMessage(msg));
        }
    }

    public static void i(Object... msg) {
        if (DEBUG) {
            Log.i(TAG, buildMessage(msg));
        }
    }

    public static void w(Object... msg) {
        if (DEBUG) {
            Log.w(TAG, buildMessage(msg));
        }
    }

    public static void v(Object... msg) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(msg));
        }
    }

    private static String buildMessage(Object... msg) {
        StringBuilder str = new StringBuilder();
        if (msg != null) {
            for (Object obj : msg) {
                if (obj == null) {
                    str.append("null").append(" ");
                    continue;
                }
                str.append(obj).append(" ");
            }
        } else {
            str.append("null");
        }
        return str.toString();
    }

}
