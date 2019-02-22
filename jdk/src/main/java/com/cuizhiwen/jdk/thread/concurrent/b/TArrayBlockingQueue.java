package com.cuizhiwen.jdk.thread.concurrent.b;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 15:01
 */
public class TArrayBlockingQueue {
    /**
     *  所谓公平锁：就是在并发环境中，每个线程在获取锁时会先查看此锁维护的等待队列，如果为空，或者当前线
     *              程线程是等待队列的第一个，就占有锁，否则就会加入到等待队列中，以后会按照 FIFO 的规则从队列中取到自己。
     *  非公平锁：比较粗鲁，上来就直接尝试占有锁，如果尝试失败，就再采用类似公平锁那种方式
     *  需求：在多线程操作下，一个数组中最多只能存入 3 个元素。多放入不可以存入数组，或等待某线程对数组中某
     * 个元素取走才能放入，要求使用 java 的多线程来实现。（面试）
     */
    public static void main(String[] args) {
        final BlockingQueue queue = new ArrayBlockingQueue(3);
        for(int i=0;i<2;i++){
            new Thread(){
                @Override
                public void run(){
                    while(true){
                        try {
                            Thread.sleep((long)(Math.random()*1000));
                            System.out.println(Thread.currentThread().getName() + "准备放数据!");
                            queue.put(1);
                            System.out.println(Thread.currentThread().getName() + "已经放了数据，" +
                                    "队列目前有" + queue.size() + "个数据");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
        new Thread(){
            @Override
            public void run(){
                while(true){
                    try {
                        //将此处的睡眠时间分别改为 100 和 1000，观察运行结果
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "准备取数据!");
                        System.err.println(queue.take());
                        System.out.println(Thread.currentThread().getName() + "已经取走数据，" +
                                "队列目前有" + queue.size() + "个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}

