package com.cuizhiwen.jdk.thread.atomic.atomicInteger;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 9:31
 */
public class TAtomicIntegerArray {
    /**
     * ➢AtomicIntegerArray 原子性整型数组
     *          java.util.concurrent.atomic.AtomicIntegerArray 类提供了可以以原子方式读取和写入的底层 int 数组的操作，还包含高级原子操作。
     *          AtomicIntegerArray 支持对底层 int 数组变量的原子操作。 它具有获取和设置方法，如在变量上的读取和写入。
     *          也就是说，一个集合与同一变量上的任何后续 get 相关联。 原子 compareAndSet 方法也具有这些内存一致性功能。
     *          AtomicIntegerArray 本质上是对 int[]类型的封装。使用 Unsafe 类通过 CAS 的方式控制 int[]在多线程下的安全性。它提供了以下几个核心 AP
     */
    static AtomicIntegerArray arr = new AtomicIntegerArray(10);
    public static class AddThread implements Runnable{
        @Override
        public void run(){
            for(int k=0;k<10000;k++) {
                arr.getAndIncrement(k % arr.length());
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {

        Thread[] ts=new Thread[10];
        for(int k=0;k<10;k++){
            ts[k]=new Thread(new AddThread());
        }
        for(int k=0;k<10;k++){ts[k].start();}
        for(int k=0;k<10;k++){ts[k].join();}
        System.out.println(arr);
    }
}

