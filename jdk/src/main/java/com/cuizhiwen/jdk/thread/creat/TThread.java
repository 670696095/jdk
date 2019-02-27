package com.cuizhiwen.jdk.thread.creat;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 14:53
 */
public class TThread extends Thread {
    /**
     * 方式一:
     *      继承 Thread 类：但 Thread 本质也是实现了 Runnable 接口的一个实例，它代表一个线程的实例，并
     *      且，启动线程的唯一方法就是通过 Thread 类的 start()实例方法。start()方法是一个 native 方法，它将启动一个新线
     *      程，并执行 run()方法。这种方式实现多线程很简单，通过自己的类直接 extend Thread，并复写 run()方法，就可以
     *      启动新线程并执行自己定义的 run()方法。
     */
    private Thread t;
    private String threadName;

    TThread(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try {
            for (int i = 4; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println("Thread " + threadName + " exiting.");
    }

    @Override
    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }


    public static void main(String args[]) {
        TThread T1 = new TThread("Thread-1");
        T1.start();

        TThread T2 = new TThread("Thread-2");
        T2.start();
    }
}
