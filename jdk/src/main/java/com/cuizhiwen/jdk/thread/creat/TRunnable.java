package com.cuizhiwen.jdk.thread.creat;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 14:45
 */
public class TRunnable implements Runnable {
    private Thread t;
    private String threadName;

    TRunnable(String name) {
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

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }


    public static void main(String args[]) {
        TRunnable R1 = new TRunnable("Thread-1");
        R1.start();

        TRunnable R2 = new TRunnable("Thread-2");
        R2.start();

    }
}
