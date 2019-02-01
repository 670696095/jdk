package com.cuizhiwen.jdk.designpattern.mvc;

import lombok.Data;

import java.util.Date;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/1 9:38
 */
@Data
public class Pet {
    private Integer id;
    private Integer ownerId;    //主人ID
    private Integer storeId;    //商店ID
    private String name;    //姓名
    private String typeName;    //类型
    private int health;    //健康值
    private int love;    //爱心值
    private Date birthday;    //生日

    public Pet(Integer id, Integer ownerId, Integer storeId, String name, String typeName, int health, int love, Date birthday) {
        this.id = id;
        this.ownerId = ownerId;
        this.storeId = storeId;
        this.name = name;
        this.typeName = typeName;
        this.health = health;
        this.love = love;
        this.birthday = birthday;
    }
}
