package com.cuizhiwen.jdk.thread.concurrent.b;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 14:43
 */
public class TBlockingQueue {
    /**
     *  并发队列-阻塞队列
     *      常用的并发队列有阻塞队列和非阻塞队列，前者使用锁实现，后者则使用 CAS 非阻塞算法实现。
     *  阻塞队列:
     *      阻塞队列 (BlockingQueue)是 Java util.concurrent 包下重要的数据结构，BlockingQueue 提供了线程安全的队
     *      列访问方式：当阻塞队列进行插入数据时，如果队列已满，线程将会阻塞等待直到队列非满；从阻塞队列取数据时，如
     *      果队列已空，线程将会阻塞等待直到队列非空。并发包下很多高级同步类的实现都是基于 BlockingQueue 实现的。
     *  ➢BlockingQueue 阻塞队列
     *      BlockingQueue 通常用于一个线程生产对象，而另外一个线程消费这些对象的场景。
     *      一个线程往里边放，另外一个线程从里边取的一个 BlockingQueue。
     *      一个线程将会持续生产新对象并将其插入到队列之中，直到队列达到它所能容纳的临界点。也就是说，它是有限
     *      的。如果该阻塞队列到达了其临界点，负责生产的线程将会在往里边插入新对象时发生阻塞。它会一直处于阻塞之中，
     *      直到负责消费的线程从队列中拿走一个对象。负责消费的线程将会一直从该阻塞队列中拿出对象。如果消费线程尝试
     *      去从一个空的队列中提取对象的话，这个消费线程将会处于阻塞之中，直到一个生产线程把一个对象丢进队列。
     *  BlockingQueue 的方法:
     *      BlockingQueue 具有 4 组不同的方法用于插入、移除以及对队列中的元素进行检查。如果请求的操作不能得到
     *                      立即执行的话，每个方法的表现也不同。这些方法如下：
     *     阻塞队列提供了四种处理方法:
     *
     *          四组不同的行为方式解释：
     *              抛异常：如果试图的操作无法立即执行，抛一个异常。
     *              特定值：如果试图的操作无法立即执行，返回一个特定的值(常常是 true / false)。
     *              阻塞：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行。
     *              超时：如果试图的操作无法立即执行，该方法调用将会发生阻塞，直到能够执行，但等待时间不会超过给定
     *              值。返回一个特定值以告知该操作是否成功(典型的是 true / false)
     * 注意:无法向一个 BlockingQueue 中插入 null。如果你试图插入 null，BlockingQueue 将会抛出一个NullPointerException
     */
}
