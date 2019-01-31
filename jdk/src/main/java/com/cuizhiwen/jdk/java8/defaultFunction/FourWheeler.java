package com.cuizhiwen.jdk.java8.defaultFunction;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 14:03
 */
public interface FourWheeler {
    default void print(){
        System.out.println("我是一辆四轮车!");
    }
}
