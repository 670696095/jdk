package com.cuizhiwen.jdk.thread.creat;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 14:53
 */
public class TThread extends Thread {
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
