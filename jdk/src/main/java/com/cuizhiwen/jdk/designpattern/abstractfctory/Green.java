package com.cuizhiwen.jdk.designpattern.abstractfctory;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 13:41
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
