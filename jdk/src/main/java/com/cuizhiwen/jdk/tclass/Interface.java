package com.cuizhiwen.jdk.tclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 11:13
 */
public interface Interface {
    static final int i =10;
    /**
     * 接口：
     *       接口（英文：Interface），在JAVA编程语言中是一个抽象类型，是抽象方法的集合，接口通常以interface来声明。
     *       一个类通过继承接口的方式，从而来继承接口的抽象方法。它是更加特殊的抽象类，全是抽象方法，是抽象方法的集合
     * 注意:
     *       1）接口并不是类，编写接口的方式和类很相似，但是它们属于不同的概念。类描述对象的属性和方法。接口则包含类要实现的方法。
     *       除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。
     *       2）接口无法被实例化，但是可以被实现。一个实现接口的类，必须实现接口内所描述的所有方法，否则就必须声明为抽象类。
     *       3）另外，在 Java 中，接口类型可用来声明一个变量，他们可以成为一个空指针，或是被绑定在一个以此接口实现的对象。
     *
     *       1> 接口不可包含 构造器 初始化块 ，可包静态常量（ static 和 final 变量） 内部类 方法（默认方法和类方法）
     *       2> 常量用 public static final  方法用 public abstract
     *       3> 接口是隐式抽象的，不必使用abstract关键字。方法也是隐式抽象的，声明时同样不需要abstract关键字。接口中的方法都是公有的。
     *       4> 接口中不能含有静态代码块以及静态方法(用 static 修饰的方法)，而抽象类是可以有静态代码块和静态方法
     * 重写接口中声明的方法时，需要注意以下规则：
     *      类在实现接口的方法时，不能抛出强制性异常，只能在接口中，或者继承接口的抽象类中抛出该强制性异常。
     *      类在重写方法时要保持一致的方法名，并且应该保持相同或者相兼容的返回值类型。
     *      如果实现接口的类是抽象类，那么就没必要实现该接口的方法。
     *      在实现接口的时候，也要注意一些规则：
     *      一个类可以同时实现多个接口。
     *      一个类只能继承一个类，但是能实现多个接口。
     *      一个接口能继承另一个接口，这和类之间的继承比较相似。
     * 接口的多继承:
     *      在Java中，类的多继承是不合法，但接口允许多继承。
     *      在接口的多继承中extends关键字只需要使用一次，在其后跟着继承接口.
     * 标记接口:
     *      最常用的继承接口是没有包含任何方法的接口。
     *      标记接口是没有任何方法和属性的接口.它仅仅表明它的类属于一个特定的类型,供其他代码来测试允许做一些事情。
     * 标记接口作用：
     *      简单形象的说就是给某个对象打个标（盖个戳），使对象拥有某个或某些特权。
     *      没有任何方法的接口被称为标记接口。标记接口主要用于以下两种目的：
     *          建立一个公共的父接口：
     *              正如EventListener接口，这是由几十个其他接口扩展的Java API，你可以使用一个标记接口来建立一组接口的父接口。例如：当一个接口继承了EventListener接口，Java虚拟机(JVM)就知道该接口将要被用于一个事件的代理方案。
     *
     *          向一个类添加数据类型：
     *              这种情况是标记接口最初的目的，实现标记接口的类不需要定义任何接口方法(因为标记接口根本就没有方法)，但是该类通过多态性变成一个接口类型。
     * Lambda表达式---
     *          用于实现接口中的抽象方法 使用的前提是接口中有且仅有一个抽象方法，这样的接口是函数式接口
     */

    /**
     * java8 以后接口可以有默认方法 和类方法
     */
    default void fun(){}
    static void fun1(){
        System.out.println("我是接口中的静态方法");
    }

}
