package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 13:58
 */
public class DeadLock implements Runnable {
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