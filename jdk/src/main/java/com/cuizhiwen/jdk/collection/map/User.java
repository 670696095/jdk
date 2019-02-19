package com.cuizhiwen.jdk.collection.map;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 10:08
 */
@Data
public class User {
    private String name;
    private int  age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
