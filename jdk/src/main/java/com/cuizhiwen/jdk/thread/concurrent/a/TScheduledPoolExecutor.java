package com.cuizhiwen.jdk.thread.concurrent.a;

import java.util.concurrent.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 11:23
 */
public class TScheduledPoolExecutor {
    /**
     * ➢ScheduledPoolExecutor 定时线程池执行者
     *      java.util.concurrent.ScheduledExecutorService 是一个 ExecutorService， 它能够将任务延后执行，
     *      或者间隔固定时间多次执行。 任务由一个工作者线程异步执行，而不是由提交任务给 ScheduledExecutorService 的那个线程执行
     *
     *      首先一个内置 5 个线程的 ScheduledExecutorService 被创建。之后一个 Callable 接口的匿名类示例被创建然后传递给 schedule() 方法。
     *      后边的俩参数定义了 Callable 将在 5 秒钟之后被执行。
     * ScheduledExecutorService 的实现:
     *      ScheduledExecutorService 是一个接口，你要用它的话就得使用 java.util.concurrent 包里对它的某个实现类。
     *      ScheduledExecutorService 具有以下实现类：ScheduledThreadPoolExecutor
     * 创建一个 ScheduledExecutorService:
     *      如何创建一个 ScheduledExecutorService 取决于你采用的它的实现类。但是你也可以使用 Executors 工厂类来创建一个 ScheduledExecutorService
     * ScheduledExecutorService 的使用:
     *      一旦你创建了一个 ScheduledExecutorService，你可以通过调用它的以下方法：
     *       schedule (Callable task, long delay, TimeUnit timeunit)
     *       schedule (Runnable task, long delay, TimeUnit timeunit)
     *       scheduleAtFixedRate (Runnable, long initialDelay, long period, TimeUnit timeunit)
     *       scheduleWithFixedDelay (Runnable, long initialDelay, long period, TimeUnit timeuni
     * ScheduledExecutorService 的关闭:
     *      正如 ExecutorService，在你使用结束之后你需要把 ScheduledExecutorService 关闭掉。否则他将导致 JVM
     *      继续运行，即使所有其他线程已经全被关闭。你可以使用从 ExecutorService 接口继承来的 shutdown() 或 shutdownNow()方 法
     *      将ScheduledExecutorService 关闭。
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {


    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
    ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
        @Override
        public Object call() throws Exception {
            System.out.println("Executed!");
            return "Called!";
        }
    }, 5, TimeUnit.SECONDS);//5 秒后
    System.out.println("result = " + scheduledFuture.get());
    scheduledExecutorService.shutdown();
    }
}
