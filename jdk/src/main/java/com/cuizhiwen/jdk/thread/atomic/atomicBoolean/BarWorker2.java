package com.cuizhiwen.jdk.thread.atomic.atomicBoolean;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/25 17:41
 */
public class BarWorker2 implements Runnable {
    /**
     * ➢AtomicBoolean 原子性布尔
     *      AtomicBoolean 是 java.util.concurrent.atomic 包下的原子变量，这个包里面提供了一组原子类。其基本的特性
     *      就是在多线程环境下，当有多个线程同时执行这些类的实例包含的方法时，具有排他性，即当某个线程进入方法，执行
     *      其中的指令时，不会被其他线程打断，而别的线程就像自旋锁一样，一直等到该方法执行完成，才由 JVM 从等待队列
     *      中选择一个另一个线程进入，这只是一种逻辑上的理解。实际上是借助硬件的相关指令来实现的，不会阻塞线程(或者说只是在硬件级别上阻塞了)。
     *
     *       AtomicBoolean，在这个 Boolean 值的变化的时候不允许在之间插入，保持操作的原子性。
     *          下面将解释重点方法并举例：
     *              boolean compareAndSet(expectedValue, updateValue)，这个方法主要两个作用:
     *                  1. 比较 AtomicBoolean 和 expect 的值，如果一致，执行方法内的语句。其实就是一个 if 语句
     *                  2. 把 AtomicBoolean 的值设成 update,比较最要的是这两件事是一气呵成的，这连个动作之间不会被
     *                  打断，任何内部或者外部的语句都不可能在两个动作之间运行。为多线程的控制提供了解决的方案
     */
    //静态变量使用 AtomicBoolean 进行操作
    private static AtomicBoolean exists = new AtomicBoolean(false);
    private String name;
    public BarWorker2(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        if (exists.compareAndSet(false, true)) {
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists.set(false);
        } else {
            System.out.println(name + " give up");
        }
    }
    public static void main(String[] args) {
        BarWorker2 bar1 = new BarWorker2("bar1");
        BarWorker2 bar2 = new BarWorker2("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();
    }
}