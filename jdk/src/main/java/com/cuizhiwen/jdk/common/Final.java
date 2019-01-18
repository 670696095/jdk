package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 9:52
 */
public class Final {
    /**
     * final可以修饰成员变量（要显示初始化）
     *            局部变量（若无默认值可赋值一次）
     *            形参
     *            引用类型（引用不可变，引用对象内容不可变）
     *
     * final修饰的类不能被继承。String Math等
     * final修饰的方法不可被重写。可以重载。比一般方法快
     *
     * final修饰基本数据类型变量的值不能改变
     * final修饰引用类型，地址值不能改变，元素值可以改变
     * final修饰成员变量要求在创建对象之前初始化
     * final和static共同修饰成员变量（静态常量）要求在类加载之前进行初始化
     *
     *
     * 使用final的好处
     *      1>提高性能 jvm和java应用都会缓存final变量
     *      2>final变量可以安全的而在多线程环境下共享，不需要额外同步开销。
     *      3>使用final关键字 jvm会对方法，变量，类进行优化。
     */
    public static void main(String[] args) {
        String a = "xiaocui2";
        final String b = "xiaocui";
        String d = "xiaocui";
        String c = b+2;
        String e = d+2;
        System.out.println(a == c);
        System.out.println(a == e);
    }
}
