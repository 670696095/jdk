package com.cuizhiwen.jdk.object.mulform;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 16:37
 */
public class Father {
    /**
     * 多态性：
     *      多态性是指允许不同子类型的对象对同一消息作出不同的响应。简单的说就是用同样的对象引用调
     *      用同样的方法但是做了不同的事情。
     * 多态性分为
     *      1.编译时多态性 2.运行时的多态性。
     *       如果将对象的方法视为对象向外界提供的服务，那么运行时的多态性可以解释为：当 A 系统访问 B 系统提供的服务时，
     *       B 系统有多种提供服务的方式，但一切对 A 系统来说都是透明的。
     *        A.方法重载（overload）实现的是编译时的多态性（也称为前绑定）
     *        B.方法重写（override）实现的是运行时的多态性（也称为后绑定）。
     *              运行时的多态是面向对象最精髓的东西，要实现多态需要做两件事：
     *                  1. 方法重写（子类继承父类并重写父类中已有的或抽象的方法）；
     *                  2. 对象造型（用父类型引用引用子类型对象，这样同样的引用调用同样的方法就会根据子类对象的不同而表现出不同的行为）
     */
    protected String name="父亲属性";
    public void method() {
        System.out.println("父类方法，对象类型：" + this.getClass());
    }

    public Father(String name) {
        this.name = name;
    }
}
