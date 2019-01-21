package com.cuizhiwen.jdk.designpattern.abstractfctory;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 13:22
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
