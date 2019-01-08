package com.cuizhiwen.jdk.tclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 11:13
 */
public interface Interface {
    static final int i =10;
    /**
     * 接口： 更加特殊的抽象类，全是抽象方法，是抽象方法的集合
     *       1> 不可包含 构造器 初始化块 ，可包静态常量（ static 和 final 变量） 内部类 方法（默认方法和类方法）
     *       2> 常量用 public static final  方法用 public abstract
     *       3> 接口可以多实现，一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类
     *       4> 接口是隐式抽象的，不必使用abstract关键字。方法也是隐式抽象的，声明时同样不需要abstract关键字。接口中的方法都是公有的。
     */

    /**
     * java8 以后接口可以有默认方法 和类方法
     */
    default void fun(){}
    static void fun1(){}

}
