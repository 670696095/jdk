package com.cuizhiwen.jdk.thread.concurrent;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 10:03
 */
public class Common {
    /**
     *  Java 的线程并发库介绍Java5 的多线程并有两个大发库在 java.util.concurrent 包及子包中，子包主要的包有以下两个
     *      1) java.util.concurrent 包(多线程并发库)
     *          ➢ java.util.concurrent 包含许多线程安全、测试良好、高性能的并发构建块。不客气地说，创建ava.util.concurrent 的目的就是要实现
     *          Collection 框架对数据结构所执行的并发操作。通过提供一组可靠的、高性能并发构建块，开发人员可以提高并发类的线程安全、可伸缩性、性能、可读性和可靠性，
     *          ➢如果一些类名看起来相似，可能是因为 java.util.concurrent 中的许多概念源自 Doug Lea 的util.concurrent 库。
     *      2) java.util.concurrent.atomic 包 (多线程的原子性操作提供的工具类)
     *          ➢查看 atomic 包文档页下面的介绍，它可以对多线程的基本数据、数组中的基本数据和对象中的基本数据进行多线程的操作（AtomicInteger、AtomicIntegerArray、AtomicIntegerFieldUpDater…）
     *          ➢通过如下两个方法快速理解 atomic 包的意义：
     *               AtomicInteger 类的 boolean compareAndSet(expectedValue, updateValue);
     *               AtomicIntegerArray 类的 int addAndGet(int i, int delta)
     *          ➢顺带解释 volatile 类型的作用，需要查看 java 语言规范。
     *               volatile 修饰的变量，线程在每次使用变量的时候，都会读取变量修改后的最的值。（具有可见性）
     *               volatile 没有原子性。
     *      3) java.util.concurrent.lock 包 (多线程的锁机制)
     *          为锁和等待条件提供一个框架的接口和类，它不同于内置同步和监视器。该框架允许更灵活地使用锁和条件。
     *              本包下有三大接口，下面简单介绍下：
     *              ➢Lock 接口：支持那些语义不同（重入、公平等）的锁规则，可以在非阻塞式结构的上下文（包括 handover-hand 和锁重排算法）中使用这些规则。主要的实现是 ReentrantLock。
     *              ➢ReadWriteLock 接口：以类似方式定义了一些读取者可以共享而写入者独占的锁。此包只提供了一个实现，即 ReentrantReadWriteLock，因为它适用于大部分的标准用法上下文。但程序员可以创建自己的、适用于非标准要求的实现。
     *              ➢Condition 接口：描述了可能会与锁有关联的条件变量。这些变量在用法上与使用 Object.wait 访问的隐式监视器类似，但提供了更强大的功能。需要特别指出的是，单个 Lock 可能与多个 Condition 对象关联。为了避免兼容性问题，Condition 方法的名称与对应的 Object 版本中的不
     */
}
