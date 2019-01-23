package com.cuizhiwen.jdk.thread.pool;

import java.util.concurrent.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 16:13
 */
public class ThreadPool  {
    /**
     * 线程池:
     *      系统启动一个线程成本太高，他设计与操作系统交互，当系统需要建立大量生存期很短的线程时应考虑线程池。
     *
     * 说明:与数据库连接相似，系统启动时就创建大量空闲线程，程序传入一个Runnable对象或者CallAble对象，线程就
     *      启动一个线程来执行run或call 当执行完后并不会死亡，而是再次返回线程池中变成空闲状态，等待下一个runnable对象
     *      run或call
     *
     * Java 线程池：
     * Java通过Executors提供四种线程池分别为：
     *      new CachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
     *      new FixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
     *      new ScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
     *      new SingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */

    public static void main(String[] args) {
        //ThreadPoolExecutor
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        pool.shutdown();

        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
        /**
         * 每隔一段时间打印系统时间
         */
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.nanoTime());

            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);



    }

    }

class MyThread extends Thread {

    @Override

    public void run() {

        System.out.println(Thread.currentThread().getName() + "正在执行。。。");

    }

}
