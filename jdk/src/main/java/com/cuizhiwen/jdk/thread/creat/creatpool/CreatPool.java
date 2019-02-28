package com.cuizhiwen.jdk.thread.creat.creatpool;

import java.util.concurrent.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/27 10:56
 */
public class CreatPool {
    /**
     *
     *  Executor框架
     *          是指java 5中引入的一系列并发库中与executor相关的一些功能类，其中包括线程池，Executor，Executors，ExecutorService，
     *          CompletionService，Future，Callable等。他们的关系为：并发编程的一种编程方式是把任务拆分为一些列的小任务，即Runnable，
     *          然后在提交给一个Executor执行，Executor.execute(Runnalbe) 。Executor在执行时使用内部的线程池完成操作。
     *
     * 问: main（）方法中为什么不能new 内部类
     *          main 方法是个静态方法，而静态类不是个静态内部类，所以不能直接初始化。对main方法而言，虽然写在类中，
     *          它是游离于任何类之外的(就跟C++一样，单独一个main方法)，因此某类的非静态内部类对它而言是不直接可见的，也就无法直接访问
     * 线程池四种创建方式:
     *          ExecutorService接口。
     *
     *          创建固定数目线程的线程池。
     *          public static ExecutorService newFixedThreadPool(int nThreads)
     *
     *          创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。
     *          终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
     *          创建一个可缓存的线程池，此线程池不会对线程池大小做限制，线程池大小完全依赖于
     *          操作系统（或者说 JVM）能够创建的最大线程大小
     *          public static ExecutorService newCachedThreadPool()
     *
     *          创建一个单线程化的Executor。 创建一个单线程的线程池，此线程池保证所有任务的执行顺序按照任务的提交顺序执行
     *          public static ExecutorService newSingleThreadExecutor()
     *
     *          创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
     *          public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
     * 使用线程池的好处
     *          第一：降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。
     *          第二：提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。
     *          第三：提高线程的可管理性。线程是稀缺资源，如果无限制的创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一的分配，调优和监控
     * 线程启动策略
     *          1、线程池刚创建时，里面没有一个线程。任务队列是作为参数传进来的。不过，就算队列里面有任务，线程池也不会马上执行它们。
     *          2、当调用 execute() 方法添加一个任务时，线程池会做如下判断：
     *              a. 如果正在运行的线程数量小于 corePoolSize，那么马上创建线程运行这个任务；
     *              b. 如果正在运行的线程数量大于或等于 corePoolSize，那么将这个任务放入队列。
     *              c. 如果这时候队列满了，而且正在运行的线程数量小于 maximumPoolSize，那么还是要创建线程运行这个任务；
     *              d. 如果队列满了，而且正在运行的线程数量大于或等于 maximumPoolSize，那么线程池会抛出异常，告诉调用者“我不能再接受任务了”。
     *          3、当一个线程完成任务时，它会从队列中取下一个任务来执行。
     *          4、当一个线程无事可做，超过一定的时间（keepAliveTime）时，线程池会判断，如果当前运行的线程数大于
     *              corePoolSize，那么这个线程就被停掉。所以线程池的所有任务完成后，它最终会收缩到 corePoolSize 的大小
     */

    public static void main(String[] args) {
        /**
         *
         */
        Executor executor = Executors.newFixedThreadPool(10);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("task over");
            }
        };
        executor.execute(task);

       /* executor = Executors.newScheduledThreadPool(10);
        ScheduledExecutorService scheduler = (ScheduledExecutorService) executor;
        scheduler.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);*/

        /**
         * ExecutorService与生命周期
         *           ExecutorService扩展了Executor并添加了一些生命周期管理的方法。一个Executor的生命周期有三种状态，运行 ，关闭 ，终止 。
         *           Executor创建时处于运行状态。当调用ExecutorService.shutdown()后，处于关闭状态，isShutdown()方法返回true。这时，
         *           不应该再想Executor中添加任务，所有已添加的任务执行完毕后，Executor处于终止状态，isTerminated()返回true。
         *           如果Executor处于关闭状态，往Executor提交任务会抛出unchecked exception RejectedExecutionException。
         */
        ExecutorService executorService = (ExecutorService) executor;
        while (!executorService.isShutdown()) {
            try {
                executorService.execute(task);
            } catch (RejectedExecutionException ignored) {

            }
        }
        executorService.shutdown();
        /**
         *  使用Callable，Future返回结果
         *          Future<V>代表一个异步执行的操作，通过get()方法可以获得操作的结果，如果异步操作还没有完成，则，get()会使当前线程阻塞。
         *          FutureTask<V>实现了Future<V>和Runable<V>。Callable代表一个有返回值得操作。
         *
         *          ExecutoreService提供了submit()方法，传递一个Callable，或Runnable，返回Future。如果Executor后台线程池还没有完成Callable的计算，
         *          这调用返回Future对象的get()方法，会阻塞直到计算完成。
         */
        Callable<Integer> func = new Callable<Integer>(){
            @Override
            public Integer call() throws Exception {
                System.out.println("inside callable");
                Thread.sleep(1000);
                return new Integer(8);
            }
        };
        FutureTask<Integer> futureTask  = new FutureTask<Integer>(func);
        Thread newThread = new Thread(futureTask);
        newThread.start();
        try {
            System.out.println("blocking here");
            Integer result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException ignored) {
        } catch (ExecutionException ignored) {
        }
    }
}
