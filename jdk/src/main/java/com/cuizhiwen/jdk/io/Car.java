package com.cuizhiwen.jdk.io;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 9:39
 */
@Data
class Car implements Serializable {
    private static final long serialVersionUID = -5713945027627603702L;
    private String brand; // 品牌
    private int maxSpeed; // 最高时速
    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
         }
}
