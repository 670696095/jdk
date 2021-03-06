package com.cuizhiwen.jdk.jvm.classload;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 13:34
 */
public class ClassLoad {
    /**
     * 类加载:
     *       类加载，连接，初始化
     *       系统可能第一次使用某个类时加载某类，也可以预加载某类。
     *
     * jvm进程终止:
     *          1.程序运行结束
     *          2.使用system.exit或者system.getRuntime.exit
     *          3.程序遇到未捕捉异常或错误而结束
     *          4.程序所在平台强制结束jvm
     * 类加载:
     *          将类的class文件读取到内存中，创建class对象，程序使用任何类都要创建java.lang.class对象
     *          三个类加载器:
     *                    BootStrap 跟类加载器 加载java核心类
     *                    Extension 扩展类加载器 加载jre扩展目录中jar包
     *                    System    系统类加载器 classPath环境变量所指的jar或类路径。
     * 类加载器加载class文件需要经过八分步骤：
     *          1>检测此class是否加载过（既缓存器是否有此class） 有则直接进入 8>
     *          2>若父类加载器不存在，(要么父类是跟类加载器，要么本身就是类加载器 ) 则直接进入8> 否则进入3>
     *          3>请求使用父类加载器 载入目标 成功进入8> 否则进入5>
     *          4>请求使用根加载器载入目标 成功进入8>  否则进入7>
     *          5>当前类加载器尝试寻找class文件 找到进入6> 否则进入7>
     *          6> 从文件中载入class 成功进入8>
     *          7>抛出classNotFound Exception
     *          8>返回对象的class文件
     * 类初始化:
     *          由java虚拟机负责类的初始化，主要对类变量初始化
     *                                  1.声明类变量时指定初始化
     *                                  2.使用静态初始化块
     * 类初始化时机:
     *          1>创建类的实例 new 反射 序列化
     *          2>访问某个类 类方法
     *          3>访问某个类或接口的类变量 或赋值
     *          4>使用反射强制创建类或接口对应的class对象 class.forName
     *          5>初始化某个类的子类
     *          6>使用java.exe运行某个主类
     *          若一个类变量用final修饰，且值在编译时确定，其他地方使用时相当于常量，该类不会被初始化。
     *
     * 为什么修改了class文件需要重启jvm
     *          因为内存中还是你原来的class字节码，并没有把新的class加载到内存中，类只有被使用到才会被加载到内存，而且只加载一次，
     *          若你原class字节码已经在内存中存在，那么就会直接被使用，若不存在，才会通过三种类加载器逐级加载，直至加载成功。
     *
     * 注: 不论java程序多么复杂，启动多少线程，他们都处于java虚拟机进程中，同一jvm所有线程变量处于同一进程里，都为jvm进程内存区。
     *
     */
}
