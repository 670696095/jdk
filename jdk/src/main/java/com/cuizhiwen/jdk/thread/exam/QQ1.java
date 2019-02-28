package com.cuizhiwen.jdk.thread.exam;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 13:38
 */
public class QQ1 {
    /**
     * 同一个类中的 2 个方法都加了同步锁，多个线程能同时访问同一个类中的这两个方法吗？
     *      答：这个问题需要考虑到Lock与synchronized 两种实现锁的不同情形。因为这种情况下使用Lock 和synchronized
     *      会有截然不同的结果。
     *
     *      Lock 可以让等待锁的线程响应中断，Lock 获取锁，之后需要释放锁。
     *      synchronized 却不行，使用 synchronized 时，当我们访问同一个类对象的时候，是同一把锁，所以可以访问该对象的其他 synchronized 方法。
     */
    private int count = 0;
    private Lock lock = new ReentrantLock();//设置 lock 锁
    // 方法1
    public Runnable run1 = new Runnable() {
        @Override
        public void run() {
            //加锁
            lock.lock();
            while (count < 10) {
                try {
                    //打印是否执行该方法
                    System.out.println(Thread.currentThread().getName() + " run1: " + count++);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            //lock.unlock();

        }
    };

    // 方法2

    public Runnable run2 = new Runnable() {
        @Override
        public void run() {
            lock.lock();
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
    };

    public static void main(String[]args)throws InterruptedException{
        QQ1 t=new QQ1();
        new Thread(t.run1).start();
        new Thread(t.run2).start();
        }

}
