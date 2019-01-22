package com.cuizhiwen.jdk.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;


public class JSONProvider {
    private static String getClassName() {
        return "JSONProvider";
    }

    /**json string 转 对象
     * */
    public static <T> Object parseObject( String text, Class<T> clazz) {
        try {
            if (StringUtils.isBlank(text)){
                return  null;
            }
            return JSON.parseObject(text, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    /**对象 转json string
     * */
    public static String toJSONString( Object object) {
        try {
            if (null == object)
                return null;
            return JSON.toJSONString(object);
        } catch (Exception e) {
            return null;
        }
    }

    /**json inputstream 转 对象
     * */
    public static <T> Object parseObject( InputStream inputStream, Class<T> clazz) {
        try {
            String text = YTOString.is2String(inputStream);
            if (StringUtils.isBlank(text))
            {return null;}
            return JSON.parseObject(text, clazz);
        } catch (Exception e) {
            YTOLogger.getInstance().warn("inputsteam", e);
            return null;
        }
    }

    /**json inputstream 转 对象
     * */
    public static <T> Object parseJsonObject(JSONObject jsonObject, Class<T> clazz) {
        try {
            return jsonObject.toJavaObject(clazz);
        } catch (Exception e) {
            YTOLogger.getInstance().warn("inputsteam", e);
            return null;
        }
    }

    /**json string 转 对象
    * */
    public static <T> Object parseArrayObject( String text, Class<T> clazz) {
        String flag = getClassName() + ".parseArrayObject";
        try {
            if (StringUtils.isBlank(text))
            { return null;}
            return JSON.parseArray(text, clazz);
        } catch (Exception e) {
            YTOLogger.getInstance().warn("exception", e);
            return null;
        }
    }
}
