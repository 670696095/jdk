package com.cuizhiwen.jdk.tclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 10:28
 */
public class Class {
    /**
     * java类中  只可以有   成员变量     成员方法    构造器     初始化块       内部类（接口，枚举）
     *                   （类变量）  （类方法）           （静态初始化块）
     */


    /**
     * 成员变量
     */
    private  String str;

    /**
     * 静态成员
     */
    private  static  String staString;

    /**
     * 初始化块
     */
    {
        int i = 10;
    }

    static {
        int j = 5;
    }

    /**
     * 内部类
     */
    private class InnerClass extends Class{

        public InnerClass(String str) {
            super(str);
        }
    }

    /**
     * 构造器
     * @param str
     */
    public Class(String str) {
        this.str = str;
    }
}
