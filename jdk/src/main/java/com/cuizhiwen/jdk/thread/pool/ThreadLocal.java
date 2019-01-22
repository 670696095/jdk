package com.cuizhiwen.jdk.thread.pool;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 13:21
 */
public class ThreadLocal {
    /**
     * 线程池:
     *      系统启动一个线程成本太高，他设计与操作系统交互，当系统需要建立大量生存期很短的线程时应考虑线程池。
     *
     * 说明:与数据库连接相似，系统启动时就创建大量空闲线程，程序传入一个Runnable对象或者CallAble对象，线程就
     *      启动一个线程来执行run或call 当执行完后并不会死亡，而是再次返回线程池中变成空闲状态，等待下一个runnable对象
     *      run或call
     */
}
