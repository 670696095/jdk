package com.cuizhiwen.jdk.tclass.innerclass;

import com.cuizhiwen.jdk.tclass.Abstract;
import com.cuizhiwen.jdk.tclass.Interface;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 13:39
 */
public class InnerClass {
    /**
     * 匿名内部类 ：匿名类是不能有名称的类，所以没办法引用他们。必须在创建时，作为new语句的一部分来声明他们。
     *           前提条件：必须继承一个父类或实现一个接口。 new <类或接口> <类的主体>
     *           1>他对一个给定的类进行扩展，或实现一个给定的接口
     *           2>假如要执行的任务需要一个对象，但却不值得创建全新的对象（原因可能 是所需的类过于简单，或是由于他只在一个方法内部使用），匿名类就显得很有用
     *
     *          1、使用匿名内部类时，我们必须是继承一个类或者实现一个接口，但是两者不可兼得，同时也只能继承一个类或者实现一个接口。
     *
     *          2、匿名内部类中是不能定义构造函数的。只能同初始化块
     *
     *          3、匿名内部类中不能存在任何的静态成员变量和静态方法。
     *
     *          4、匿名内部类为局部内部类（即方法内部类），所以局部内部类的所有限制同样对匿名内部类生效。
     *
     *          5、匿名内部类不能是抽象的，它必须要实现继承的类或者实现的接口的所有抽象方法。
     *
     *          重点: 当所在的方法的形参需要被内部类里面使用时，该形参必须为final。
     *
     *                如果定义了一个匿名内部类，并且希望它使用一个其外部定义的参数，那么编译器会要求该参数引用是final的。
     *
     *
     *
     */
    public static void main(String[] args) {
        Abstract a = new Abstract() {
            @Override
            public void fun() {
                System.out.println("抽象方法的匿名内部类\n");
            }
        };
        a.fun();

        Interface i = new Interface() {
            @Override
            public void fun() {
                System.out.println("接口的匿名内部类");
            }
        };
        i.fun();
    }



    public InnerClass getInnerClass(final int age,final String name){
        return new InnerClass() {
            int age_ ;
            String name_;
            //构造代码块完成初始化工作
            {
                if(0 < age && age < 200){
                    age_ = age;
                    name_ = name;
                }
            }
            public String getName() {
                return name_;
            }

            public int getAge() {
                return age_;
            }
        };
    }
}
