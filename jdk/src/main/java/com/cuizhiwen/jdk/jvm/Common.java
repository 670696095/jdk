package com.cuizhiwen.jdk.jvm;

public class Common {
    /**
     * [Java HotSpot(TM) 64-Bit Server VM (build 25.111-b14, mixed mode)]
     * jvm虚拟机基本结构:
     *      1.类加载子系统
     *      2.方法区
     *      3.java堆
     *      4.直接内存
     *      5.垃圾回收系统
     *      6.java栈（保存着栈帧信息，栈中存储局部变量，方法参数）
     *      7.本地方法栈
     *      8.PC寄存器
     *      9.执行引擎（最核心的组件，JIT即使编译)
     * jvm内存分代策略:（根据内存存活周期)
     *       新生代：新创建的对象
     *       老年代: 多次回收仍然存活下来的对象
     *       永久代：静态属性，类信息，常量 （hotSpot特有概念）1.7以后有永久代趋势。
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
}
