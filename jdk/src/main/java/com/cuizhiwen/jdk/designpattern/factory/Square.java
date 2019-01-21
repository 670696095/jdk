package com.cuizhiwen.jdk.designpattern.factory;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 13:22
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
