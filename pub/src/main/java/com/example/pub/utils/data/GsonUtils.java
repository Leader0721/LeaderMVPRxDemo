package com.example.pub.utils.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;


/**
 * @Description:利用Gson 对 JSON 数据 处理
 * @Prject:
 * @Package: com.example.pub.utils.data
 * @author: Leader
 * @date: 2017/11/16   15:36
 * @Copyright: 个人版权所有
 * @Company:bc
 * @version: 1.0.0
 */
public class GsonUtils {
    /**
     * 传json数据,返回Map<String,Object> 对象
     *
     * @param json
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parseJson2Map(String json) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        Gson gson = new GsonBuilder().create();
        JsonReader reader = new JsonReader(new StringReader(json));
        map = gson.fromJson(reader, new TypeToken<Map<String, Object>>() {
        }.getType());
        return map;
    }

    /**
     * 传Object对象,返回JSON
     *
     * @param object
     * @return
     * @throws Exception
     */
    public static String parseObj2Json(Object object) throws Exception {
        if (object == null) {
            return "";
        }
        Gson g = new GsonBuilder().create();
        String json = g.toJson(object, object.getClass());
        return json;
    }

    /**
     * JSON转成指定对象
     *
     * @param json
     */
    public static <T> T parseJson2Obj(String json, TypeToken<T> typeToken) throws Exception {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(json));
        return gson.fromJson(reader, typeToken.getType());
    }
}

