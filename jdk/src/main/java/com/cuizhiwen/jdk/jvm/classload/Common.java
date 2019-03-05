package com.cuizhiwen.jdk.jvm.classload;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/4 17:17
 */
public class Common {
    /**
     * 类什么时候被初始化？
     * 1）创建类的实例，也就是 new 一个对象
     * 2）访问某个类或接口的静态变量，或者对该静态变量赋值
     * 3）调用类的静态方法
     * 4）反射（Class.forName("com.lyj.load")）
     * 5）初始化一个类的子类（会首先初始化子类的父类）
     * 6）JVM 启动时标明的启动类，即文件名和类名相同的那个类
     *      只有这 6 中情况才会导致类的类的初始化。
     *      类的初始化步骤：
     *      1）如果这个类还没有被加载和链接，那先进行加载和链接
     *      2）假如这个类存在直接父类，并且这个类还没有被初始化（注意：在一个类加载器中，类只能初始化一次），那就初始化直接的父类（不适用于接口）
     *      3)加入类中存在初始化语句（如 static 变量和 static 块），那就依次执行这些初始化语句
     */
    public int x;
    public static void main(String[] args){
        Object o=new Object(){
            @Override
            public boolean equals(Object obj){
                return true;
            }
        };
        System.out.println(o.equals("FRED"));
    }


}
