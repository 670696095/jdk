package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 15:45
 */
public class Client {
    /**
     * 解决方法：
     * 1.调整申请锁的范围。
     * 2.调整申请锁的顺序。
     */
    public static final String obj1 = "obj1";
    public static final String obj2 = "obj2";

    public static void main(String[] ars) {
        new DeadLockA().start();
        new DeadLockB().start();
    }
}
