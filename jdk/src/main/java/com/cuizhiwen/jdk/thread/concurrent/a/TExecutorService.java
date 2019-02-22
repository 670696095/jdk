package com.cuizhiwen.jdk.thread.concurrent.a;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 10:32
 */
public class TExecutorService {
    /**
     * ➢ExecutorService 执行器服务
     *      java.util.concurrent.ExecutorService 接口表示一个异步执行机制，使我们能够在后台执行任务。因此一个 ExecutorService 很类似于一个线程池。
     *      实际上，存在于 java.util.concurrent 包里的 ExecutorService 实现就是一个线程池实
     *  ExecutorService 实现:
     *      既然 ExecutorService 是个接口，如果你想用它的话就得去使用它的实现类之一。java.util.concurrent 包提供了 ExecutorService 接口的以下实现类：
     *       ThreadPoolExecutor
     *       ScheduledThreadPoolExecutor
     *  ExecutorService 创建:
     *      ExecutorService 的创建依赖于你使用的具体实现。但是你也可以使用 Executors 工厂类来创建ExecutorService
     *      代码示例
     *      ExecutorService executorService1 = Executors.newSingleThreadExecutor(); //之前 Executors 已介绍
     *      ExecutorService executorService2 = Executors.newFixedThreadPool(10);
     *      ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
     *  ExecutorService 使用:
     *     有几种不同的方式来将任务委托给 ExecutorService 去执行
     *      execute(Runnable)
     *      submit(Runnable)
     *      submit(Callable)
     *      invokeAny(…)
     *      invokeAll()
     *  Executors 关闭:
     *      使用 shutdown 和 shutdownNow 可以关闭线程池两者的区别：
     *          shutdown 只是将空闲的线程 interrupt() 了，shutdown（）之前提交的任务可以继续执行直到结束。
     *          shutdownNow 是 interrupt 所有线程， 因此大部分线程将立刻被中断。之所以是大部分，而不是全部 ，是因为 interrupt()方法能力有限
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程工厂类创建出线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        /**
         * ✓ execute(Runnable)
         *      execute(Runnable) 方法要求一个 java.lang.Runnable 对象，然后对它进行异步
         *      没有办法得知被执行的 Runnable 的执行结果。如果有需要的话你得使用一个 Callable
         */
        //执行一个线程任务
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        //线程池关闭
        executorService.shutdown();
        /**
         *  ✓ submit(Runnable)
         *  submit(Runnable) 方法也要求一个 Runnable 实现类，但它返回一个 Future 对象。这个 Future 对象可以用来检查 Runnable 是否已经执行完毕。
         */
        Future future = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Asynchronous task");
            }
        });
        future.get(); //获得执行完 run 方法后的返回值，这里使用的 Runnable，所以这里没有返回值，返回的是 null。
        executorService.shutdown();
        /**
         *  ✓ submit(Runnable)
         *      submit(Callable) 方法类似于 submit(Runnable) 方法，除了它所要求的参数类型之外。
         *      Callable 实例除了它的 call() 方法能够返回一个结果之外和一个 Runnable 很相像。Runnable.run() 不能够返回一个结果。
         *      Callable 的结果可以通过 submit(Callable) 方法返回的 Future 对象进行获
         */
        Future future1 = executorService.submit(new Callable(){
            @Override
            public Object call() throws Exception {
                System.out.println("Asynchronous Callable");
                return "Callable Result";
            }
        });
        System.out.println("future.get() = " + future1.get());
        executorService.shutdown();

        /**
         *  ✓ invokeAny()
         *      invokeAny() 方法要求一系列的 Callable 或者其子接口的实例对象。调用这个方法并不会返回一个 Future，
         *      但它返回其中一个 Callable 对象的结果。无法保证返回的是哪个 Callable 的结果 – 只能表明其中一个已执行结束。
         *      如果其中一个任务执行结束(或者抛了一个异常)，其他 Callable 将被取消。
         */
        Set<Callable<String>> callables = new HashSet<Callable<String>>();
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callables.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });
        String result = executorService.invokeAny(callables);
        System.out.println("result = " + result);
        executorService.shutdown();
        /**
         *  ✓ invokeAll()
         *      invokeAll() 方法将调用你在集合中传给 ExecutorService 的所有 Callable 对象。invokeAll() 返回一系列的 Future 对象，
         *      通过它们你可以获取每个 Callable 的执行结果。记住，一个任务可能会由于一个异常而结束，因此它可能没有 "成功"。
         *      无法通过一个 Future 对象来告知我们是两种结束中的哪一
         */
        Set<Callable<String>> callabless = new HashSet<Callable<String>>();
        callabless.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 1";
            }
        });
        callabless.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 2";
            }
        });
        callabless.add(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "Task 3";
            }
        });
        List<Future<String>> futures = executorService.invokeAll(callabless);
        for(Future<String> futur : futures){
            System.out.println("future.get = " + futur.get());
        }
        executorService.shutdown();

    }
}
