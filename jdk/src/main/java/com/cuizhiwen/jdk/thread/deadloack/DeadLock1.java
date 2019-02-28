package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 14:48
 */
public class DeadLock1 implements Runnable {
    public int flag = 1;
    //静态对象是类的所有对象共享的
    private static Object o1 = new Object(), o2 = new Object();
    @Override
    public void run() {
        System.out.println("flag=" + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }

    public static void main(String[] args) {
        DeadLock1 td1 = new DeadLock1();
        DeadLock1 td2 = new DeadLock1();
        td1.flag = 1;
        td2.flag = 0;
        //td1,td2 都处于可执行状态，但 JVM 线程调度先执行哪个线程是不确定的。
        //td2 的 run()可能在 td1 的 run()之前运行
        new Thread(td1).start();

        new Thread(td2).start();
    }
}

