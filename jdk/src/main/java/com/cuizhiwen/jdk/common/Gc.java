package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 10:50
 */
public class Gc {
    /**
     * 垃圾回收机制
     * @param args
     */
    public static void main(String[] args) {
        System.gc();
        Runtime.getRuntime().gc();
    }
}
