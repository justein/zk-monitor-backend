package com.zfinfo.lyn.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.Map;

/**
 * @ClassName : GsonUtils
 * @Description : gson 工具类
 * @Author : Lyn
 * @CopyRight ZFINFO
 * @Date: 2020-10-12 15:25
 */
public class GsonUtils {

    private static Gson gson;

    static {
        GsonBuilder gsonBuilder = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss");
        gsonBuilder.disableHtmlEscaping();//禁止将部分特殊字符转义为unicode编码
        gson = gsonBuilder.create();
    }

    public static <V> String toJson(List<V> list) {
        return gson.toJson(list);
    }
}
