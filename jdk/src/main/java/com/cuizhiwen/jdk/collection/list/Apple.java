package com.cuizhiwen.jdk.collection.list;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 10:24
 */
@Data
public class Apple {
    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    private int weight;
    private String color;

}
