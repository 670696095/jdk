package com.cuizhiwen.jdk.tclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/1 9:26
 */
public class Outer {
     class Inner {
    }

    public static void foo() {
        new Outer().new Inner();
    }

    public void bar() {
        new Inner();
    }

    public static void main(String[] args) {
        new Outer().new Inner();
    }
}
