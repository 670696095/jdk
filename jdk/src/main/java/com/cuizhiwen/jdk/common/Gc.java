package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 10:50
 */
public class Gc {
    /**
     * 垃圾回收机制
     *           1>系统创建对象，数组等引用类型实体时，在堆内存中分配内存，当不再引用时这块内存就变成了垃圾。
     *           2>只回收内存中的对象，不会回收物理资源(数据库连接 网络IO)
     *
     */
    public static void main(String[] args) {
        System.gc();
        Runtime.getRuntime().gc();
    }
}
