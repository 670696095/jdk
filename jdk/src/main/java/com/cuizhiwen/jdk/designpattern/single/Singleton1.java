package com.cuizhiwen.jdk.designpattern.single;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 14:50
 */
public class Singleton1 {
    /**
     * 1、懒汉式，线程不安全
     *          是否 Lazy 初始化：是
     *          是否多线程安全：否
     *
     * 实现难度：易
     *
     * 描述：
     *          这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。
     *          因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
     *          这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
     */

    /**
     * lazy initialization 类调用时才生成对象
     */
    // private static Singleton st;

    /**
     * 即时加载 类加载时就生成对象
     */
    private static Singleton1 st = new Singleton1();

    private static Singleton1 instance;
    private Singleton1 (){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
