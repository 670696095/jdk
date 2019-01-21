package com.cuizhiwen.jdk.designpattern.abstractfctory;

public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
