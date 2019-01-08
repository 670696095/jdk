package com.cuizhiwen.jdk.tclass.innerclass;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 13:22
 */
public class StaticClass {
    /**
     * 静态内部类：
     *        1> 静态内部类不能直接访问外部类的非静态成员，但可以通过 new 外部类().成员 的方式访问。
     *
     * 　　   2> 如果外部类的静态成员与内部类的成员名称相同，可通过“类名.静态成员”访问外部类的静态成员；如果外部类的静态成员与内部类的成员名称不相同，则可通过“成员名”直接调用外部类的静态成员。
     *
     * 　　   3> 创建静态内部类的对象时，不需要外部类的对象，可以直接创建 内部类 对象名= new 内部类();
     */
    private  int  a = 99; //外部类私有属性
    static  int b =1; //外部类静态属性

    public static class  inner{
        int b = 2;
        public void test(){
            System.out.println("访问外部类的b: "+StaticClass.b);
            System.out.println("访问内部类的b: "+b);
        }

    }

    public static void main(String[] args) {
        inner in = new inner();
        in.test();
    }
}
