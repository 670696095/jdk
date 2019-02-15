package com.cuizhiwen.jdk.common.clone;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/15 9:15
 */
public class ShallowCopy {
    /**
     * 注意：
     *      1、Object类虽然有这个方法，但是这个方法是受保护的（被protected修饰），所以我们无法直接使用。
     *      2、使用clone方法的类必须实现Cloneable接口，否则会抛出异常CloneNotSupportedException。对于这两点，
     *          我们的解决方法是，在要使用clone方法的类中重写clone()方法，通过super.clone()调用Object类中的原clone方法。
     * @param args
     */
    public static void main(String[] args) {
        Age a=new Age(20);
        Student stu1=new Student("摇头耶稣",a,175);

        //通过调用重写后的clone方法进行浅拷贝
        Student stu2=(Student)stu1.clone();
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());

        //尝试修改stu1中的各属性，观察stu2的属性有没有变化
        stu1.setName("大傻子");
        //改变age这个引用类型的成员变量的值
        a.setAge(99);
        //stu1.setaAge(new Age(99));    使用这种方式修改age属性值的话，stu2是不会跟着改变的。因为创建了一个新的Age类对象而不是改变原对象的实例值
        stu1.setLength(216);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }
}
