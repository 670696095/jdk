package com.cuizhiwen.jdk.object.mulform;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 16:38
 */
public class Son extends Father {
    /**
     * 多态：同一行为具有多个不同表现形式或者形态的能力
     * 多态存在的三个必要条件:
     *      继承
     *      重写
     *      父类引用指向子类对象
     * 注意:
     *      当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；如果有，再去调用子类的同名方法。
     *      多态的好处：可以使程序有良好的扩展，并可以对所有类的对象进行通用处理。
     * 绑定: 指的是一个方法的调用与方法所在的类(方法主体)关联起来。
     *       对java来说，绑定分为静态绑定和动态绑定；或者叫做前期绑定(final，static，private和构造方法)和后期绑定
     */

    protected String name="儿子属性";




    public static void main(String[] args) {
        /**
         * 向上转型 父类引用指向子类对象
         *        向上转型会丢失子类中与父类不同的方法
         *        目的:动态绑定 编译时类型跟运行时类型不一致
         */
        Father father = new Son("构造后的名字");
        /**
         * 向下转型 子类引用指向父类引用的子类对象
         * 目的：java的泛型编程
         */
        Son son = (Son)father;


        /**
         * 声明的是父类的引用，但是执行的过程中调用的是子类的对象，程序首先寻找子类对象的method方法，
         * 但是没有找到，于是向上转型去父类寻找
         */
        father.method();



        /**
         * 子类的对象(由父类的引用handle)调用到的是父类的成员变量。
         * 重点：所以必须明确，运行时（动态）绑定针对的范畴只是对象的方法。
         */
        System.out.println("调用的成员："+father.name);

        son.method();
        System.out.println(son.name);

    }


    @Override
    public void method() {
        /**
         * super调用父类中的方法,用于指代父类对象的引用
         *          在任意形式的子类构造方法中都会默认调用父类无参构造，如果父类提供了其他形式的构造方法，子类就要使用对应形式的super语句
         */
        //super.method();
        System.out.println("子类方法，对象类型：" + this.getClass());
    }

    /**
     * 父类存在有参构造器，子类构造器必须在第一行显示的调用。
     * @param name
     */
    public Son(String name) {
        super(name);
        this.name = name;
    }


}
