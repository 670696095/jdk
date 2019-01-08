package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 9:52
 */
public class Final {
    /**
     * final可以修饰成员变量（要显示初始化）  局部变量（若无默认值可赋值一次） 形参 引用类型（不可变引用可变内容）
     * final修饰的类不能被继承。String Math等
     * final修饰的方法不可被重写。可以重载
     */
    public static void main(String[] args) {
       final String str = "123";

    }
}
