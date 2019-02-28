package com.cuizhiwen.jdk.thread;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 16:32
 */
public class Common extends Thread{
    /**
     *  Java多线程实现方式主要有四种：
     *      继承Thread类、实现Runnable接口、实现Callable接口通过FutureTask包装器来创建Thread线
     *      重写run方法（线程执行体）, 启动线程.start() 不是用start启动线程，run()就是一个普通方法。
     *      java程序执行后至少创建一个主线程，主线程由main确定。
     *
     *  进程:
     *       一条线程指的是进程中一个单一顺序的控制流，一个进程中可以并发多个线程，每条线程并行执行不同的任务。
     *       一个进程包括由操作系统分配的内存空间，包含一个或多个线程。一个线程不能独立的存在，它必须是进程的一部分。
     *       一个进程一直运行，直到所有的非守护线程都结束运行后才能结束。
     *      1>当一个程序进入内存，就变成了进程，进程是系统资源分配和调度的一个独立单位。
     *      2>程序是一个静态指令集合，而进程是正在系统中活动的指令集合。
     *  14. 线程和进程的区别
     *      进程：具有一定独立功能的程序关于某个数据集合上的一次运行活动，是操作系统进行资源分配和调度的一个独立单位。
     *      线程：是进程的一个实体，是 cpu 调度和分派的基本单位，是比进程更小的可以独立运行的基本单位。
     *          特点：线程的划分尺度小于进程，这使多线程程序拥有高并发性，进程在运行时各自内存单元相互独立，线程之间内存共享，
     *          这使多线程编程可以拥有更好的性能和用户体验注意：多线程编程对于其它程序是不友好的，占据大量 cpu 资源
     *
     *  并发与并行:
     *      1>并发:同一时刻，多条指定在多个处理器上同时执行。
     *      2>并行:同一时刻，只能有一条指令，多个进程指令快速轮换执行。宏观上会有多个进程同时执行效果。
     *
     *  线程：
     *      1>线程共享内存，堆栈，局部变量。
     *      2>创建进程需要重新分配系统资源。
     *
     *  应用:
     *      1>浏览器同时下载多个图片
     *      2>web服务器同时响应多个用户请求
     *      3>java虚拟机多线程垃圾回收
     *
     *  Thread类和Runnable接口
     *      1>Thread创建子类既为线程对象
     *      2>Runnable对象只作为线程对象的target
     *
     *  线程生命周期
     *      新建状态:
     *          使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。它保持这个状态直到程序 start() 这个线程。
     *      就绪状态:
     *          当线程对象调用了start()方法之后，该线程就进入就绪状态。就绪状态的线程处于就绪队列中，要等待JVM里线程调度器的调度。
     *      运行状态:
     *          如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。处于运行状态的线程最为复杂，它可以变为阻塞状态、就绪状态和死亡状态。
     *      阻塞状态:
     *          如果一个线程执行了sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。
     *          在睡眠时间已到或获得设备资源后可以重新进入就绪状态。可以分为三种：
     *              等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
     *              同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
     *              其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。当sleep() 状态超时，join()
     *                      等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。
     *      死亡状态:
     *          一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。
     *
     * 后台线程（守护线程，精灵线程）
     *      为其他线程提供服务，例：jvm垃圾回收线程
     * 线程的优先级
     *      每一个 Java 线程都有一个优先级，这样有助于操作系统确定线程的调度顺序。
     *      Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。
     *      默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。
     *      具有较高优先级的线程对程序更重要，并且应该在低优先级的线程之前分配处理器资源。但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。
     *
     * 请说出同步线程及线程调度相关的方法？
     *      wait()：使一个线程处于等待（阻塞）状态，并且释放所持有的对象的锁；
     *      sleep()：使一个正在运行的线程处于睡眠状态，是一个静态方法，调用此方法要处理 InterruptedException 异常；
     *      notify()：唤醒一个处于等待状态的线程，当然在调用此方法的时候，并不能确切的唤醒某一个等待状态的线程，而是由 JVM 确定唤醒哪个线程，而且与优先级无关；
     *      notityAll()：唤醒所有处于等待状态的线程，该方法并不是将对象的锁给所有线程，而是让它们竞争，只有获得锁的线程才能进入就绪状态；
     *      注意：java 5 通过 Lock 接口提供了显示的锁机制，Lock 接口中定义了加锁（lock（）方法）和解锁（unLock（）方法），增强了多线程编程的灵活性及对线程的协调
     */
    public static void main(String[] args) {
        System.out.println("主线程ID:" + Thread.currentThread().getId());
        new Common().start();
        new Common().run();

        /**
         *
         * 在 Thread 子类覆盖的 run 方法中编写运行代码方
         */
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }.start();

        /**
         *  在传递给 Thread 对象的 Runnable 对象的 run 方法中编写代码
         *
         *      如果 Threa类的 run 方法没有被覆盖，并且为该 Thread 对象设置了一个 Runnable 对象，该 run 方法会调用 Runnable 对象的run 方法
         */
        new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName());
                }
            }
        }).start();
    }



    @Override
    public void run(){
        System.out.println(this.getName());
    }

}
