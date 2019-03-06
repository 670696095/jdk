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
     *
     * JDK中提供了三个ClassLoader，根据层级从高到低为：
     *  Bootstrap ClassLoader，主要加载JVM自身工作需要的类。
     *  Extension ClassLoader，主要加载%JAVA_HOME%\lib\ext目录下的库类。
     *  Application ClassLoader，主要加载Classpath指定的库类，一般情况下这是程序中的默认类加载器，也是ClassLoader.getSystemClassLoader() 的返回值。（这里的Classpath默认指的是环境变量中配置的Classpath，但是可以在执行Java命令的时候使用-cp 参数来修改当前程序使用的Classpath）
     * JVM加载类的实现方式，我们称为 双亲委托模型：
     *
     * 如果一个类加载器收到了类加载的请求，他首先不会自己去尝试加载这个类，而是把这个请求委托给自己的父加载器，每一层的类加载器都是如此，
     * 因此所有的类加载请求最终都应该传送到顶层的Bootstrap ClassLoader中，只有当父加载器反馈自己无法完成加载请求时，子加载器才会尝试自己加载。
     * 双亲委托模型的重要用途是为了解决类载入过程中的安全性问题。
     * 假设有一个开发者自己编写了一个名为Java.lang.Object的类，想借此欺骗JVM。现在他要使用自定义ClassLoader来加载自己编写的java.lang.Object类。
     * 然而幸运的是，双亲委托模型不会让他成功。因为JVM会优先在Bootstrap ClassLoader的路径下找到java.lang.Object类，并载入它
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
