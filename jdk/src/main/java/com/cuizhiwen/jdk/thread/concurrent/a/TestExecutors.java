package com.cuizhiwen.jdk.thread.concurrent.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 10:25
 */
public class TestExecutors {
    /**
     * java.util.concurrent 包描述：
     *      在并发编程中很常用的实用工具类。此包包括了几个小的、已标准化的可扩展框架，以及一些提供有用功能的类。此包下有一些组件，其中包括：
     *           执行程序（线程池）
     *           并发队列
     *           同步器
     *           并发 Collocati
     *      A. 执行程序
     *          ➢Executors 线程池工厂类
     *          首次我们来说下线程池的作用:
     *          线程池作用就是限制系统中执行线程的数量。根据系统的环境情况，可以自动或手动设置线程数量，达到运行的最佳效果；少了浪费了系统资源，多了
     *          造成系统拥挤效率不高。用线程池控制线程数量，其他线程 排队等候。一个任务执行完毕，再从队列的中取最前面的任务开始执行。若队列中没有等待进程，
     *          线程池的这一资源处于等待。当一个新任务需要运行时，如果线程 池中有等待的工作线程，就可以开始运行了；否则进入等待队列。
     *      为什么要用线程池:
     *           减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务
     *           可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为因为消耗过多的内存，而把服务器累趴下(每个线程需要大约 1MB 内存，线程开的越多，
     *          消耗的内存也就越大，最后死机)
     *      Executors 详解:
     *          Java 里面线程池的顶级接口是 Executor，但是严格意义上讲 Executor 并不是一个线程池，而只是一个
     *          执行线程的工具。真正的线程池接口是 ExecutorService。ThreadPoolExecutor 是 Executors 类的底层实现。我们先介绍下 Executors。
     *          程执行调度由池管理器来处理。当有线程任务时，从池中取一个，执行完成后线程对象归池，这样可以避免反复创建线程对象所带来的性能开销，节省了系统的资源。
     *          Java5 中并发库中，线程池创建线程大致可以分为下面三种：
     *          //创建固定大小的线程池
     *          ExecutorService fPool = Executors.newFixedThreadPool(3);
     *          //创建缓存大小的线程池
     *          ExecutorService cPool = Executors.newCachedThreadPool();
     *          //创建单一的线程池
     *          ExecutorService sPool = Executors.newSingleThreadExecutor();
     *          //可延迟线程池
     *          ScheduledExecutorService pool = Executors.newScheduledThreadPool();
     */
    public static void main(String[] args) {
        //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        //创建实现了 Runnable 接口对象，Thread 对象当然也实现了 Runnable 接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        //使用定时执行风格的方法
        pool.schedule(t4, 10, TimeUnit.MILLISECONDS); //t4 和 t5 在 10 秒后执行
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
        //关闭线程池
        pool.shutdown();
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "正在执行。。。");
        }
    }

}

