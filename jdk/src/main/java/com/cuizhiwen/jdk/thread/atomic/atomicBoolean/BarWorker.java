package com.cuizhiwen.jdk.thread.atomic.atomicBoolean;

import java.util.concurrent.TimeUnit;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/25 17:04
 */
public class BarWorker implements Runnable {
    /**
     * 从上面的运行结果我们可看到，两个线程运行时，都对静态变量 exists 同时做操作，并没有保证 exists 静态变量
     * 的原子性，也就是一个线程在对静态变量 exists 进行操作到时候，其他线程必须等待或不作为。等待一个线程操作完
     * 后，才能对其进行操作。
     */
    //静态变量
    private static boolean exists = false;

    private String name;


    public BarWorker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (!exists) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                // do nothing
            }
            exists = true;
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exists = false;
        } else {
            System.out.println(name + " give up");
        }
    }

    public static void main(String[] args) {
        BarWorker bar1 = new BarWorker("bar1");
        BarWorker bar2 = new BarWorker("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();
    }
}

