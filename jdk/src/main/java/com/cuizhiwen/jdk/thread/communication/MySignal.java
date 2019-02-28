package com.cuizhiwen.jdk.thread.communication;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 17:00
 */
public class MySignal {
    /**
     * Java 中多线程间的通信怎么实现?(2017-2-24)
     * 线程通信的方式：
     * 1.共享变量
     * 线程间通信可以通过发送信号，发送信号的一个简单方式是在共享对象的变量里设置信号值。线程 A 在一个
     * 同步块里设置 boolean 型成员变量 hasDataToProcess 为 true，线程 B 也在同步块里读取 hasDataToProcess
     * 这个成员变量。这个简单的例子使用了一个持有信号的对象，并提供了 set 和 get 方法:
     * 2.wait/notify 机制
     * 以资源为例，生产者生产一个资源，通知消费者就消费掉一个资源，生产者继续生产资源，消费者消费资源，以此循环
     */
    //共享的变量
    private boolean hasDataToProcess = false;

    //取值
    public boolean getHasDataToProcess() {
        return hasDataToProcess;
    }

    //存值
    public void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;

    }

    public static void main(String[] args) {
        //同一个对象
        final MySignal my = new MySignal();
        //线程 1 设置 hasDataToProcess 值为 true
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                my.setHasDataToProcess(true);
            }
        });
        t1.start();

        //线程 2 取这个值 hasDataToProcess
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //等待线程 1 完成然后取值
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                my.getHasDataToProcess();
                System.out.println("t1 改变以后的值：" + my.getHasDataToProcess());
            }
        });
        t2.start();
    }
}

