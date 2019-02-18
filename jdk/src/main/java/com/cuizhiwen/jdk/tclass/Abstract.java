package com.cuizhiwen.jdk.tclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 10:42
 */
public abstract class  Abstract {
    /**
     * 抽象类 ：所有的对象都是通过类来描绘的，如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。
     *
     *      1>有抽象方法就要声明为抽象类，抽象类不一定有抽象方法。
     *      2>抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
     *      3>如果一个类包含抽象方法，那么该类必须是抽象类。任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     *         继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。最终，必须有子类实现该抽象方法，
     *         否则，从最初的父类到最终的子类都不能用来实例化对象。
     *      4> 构造方法，类方法（用static修饰的方法）不能声明为抽象方法。
     *声明抽象方法会造成以下两个结果：
     *      如果一个类包含抽象方法，那么该类必须是抽象类。
     *      任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
     *      继承抽象方法的子类必须重写该方法。否则，该子类也必须声明为抽象类。最终，必须有子类实现该抽象方法，否则，从最初的父类到最终的子类都不能用来实例化对象。
     *
     *      注意：abstract 不能跟final共存 不能用synchronized修饰 跟static或private不可修方法，均可修饰内部类。
     *          1. 抽象类不能被实例化，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
     *          2. 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
     *          3. 抽象类中的抽象方法只是声明，不包含方法体，就是不给出方法的具体实现也就是方法的具体功能。
     *          4. 构造方法，类方法（用 static 修饰的方法）不能声明为抽象方法。
     *          5. 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。
     */

    /**
     * 抽象方法
     */
    public abstract  void  fun();

    /**
     * 抽象类不能实例化，但是可以有构造器让子类调用
     */
    public Abstract() {
    }

    /**
     * 抽象类中可以有静态方法
     */
    public static  void testStatic(){

    }
}
