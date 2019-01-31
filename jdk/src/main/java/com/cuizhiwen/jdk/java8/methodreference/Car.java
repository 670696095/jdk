package com.cuizhiwen.jdk.java8.methodreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 10:24
 */
public class Car {
    /**
     * 方法引用
     *      1)方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。方法引用提供了一种引用而不执行方法的方式，
     *          它需要由兼容的函数式接口构成的目标类型上下文。计算时，方法引用会创建函数式接口的一个实例。
     *
     *      2)当Lambda表达式中只是执行一个方法调用时，不用Lambda表达式，直接通过方法引用的形式可读性更高一些。方法引用是一种更简洁易懂的Lambda表达式。
     *          注意方法引用是一个Lambda表达式，其中方法引用的操作符是双冒号"::"。
     *
     * 通常与Lambda表达式联合使用，可以直接引用已有Java类或对象的方法。一般有四种不同的方法引用：
     *      1.构造器引用。语法是Class::new，或者更一般的Class< T >::new，要求构造器方法是没有参数；
     *      2.静态方法引用。语法是Class::static_method，要求接受一个Class类型的参数；
     *      3.特定类的任意对象方法引用。它的语法是Class::method。要求方法是没有参数的；
     *      4.特定对象的方法引用，它的语法是instance::method。要求方法接受一个参数，
     *          与3不同的地方在于，3是在列表元素上分别调用方法，而4是在某个对象上调用方法，将列表元素作为参数传入；
     */

    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        //构造器引用：它的语法是Class::new，或者更一般的Class<T>::new实例如下：
        final Car car = Car.create( Car::new );


        final List< Car > cars = Arrays.asList( car );

        //静态方法引用：它的语法是Class::static_method，实例如下：
        cars.forEach( Car::collide );

       // 特定类的任意对象的方法引用：它的语法是Class::method实例如下：
        cars.forEach( Car::repair );

        //特定对象的方法引用：它的语法是instance::method实例如下：
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );

        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);
    }
}
