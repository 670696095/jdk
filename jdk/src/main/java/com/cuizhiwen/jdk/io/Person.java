package com.cuizhiwen.jdk.io;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 9:37
 */
@Data
class Person implements Serializable {
    private static final long serialVersionUID = -9102017020286042305L;
    private String name; // 姓名
    private int age; // 年龄
    private Car car; // 座驾
    public Person(String name, int age, Car car) {
         this.name = name;
         this.age = age;
        this.car = car;
         }

}
