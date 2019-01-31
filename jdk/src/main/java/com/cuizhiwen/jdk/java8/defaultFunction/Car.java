package com.cuizhiwen.jdk.java8.defaultFunction;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 14:05
 */
public class Car implements Vehicle, FourWheeler  {
    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("我是一辆汽车!!!!1");
    }

    public static void main(String[] args) {
        Car car = new Car();
        car.print();
    }
}
