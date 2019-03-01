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
     *
     * 谈谈 JVM 的内存结构和内存分配
     *      a) Java 内存模型
     *               Java 虚拟机将其管辖的内存大致分三个逻辑部分：方法区(Method Area)、Java 栈和 Java 堆。
     *              1、方法区是静态分配的，编译器将变量绑定在某个存储位置上，而且这些绑定不会在运行时改变。
     *              常数池，源代码中的命名常量、String 常量和 static 变量保存在方法区。
     *              2、Java Stack 是一个逻辑概念，特点是后进先出。一个栈的空间可能是连续的，也可能是不连续的。
     *              最典型的 Stack 应用是方法的调用，Java 虚拟机每调用一次方法就创建一个方法帧（frame），退出该
     *              方法则对应的 方法帧被弹出(pop)。栈中存储的数据也是运行时确定的。
     *              3、Java 堆分配(heap allocation)意味着以随意的顺序，在运行时进行存储空间分配和收回的内存管理模型。
     *              堆中存储的数据常常是大小、数量和生命期在编译时无法确定的。Java 对象的内存总是在 heap 中分配。
     *              我们每天都在写代码，每天都在使用 JVM 的内存。
     *      b) java 内存分配
     *              1、基础数据类型直接在栈空间分配;
     *              2、方法的形式参数，直接在栈空间分配，当方法调用完成后从栈空间回收;
     *              3、引用数据类型，需要用 new 来创建，既在栈空间分配一个地址空间，又在堆空间分配对象的类变量;
     *              4、方法的引用参数，在栈空间分配一个地址空间，并指向堆空间的对象区，当方法调用完后从栈空间回收;
     *              5、局部变量 new 出来时，在栈空间和堆空间中分配空间，当局部变量生命周期结束后，栈空间立刻被回收，堆
     *                  空间区域等待 GC 回收;
     *              6、方法调用时传入的实际参数，先在栈空间分配，在方法调用完成后从栈空间释放;
     *              7、字符串常量在 DATA 区域分配 ，this 在堆空间分配;
     *              8、数组既在栈空间分配数组名称， 又在堆空间分配数组实际的大小！
     *
     * 解释内存中的栈 (stack) 、堆 (heap) 和方法区 (method area) 的用法
     *       通常我们定义一个基本数据类型的变量，一个对象的引用，还有就是函数调用的现场保存都使用 JVM 中的栈空
     *      间；而通过 new 关键字和构造器创建的对象则放在堆空间，堆是垃圾收集器管理的主要区域，由于现在的垃圾收集器
     *      都采用分代收集算法，所以堆空间还可以细分为新生代和老生代，再具体一点可以分为 Eden、Survivor（又可分为
     *      From Survivor 和 To Survivor）、Tenured；方法区和堆都是各个线程共享的内存区域，用于存储已经被 JVM 加载
     *      的类信息、常量、静态变量、JIT 编译器编译后的代码等数据；程序中的字面量（literal）如直接书写的 100、"hello"
     *      和常量都是放在常量池中，常量池是方法区的一部分。栈空间操作起来最快但是栈很小，通常大量的对象都是放在堆
     *      空间，栈和堆的大小都可以通过 JVM 的启动参数来进行调整，栈空间用光了会引发 StackOverflowError，而堆和常
     *      量池空间不足则会引发 OutOfMemoryError。
     *      String str = new String("hello");
     *      上面的语句中变量 str 放在栈上，用 new 创建出来的字符串对象放在堆上，而"hello"这个字面量是放在方法区的
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
