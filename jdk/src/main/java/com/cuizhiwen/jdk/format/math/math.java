package com.cuizhiwen.jdk.format.math;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:43
 */
public class math {
    public static void main(String[] args) {
        /**
         * 向上取整
         */
        Math.ceil(1.3);
        /**
         * 向下取整
         */
        Math.floor(1.3);
        /**
         * 取绝对值
         */
        Math.abs(-1);
        /**
         * 取随机数
         */
        int num = (int) (Math.random() * 3);
        System.out.println("num=:" + num);
    }
}
