package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/24 9:35
 */
public class tenum {
    enum FreshJuiceSize{
        SMALL,
        MEDIUM ,
        LARGE
    }
    FreshJuiceSize size;


    public static void main(String []args) {
        tenum juice = new tenum();
        juice.size = tenum.FreshJuiceSize.MEDIUM;
        System.out.println(juice.size);
    }

}
