package com.cuizhiwen.jdk.thread.creat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description: 有返回值的线程
 * @date 2019/2/27 10:10
 */
@SuppressWarnings("unchecked")
public class TExecutor {
    /**
     * 使用 ExecutorService、Callable、Future 实现有返回结果的多线程：ExecutorService、Callable、Future
     *      这个对象实际上都是属于Executor框架中的功能类。返回结果的线程是在 JDK1.5 中引入
     *      的新特征，确实很实用，有了这种特征我就不需要再为了得到返回值而大费周折了，而且即便实现了也可能漏洞百出。
     *      可返回值的任务必须实现 Callable 接口，类似的，无返回值的任务必须 Runnable 接口。执行 Callable 任务后，可以
     *      获取一个 Future 的对象，在该对象上调用 get 就可以获取到 Callable 任务返回的 Object 了，再结合线程池接口
     *      ExecutorService 就可以实现传说中有返回结果的多线程了
     *
     * Executor框架
     *          是指java 5中引入的一系列并发库中与executor相关的一些功能类，其中包括线程池，Executor，Executors，ExecutorService，
     *          CompletionService，Future，Callable等。他们的关系为：并发编程的一种编程方式是把任务拆分为一些列的小任务，即Runnable，
     *          然后在提交给一个Executor执行，Executor.execute(Runnalbe) 。Executor在执行时使用内部的线程池完成操作。
     *
     * 问: main（）方法中为什么不能new 内部类
     *          main 方法是个静态方法，而静态类不是个静态内部类，所以不能直接初始化。对main方法而言，虽然写在类中，
     *          它是游离于任何类之外的(就跟C++一样，单独一个main方法)，因此某类的非静态内部类对它而言是不直接可见的，也就无法直接访问
     * 线程池四种创建方式:
     *          ExecutorService接口。
     *          创建固定数目线程的线程池。
     *          public static ExecutorService newFixedThreadPool(int nThreads)
     *          创建一个可缓存的线程池，调用execute 将重用以前构造的线程（如果线程可用）。如果现有线程没有可用的，则创建一个新线程并添加到池中。终止并从缓存中移除那些已有 60 秒钟未被使用的线程。
     *          public static ExecutorService newCachedThreadPool()
     *          创建一个单线程化的Executor。
     *          public static ExecutorService newSingleThreadExecutor()
     *          创建一个支持定时及周期性的任务执行的线程池，多数情况下可用来替代Timer类。
     *          public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize)
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("++++++程序开始运行++++++++");
        Date date1 = new Date();

        int  taskSize = 5;
       ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<>();
        for (int i = 0; i <taskSize ; i++) {
            Callable c = new MyCallable(i+"");
            Future future = pool.submit(c);
            // System.out.println(">>>" + f.get().toString());
            list.add(future);

        }
        pool.shutdown();

        for (Future future : list) {
            // 从 Future 对象上获取任务的返回值，并输出到控制台
            System.out.println("********** :" + future.get().toString()+"**********:  ");
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }

    static class MyCallable implements Callable<Object> {
        private String taskNum;
        MyCallable(String taskNum) {
            this.taskNum = taskNum;
            }
            @Override
            public Object call() throws Exception {
            System.out.println(">>>" + taskNum + "任务启动");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + taskNum + "任务终止");
            return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
          }
}


}


