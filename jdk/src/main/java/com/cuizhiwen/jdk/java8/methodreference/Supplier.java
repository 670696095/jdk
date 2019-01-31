package com.cuizhiwen.jdk.java8.methodreference;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 10:24
 */
@FunctionalInterface
public interface Supplier<T> {
    /**
     * Java 8为函数式接口引入了一个新注解@FunctionalInterface，
     *      主要用于编译级错误检查，加上该注解，当你写的接口不符合函数式接口定义的时候，编译器会报错。
     * 函数式接口里允许定义默认方法
     *      函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义
     * 函数式接口里允许定义静态方法
     *       函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
     * 函数式接口里允许定义 java.lang.Object 里的 public 方法
     *      函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，不被当成是抽象方法（虽然它们是抽象方法）；
     *      因为任何一个函数式接口的实现，默认都继承了 Object 类，包含了来自 java.lang.Object 里对这些抽象方法的实现；
     * @return
     */
    T get();

    /**
     * 默认方法
     */
    default void doSomeMoreWork1()
    {
        // Method body
    }

    /**
     * 静态方法
     */
    static void printHello(){
        System.out.println("Hello");
    }

    /**
     * Object的方法
     */
    @Override
    boolean equals(Object obj);
}
