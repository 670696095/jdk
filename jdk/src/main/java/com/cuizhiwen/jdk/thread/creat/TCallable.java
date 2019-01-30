package com.cuizhiwen.jdk.thread.creat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 14:58
 */
public class TCallable implements Callable<Integer> {

    /**
     * Callable:
     *      1. 创建 Callable 接口的实现类，并实现 call() 方法，该 call() 方法将作为线程执行体，并且有返回值。
     *      2. 创建 Callable 实现类的实例，使用 FutureTask 类来包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值。
     *      3. 使用 FutureTask 对象作为 Thread 对象的 target 创建并启动新线程。
     *      4. 调用 FutureTask 对象的 get() 方法来获得子线程执行结束后的返回值。
     * 创建线程的三种方式的对比
     *      1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
     *      2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
     */
    public static  int i ;
    public static void main(String[] args) throws InterruptedException {
        TCallable ctt = new TCallable();
        FutureTask<Integer> ft = new FutureTask<>(ctt);
        for(i= 0;i < 20;i++)
        {
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值"+i);
            if(i>4)
            {
                Thread.sleep(1000);
                new Thread(ft,"有返回值的线程").start();
                new Thread(new Thread(),"测试");

            }
        }
        try
        {
            System.out.println("子线程的返回值："+ft.get());
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        } catch (ExecutionException e)
        {
            e.printStackTrace();
        }

    }
    @Override
    public Integer call() throws Exception
    {

            System.out.println(Thread.currentThread().getName()+" "+i);

        return i;
    }
}
