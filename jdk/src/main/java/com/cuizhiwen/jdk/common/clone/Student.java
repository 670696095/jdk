package com.cuizhiwen.jdk.common.clone;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/15 9:16
 */
@Data
public class Student implements Cloneable ,Serializable {
    private String name;
    private Age aage;
    private int length;

    public Student(String name,Age a,int length) {
        this.name=name;
        this.aage=a;
        this.length=length;
    }
   /* //重写Object类的clone方法
    @Override
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法，返回一个Object实例
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }*/
   @Override
    //重写Object类的clone方法
    public Object clone() {
        Object obj=null;
        //调用Object类的clone方法——浅拷贝
        try {
            obj= super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //调用Age类的clone方法进行深拷贝
        //先将obj转化为学生类实例
        Student stu=(Student)obj;
        //学生类实例的Age对象属性，调用其clone方法进行拷贝
        stu.aage=(Age)stu.getAage().clone();
        return obj;
    }
}
