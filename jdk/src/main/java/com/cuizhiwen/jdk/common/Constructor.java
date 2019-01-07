package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/7 10:58
 */
public class Constructor {
    /**
     * 构造器:
     * 1>可以重载，但是不可以重写，父类构造器带有参数，则子类必须显示调用（super）。
     * 2>一个类没有重写构造器，系统就会为该类提供默认构造器。
     *
     * this可以调用另一个重载的构造器，并且放在构造器执行体第一条。
     */
    public static void main(String[] args) {
        Constructor c = new Constructor(1);
    }
    public Constructor() {
        System.out.println("我是默认构造器");
    }
    public Constructor(int a) {
        this("this调用的");
    }
    public Constructor(String string) {
        System.out.println(string+"构造器");
    }
}
