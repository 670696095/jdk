package com.cuizhiwen.jdk.thread;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/23 14:51
 */
public class Join {
    /**
     * join（）方法：
     *      作用是调用线程等待该线程完成后，才能继续用下运行。
     *      我们在用到join（）的时候，通常都是main线程等到其他多个线程执行完毕后再继续执行。其他多个线程之间并不需要互相等待。
     *      thread的六种状态
     * 线程的6种状态；
     *      在某一时刻只能是这6种状态之一。
     *      这些状态由Thread.State这个枚举类型表示，并且可以通过getState()方法获得当前具体的状态类型。
     *
     *          1、NEW
     *          至今尚未启动的线程的状态。
     *          当使用new一个新线程时，如new Thread(r)，但还没有执行start(),线程还没有开始运行，这时线程的状态就是NEW。
     *          2、RUNNABLE
     *          可运行线程的线程状态。
     *          当start()方法被调用时，线程就进入RUNNABLE状态。此时的线程可能正在运行，也可能没有运行
     * 　　      3、BLOCKED
     * 　　           受阻塞并且正在等待监视器锁的某一线程的线程状态。
     *              下列情况会进入阻塞状态：
                    1.等待某个操作的返回，例如IO操作，该操作返回之前，线程不会继续下面的代码。
     *              2.等待某个“锁”，在其他线程或程序释放这个“锁”之前，线程不会继续执行。
     *              3.等待一定的触发条件。
     *              4.线程执行了sleep方法。
     *              5.线程被suspend()方法挂起。
     *              一个被阻塞的线程在下列情况下会被重新激活：
     *              1.执行了sleep()方法，睡眠时间已到。
     *              2.等待的其他线程或程序持有的“锁”已被释放。
     *              3.正在等待触发条件的线程，条件得到满足。
     *              4.执行了suspend()方法，被调用了resume()方法。
     *              5.等待的操作返回的线程，操作正确返回。
     * 　　      4、WAITING
     *              某一等待线程的线程状态。
     *              线程因为调用了Object.wait()或Thread.join()而未运行，就会进入WAITING状态。
     * 　　      5、TIMED_WAITING
     *              具有指定等待时间的某一等待线程的线程状态。
     *              线程因为调用了Thread.sleep()，或者加上超时值来调用Object.wait()或Thread.join()而未运行，则会进入TIMED_WAITING状态。
     * 　　      6、TERMINATED
     *              已终止线程的线程状态。
     *              线程已运行完毕。它的run()方法已正常结束或通过抛出异常而结束。
     *              线程的终止 run()方法结束，线程就结束。
     */
    public static void main(String[] args) throws InterruptedException {
        /*System.out.println("main start");
        Thread t1 = new Thread(new Worker("thread-1"));
        t1.start();
        t1.join();
        System.out.println("main end");*/

        System.out.println("main start");

        Thread t3 = new Thread(new Worker("thread-1"));
        Thread t4 = new Thread(new Worker("thread-2"));
        t3.start();
        //等待t1结束，这时候t2线程并未启动
        t3.join();

        //t1结束后，启动t2线程
        t4.start();
        //等待t2结束
        t4.join();

        System.out.println("main end");
    }

    static class Worker implements Runnable {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }
    }
}
