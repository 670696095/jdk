package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 10:50
 */
public class Gc {
    public static void main(String[] args) {
        System.gc();
        Runtime.getRuntime().gc();
    }
}
