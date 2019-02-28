package com.cuizhiwen.jdk.thread.exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 13:59
 */
public class QQ2 {
    private int count = 0;
    //设置 lock 锁
    private Lock lock = new ReentrantLock();
    // 方法 1
    public Runnable run1 = new Runnable() {
        @Override
        public void run() {
            synchronized (this) {
                //加锁
                while (count < 10) {
                    try {
                        //打印是否执行该方法
                        System.out.println(Thread.currentThread().getName() + " run1: " + count++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    // 方法 1

    public Runnable run2 = new Runnable() {
        @Override
        public void run() {
            synchronized (this) {
                //加锁
                while (count < 10) {
                    try {
                        //打印是否执行该方法
                        System.out.println(Thread.currentThread().getName() + " run2: " + count++);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };




    public static void main(String[]args)throws InterruptedException{
        QQ2 t=new QQ2();
        new Thread(t.run1).start();
        new Thread(t.run2).start();
    }

}
