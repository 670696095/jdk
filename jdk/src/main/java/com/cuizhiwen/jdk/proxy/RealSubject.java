package com.cuizhiwen.jdk.proxy;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/15 11:01
 */
public class RealSubject implements Subject {
    @Override
    public void rent()
    {
        System.out.println("I want to rent my house");
    }

    @Override
    public void hello(String str)
    {
        System.out.println("hello: " + str);
    }
}
