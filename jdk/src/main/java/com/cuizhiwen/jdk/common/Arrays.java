package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 17:08
 */
public class Arrays {
    /**
     *数组:用一个表示符封装在一起具有相同类型的对象 或 基本类型数据序列。数组是对象，由jvm直接创建。
     */
    public static void main(String[] args) {

        /**
         * 静态初始化
         */
        int[] intArr;
        intArr = new int[]{1,2,3};
        /**
         * 隐式初始化
         */
        int [] arr ={1,2,3};
        /**
         * 动态初始化
         */
        int [] prices = new int[5];
        /**
         * 二维数组
         */
        int [][] in   = {{1,2,3},{4,5}};
        int [][] ints = new int[4][5];
        /**
         * 变长二维数组
         */
        int [][] intss = new int[4][];
        intss[0] = new int[2];
    }
}
