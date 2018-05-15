package com.zxbin.commomlib.utils;


import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * 简化Json操作
 * Created by zxbin on 2017/12/13.
 */

public class JsonUtil {
    private static Gson gson;

    public static <T> String toJson(T clz) {
        return getGson().toJson(clz);
    }

    public static <T> T toObject(String json, Class<T> clz) {
        return fromJson(json, clz);
    }

    public static <T> List<T> toList(String json, Class<T> clz) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(List.class, new Class[]{clz});
        return fromJson(json, type);
    }

    public static <T, K> K toObject(String json, Class<K> baseClass, Class<T> cls) {
        ParameterizedTypeImpl parameterizedType = new ParameterizedTypeImpl(baseClass, new Class[]{cls});
        return fromJson(json, parameterizedType);
    }

    private static <T> T fromJson(String json, ParameterizedType cls) {
        return fromJson(json, cls);
    }

    private static <T> T fromJson(String json, Class<T> cls) {
        return fromJson(json, cls);
    }
    private static Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }

        return gson;
    }
}
