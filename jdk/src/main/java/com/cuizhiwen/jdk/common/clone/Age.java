package com.cuizhiwen.jdk.common.clone;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/14 17:02
 */
@Data
public class Age implements Cloneable,Serializable {
    private int age;
    public Age(int age) {
        this.age=age;
    }
    @Override
    //重写Object的clone方法
    public Object clone() {
        Object obj=null;
        try {
            obj=super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

}
