package com.cuizhiwen.jdk.common.format.math;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:43
 */
public class math {
    /**
     * Math --- 针对基本类型提供了初等数学运算 --- 提供了大量的静态方法，
     * 本身是作为一个工具类来使用的。
     * BigDecimal --- 用于精确运算的类，要求参数以字符串形式进行传递，在
     * 底层是以按位的方式来进行运算
     * BigInteger --- 用于存储和计算任意大的整数的类。
     * @param args
     */
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
