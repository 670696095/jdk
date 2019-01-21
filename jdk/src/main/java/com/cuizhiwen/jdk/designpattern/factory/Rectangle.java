package com.cuizhiwen.jdk.designpattern.factory;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 13:21
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
