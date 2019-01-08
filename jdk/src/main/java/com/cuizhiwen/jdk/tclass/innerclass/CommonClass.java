package com.cuizhiwen.jdk.tclass.innerclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 13:08
 */
public class CommonClass {
    /**
     * 内部类： 成员内部类  静态内部类  方法内部类  匿名内部类  内容内部类
     *      1>内部严重破坏了良好的代码结构,
     *      但是内部类可以随意使用外部类的成员变量（包括私有）而不用生成外部类的对象，这也是内部类的唯一优点
     *      java通过内部类加上接口，可以很好的实现多继承的效果
     *      外部类不能直接使用内部类的成员和方法。
     *      2>如果外部类和内部类具有相同的成员变量或方法，内部类默认访问自己的成员变量或方法，如果要访问外部类的成员变量，可以使用 this 关键字
     *
     */

    private int age = 12;

    /**
     * 成员内部类
     */
    class Outer {
        private int age = 13;
        public void print() {
            int age = 14;
            System.out.println("局部变量：" + age);
            System.out.println("内部类变量：" + this.age);
            System.out.println("外部类变量：" + CommonClass.this.age);
        }
    }


    /**
     * 私有内部类
     */
    class Out1 {
        private int age = 12;

        private class In {
            public void print() {
                System.out.println(age);
            }
        }
        public void outPrint() {
            new In().print();
        }
    }




}
