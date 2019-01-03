package com.cuizhiwen.jdk.common;

import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 14:50
 */
public class Memory {
    public static void main(String[] args) {
        /**
         * 栈  一般存放基本数据类型对象，对象的引用。
         */
        int i = 10;
        List list = null;
        /**
         * 堆 一般通过new 或者构造器创建的对象  （str在栈 new的对象在堆内存)。
         */
        String str = new String("abc");
        /**
         * 量值在-128-127之间 不会new新的Integer对象，而是直接引用常量池中的Integer。
         */
        Integer in = new Integer(123);

    }

}
