package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 17:42
 */
public class ValueDeliver {
    /**
     * 赋值：就是一个值传递过程。
     * 值传递 ：传递了对象的副本，副本变了，原对象不变
     * 引用传递：传对象的引用，外部引用改变会改变原对象。
     * 自动装箱：对基本数据类型和对应包装类的一个转化
     *          内置数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类
     * Math.round 加正0.5后 向下取整。
     */
    public static void main(String[] args) {

        /**
         * 装箱：将基本类型转换成包装类对象
         */
        int i = 10;
        //手动装箱
        Integer x = new Integer(i);
        //自动装箱
        Integer y =10;

        /**
         * 拆箱：将包装类对象转换成基本类型的值
         */
        Integer j = new Integer(8);
        //手动拆箱
        int m = j.intValue();

        //自动拆箱
        int n = j;
        System.out.println("访问\"菜鸟教程!\"");
    }

}
