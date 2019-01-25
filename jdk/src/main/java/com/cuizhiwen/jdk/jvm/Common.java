package com.cuizhiwen.jdk.jvm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author czw
 */
public class Common<Interger>{
    /**
     * [Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)]
     * jvm虚拟机基本结构:
     *      1.类加载子系统（classLoader）
     *      2.方法区
     *      3.java堆
     *      4.直接内存
     *      5.垃圾回收系统
     *      6.java栈（保存着栈帧信息，栈中存储局部变量，方法参数）
     *      7.本地方法栈（本地方法)
     *      8.PC寄存器
     *      9.执行引擎（最核心的组件，JIT即使编译)
     *      程序计数器
     *      栈帧（Stack Frame）:是用于支持虚拟机进行方法调用和方法执行的数据结构，它是虚拟机运行时数据区中的虚拟机栈（Virtual Machine Stack）的栈元素。
     *      栈帧存储了方法的局部变量表、操作数栈、动态连接和方法返回地址等信息。每一个方法从调用开始至执行完成的过程，都对应着一个栈帧在虚拟机栈里面从入栈到出栈的过程。
     *      每一个栈帧都包括了局部变量表、操作数栈、动态连接、方法返回地址和一些额外的附加信息。在编译程序代码的时候，栈帧中需要多大的局部变量表，多深的操作数栈都已经完全确定了，并
     *      且写入到方法表的Code属性之中，因此一个栈帧需要分配多少内存，不会受到程序运行期变量数据的影响，而仅仅取决于具体的虚拟机实现。
     *      堆外内存
     *      jvm调优调的是什么
     *            减少full gc的频率和时间  system.gc 或者老年代满了就会调用fullGC
     *      不同的jvm的
     *            有不同的实现和算法。
     *      jvm调优工具
     *            jconsole
     *      jvm声明周期
     *            怎样看字节码
     * jvm内存分代策略:（根据内存存活周期)
     *       新生代：新创建的对象
     *       老年代: 多次回收仍然存活下来的对象
     *       永久代：静态属性，类信息，常量 （hotSpot特有概念）1.7以后有取消永久代趋势。
     * 垃圾回收算法:
     *       引用计数算法
     *       复制算法
     *       标记整理
     *       标记清除
     *       分代算法
     * 垃圾收集器:
     *       ScavenGc 次收集
     *       FullGc   全收集
     *
     *       1、Serial(年轻代）
     *       2、ParNew(年轻代）
     *       3、Paralle Scavenge(年轻代）
     *       4、Serial Old(年老代）
     *       5、Parallel Old(年老代）
     *       6、CMS(Concurrent Mark Sweep年老代）
     *       7、G1
     */
    byte [] bytes = new byte[1024*100];
    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin");
       // test();
       //match(6,0);
        /**
         * 产生了几个对象
         *  jvm1.6 之前4个  一个引用对象 一个字符串对象abc  一个字符串对象abcxyz 一个字符串对象xyz
         *  jvm1.8 之后2个对象  一个字符串常量对象  一个引用对象
         */
        //String str = "abc" +"xyz";
        /**
         * jvm1.6 之前直接重新定义一个
         */
        String a = "abc";
        String b = "xyz";
        a= a+ b;
        /**
         *
         * String 和StringBuffer区别
         *      jvm1.8之后底层是被优化成StringBuilder实现的，无非就是线程安全问题。
         *      StringBuffer线程安全的  StringBuilder不是线程安全 需要程序员手动控制
         */

        /**
         * 编译之后泛型被擦除 保证编译的安全性。
         * 局部变量的泛型会被擦除
         * 全局变量的泛型不会被擦除
         */
        Map<String,String> hashMap = new HashMap<>();
        System.out.println(Common.class.getTypeParameters()[0]);
    }
    public static void test() throws InterruptedException {
        Thread.sleep(5000);
        List list = new ArrayList();
        System.out.println("******start");
        for (int i = 0; i <2000 ; i++) {
            Thread.sleep(100);
            list.add(new Common());
        }
    }

    public static  int match(int a ,int b){
        /**
         * 什么时候finally不会被执行  jvm声明周期结束
         */
        try{
            System.out.println(a/b);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(0);
        }finally {
            System.out.println("end");
        }
        return 0;
    }
}
