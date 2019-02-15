package com.cuizhiwen.jdk.common.clone;

/**
 * @author 01418061(cuizhiwen)
 * @Description: 拷贝构造方法实现浅拷贝
 * @date 2019/2/14 17:00
 */
public class CopyConstructor {
    /**
     * 要注意：如果在拷贝构造方法中，对引用数据类型变量逐一开辟新的内存空间，创建新的对象，也可以实现深拷贝。而对于一般的拷贝构造，则一定是浅拷贝。
     * @param args
     */
    public static void main(String[] args) {
        Age a=new Age(20);
        Person p1=new Person(a,"摇头耶稣");
        Person p2=new Person(p1);
        System.out.println("p1是"+p1);
        System.out.println("p2是"+p2);
        //修改p1的各属性值，观察p2的各属性值是否跟随变化
        p1.setName("小傻瓜");
        a.setAge(99);
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);
    }
}
