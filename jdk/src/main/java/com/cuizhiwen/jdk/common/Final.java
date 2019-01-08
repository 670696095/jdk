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
     *
     * final修饰基本数据类型变量的值不能改变
     * final修饰引用类型，地址值不能改变，元素值可以改变
     * final修饰成员变量要求在创建对象之前初始化
     * final和static共同修饰成员变量（静态常量）要求在类加载之前进行初始化
     */
    public static void main(String[] args) {
       final String str = "123";

    }
}
