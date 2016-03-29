package com.wsg.cleannews.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.wsg.cleannews.app.CleanNewsApplication;
import com.wsg.cleannews.common.Constant;

/**
 * Created by Wangsg on 16/3/17.
 * Description: SharedPreferences工具类
 * UpdateUser:
 * UpdateDate:
 */
public class SpUtile {

    public static String readString(String key) {
        return getSharedPreferences().getString(key, "");
    }

    public static void writeString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    public static boolean readBoolean(String key) {
        return getSharedPreferences().getBoolean(key, false);
    }

    public static void writeBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public static int readInt(String key) {
        return getSharedPreferences().getInt(key, 0);
    }

    public static int readInt(String key, int value) {
        return getSharedPreferences().getInt(key, value);
    }

    public static void writeInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    public static long readLong(String key) {
        return getSharedPreferences().getLong(key, 0);
    }

    public static void writeLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    public static void remove(String key) {
        getSharedPreferences().edit().remove(key).apply();
    }

    public static void removeAll() {
        getSharedPreferences().edit().clear().apply();
    }

    public static SharedPreferences getSharedPreferences() {
        return CleanNewsApplication.getContext()
                .getSharedPreferences(Constant.APP_NAME, Context.MODE_PRIVATE);
    }
}
