package com.cuizhiwen.jdk.object.mulform;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 16:38
 */
public class Son extends Father {
    /**
     * 多态：同一行为具有多个不同表现形式或者形态的能力
     */
    public static void main(String[] args) {
        /**
         * 向上转型 父类引用指向子类对象
         *        向上转型会丢失子类中与父类不同的方法
         */
        Father father = new Son();
        /**
         * 向下转型 子类引用指向父类引用的子类对象
         */
        Son son = (Son)father;

    }
}
