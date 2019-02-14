package com.cuizhiwen.jdk.common.clone;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/14 11:23
 */
@Data
public class Person  implements Cloneable{
    //两个属性值：分别代表值传递和引用传递
    private Age age;
    private String name;

    public Person(Age age,String name) {
        this.age=age;
        this.name=name;
    }
    //拷贝构造方法
    public Person(Person p) {
        this.name=p.name;
        this.age=p.age;
    }


}
