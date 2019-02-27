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
     * unsafe :
     *      是 java 提供的获得对对象内存地址访问的类，，它的作用就是在更新操作时提供“比较并替换”的作用。实际上就是 AtomicInteger 中的一个工具。
     *      valueOffset 是用来记录 value 本身在内存的便宜地址的，这个记录，也主要是为了在更新操作在内存中找到 value 的位置，方便比较。
     *      注意：value 是用来存储整数的时间变量，这里被声明为 volatile，就是为了保证在更新操作时，当前线程可以拿
     *      到 value 最新的值（并发环境下，value 可能已经被其他线程更新了）。
     *      优点:最大的好处就是可以避免多线程的优先级倒置和死锁情况的发生，提升在高并发处理下的性能。
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
     * 使用AtomicInteger:
     * 从上面的例子中我们可以看出：使用 AtomicInteger 是非常的安全的.而且因为 AtomicInteger 由硬件提供原子
     * 操作指令实现的。在非激烈竞争的情况下，开销更小，速度更快。AtomicInteger 是使用非阻塞算法来实现并发控制
     * 的。
     */
    private AtomicInteger count1 = new AtomicInteger();

    public void increment1() {
        count1.incrementAndGet();
    }//使用 AtomicInteger 之后，不需要加锁，也可以实现线程安全。

    public int getCount1() {
        return count1.get();
    }


    /**
     * 首先新建一个初始值为 123 的 AtomicInteger 实例。然后将 AtomicInteger 与期望值 123 进行比较，
     * 如果相等，将 AtomicInteger 的值更新为 234。
     * @param args
     */
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(123);
        int expectedValue = 123;
        int newValue = 234;
        atomicInteger.compareAndSet(expectedValue, newValue);
    }

}
