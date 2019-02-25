package com.cuizhiwen.jdk.thread.atomic.atomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/25 17:54
 */
public class Test1 {
    /**
     * ➢AtomicInteger 原子性整型
     *      AtomicInteger，一个提供原子操作的 Integer 的类。在 Java 语言中，++i 和 i++操作并不是线程安全的，
     *      在使用的时候，不可避免的会用到 synchronized 关键字。而 AtomicInteger 则通过一种线程安全的加减操
     *      作接口。
     *
     * AtomicInteger 给我们提供了什么方法：
     * public final int get() //获取当前的值
     * public final int getAndSet(int newValue)//获取当前的值，并设置新的值
     * public final int getAndIncrement()//获取当前的值，并自增
     * public final int getAndDecrement() //获取当前的值，并自减
     * public final int getAndAdd(int delta) //获取当前的值，并加上预期的值
     *
     *
     */

    /**
     * 普通线程
     */
    private volatile int count = 0;

    public synchronized void increment() {
        count++; //若要线程安全执行执行 count++，需要加锁
    }

    public int getCount() {
        return count;
    }

    /**
     *  使用AtomicInteger:
     *      从上面的例子中我们可以看出：使用 AtomicInteger 是非常的安全的.而且因为 AtomicInteger 由硬件提供原子
     *      操作指令实现的。在非激烈竞争的情况下，开销更小，速度更快。AtomicInteger 是使用非阻塞算法来实现并发控制
     *      的。
     */
    private AtomicInteger count1 = new AtomicInteger();

    public void increment1() {
        count1.incrementAndGet();
    }//使用 AtomicInteger 之后，不需要加锁，也可以实现线程安全。
    public int getCount1() {
        return count1.get();
    }
}
