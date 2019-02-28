package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 13:58
 */
public class DeadLock implements Runnable {
    /**
     * 11.1 死锁的定义：
     *      所谓死锁是指多个线程因竞争资源而造成的一种僵局（互相等待），若无外力作用，这些进程都将无法向前推进。
     * 11.2 死锁产生的必要条件：
     *      1.互斥条件：线程要求对所分配的资源（如打印机）进行排他性控制，即在一段时间内某 资源仅为一个线程所占有。此时若有其他线程请求该资源，则请求线程只能等待
     *      2.不剥夺条件：线程所获得的资源在未使用完毕之前，不能被其他线程强行夺走，即只能由获得该资源的线程自己来释放（只能是主动释放)。
     *      3.请求和保持条件：线程已经保持了至少一个资源，但又提出了新的资源请求，而该资源已被其他线程占有，此时请求进程被阻塞，但对自己已获得的资源保持不放。
     *      4.循环等待条件：存在一种线程资源的循环等待链，链中每一个线程已获得的资源同时被链中下一个线程所请求。即存在一个处于等待状态的线程集合{Pl, P2, ..., pn}，
     *          其中 Pi 等待的资源被 P(i+1)占有（i=0, 1, ..., n-1)，Pn 等待的资源被 P0 占有，
     */
    class A{
        public synchronized void foo(B b){

            System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了A实例的foo方法");//①

            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用B实例的last方法");//③
            b.last();
        }

        public synchronized void last(){
            System.out.println("进入了A实例的last方法");
        }
    }

    class B{
        public synchronized void bar(A a){
            System.out.println("当前线程名："+Thread.currentThread().getName()+"进入了B实例的bar方法");//②

            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("当前线程名："+Thread.currentThread().getName()+"企图调用A实例的last方法");//④
            a.last();
        }

        public synchronized void last(){
            System.out.println("进入了B实例的last方法");
        }
    }

    A a=new A();
    B b=new B();

    public void init(){
        Thread.currentThread().setName("主线程");
        a.foo(b);
        System.out.println("进入了主线程之后");
    }

    @Override
    public void run() {
        Thread.currentThread().setName("子线程");
        b.bar(a);
        System.out.println("进入了子线程之后");
    }

    public static void main(String args[]) throws Exception {
        DeadLock dl=new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}