package com.cuizhiwen.jdk.common;

import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 14:50
 */
public class Memory {
    /**
     * mew ：操作符本意是分配内存，调用构造方法，填充各个域（对象初始化）。
     * 方法区（面向对象）
     * 本地方法栈
     * 寄存器
     */
    public static void main(String[] args) {
        /**
         * 栈  一般存放基本数据类型对象，对象的引用。方法内的局部变量等
         */
        int i = 10;

        List list = null;

        /**
         * 堆 一般通过new 或者构造器创建的对象  （str在栈 new的对象在堆内存)。final修饰的局部变量。 全局变量
         */
        String str = new String("abc");

        /**
         * 量值在-128-127之间 不会new新的Integer对象，而是直接引用常量池中的Integer。
         */
        Integer in = new Integer(123);

    }

}
