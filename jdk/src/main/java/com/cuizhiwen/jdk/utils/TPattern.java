package com.cuizhiwen.jdk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/11 11:25
 */
public class TPattern {
    /**
     * 正则表达式 pattern类
     */
    private static Pattern ERROR_PATTERN = Pattern.compile("^([1-9]\\d{0,9}|0)([.]?|(\\.\\d{1,2})?)$");

    public static void main(String[] args) {
        Matcher m = ERROR_PATTERN.matcher("123");
        Boolean b = m.matches();
        System.out.println(b);
    }
}
