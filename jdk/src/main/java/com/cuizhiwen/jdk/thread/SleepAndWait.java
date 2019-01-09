package com.cuizhiwen.jdk.thread;

/**
 * @author 01418061(cuizhiwen)
 * @Description: java中的sleep()和wait()的区别
 * @date 2019/1/3 16:21
 */
public class SleepAndWait {
    /**
     * sleep()属于Thread类，wait()属于object类
     * 1>sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
     *   在调用sleep()方法的过程中，线程不会释放对象锁。
     * 2>调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备
     *   获取对象锁进入运行状态。调用它的前提是当前线程占有锁(即代码要在synchronized中)。
     * 3>使用范围：wait，notify和notifyAll只能在同步方法或者同步代码块里面使用
     */

    public static void main(String[] args) {

        new Thread(new Thread1()).start();
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();

    }
    private static class Thread1 implements Runnable{
        @Override
     public void run(){
         synchronized (SleepAndWait.class) {
             System.out.println("enter thread1...");
             System.out.println("thread1 is waiting...");
                try {
                 //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
                 SleepAndWait.class.wait();
                 } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("\nthread1 is going on ....");
                    System.out.println("thread1 is over!!!");
                        }
                    }
    }



    private static class Thread2 implements Runnable{
        @Override
        public void run(){
            synchronized (SleepAndWait.class) {
                System.out.println("\nenter thread2....");
                System.out.println("thread2 is sleep....");
                //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
                SleepAndWait.class.notify();
                //如果我们把代码：SleepAndWait.class.notify();给注释掉，即SleepAndWait.class调用了wait()方法，
                // 但是没有调用notify()方法，则线程永远处于挂起状态。
                try {
                    //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
                    //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
                    //在调用sleep()方法的过程中，线程不会释放对象锁。
                    Thread.sleep(5000);
                    } catch (Exception e) {
                        e.printStackTrace();
                        }
                        System.out.println("\nthread2 is going on....");
                        System.out.println("thread2 is over!!!");
                            }
                     }
    }

}
