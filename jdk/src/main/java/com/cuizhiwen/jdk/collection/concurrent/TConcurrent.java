package com.cuizhiwen.jdk.collection.concurrent;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/20 10:39
 */
public class TConcurrent {
    /**
     * 并发集合：
     *      常见的有 ConcurrentHashMap、ConcurrentLinkedQueue、ConcurrentLinkedDeque等 位于java.util.concurrent包下。
     * 普通集合和并发集合
     *      java 中有普通集合、同步（线程安全）的集合、并发集合。
     *          1.普通集合通常性能最高，但是不保证多线程的安全性和并发的可靠性。
     *          2.线程安全集合仅仅是给集合添加了 synchronized 同步锁，严重牺牲了性能，而且对并发的效率就更低了，
     *          3.并发集合则通过复杂的策略不仅保证了多线程的安全又提高的并发时的效
     */
    public static void main(String[] args) {
        ConcurrentHashMap  concurrentHashMap = new ConcurrentHashMap();
    }
}
