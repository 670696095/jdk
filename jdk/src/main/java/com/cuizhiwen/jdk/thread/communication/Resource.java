package com.cuizhiwen.jdk.thread.communication;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 17:43
 */
public class Resource {
    private String name;
    private int count = 1;
    private boolean flag = false;

    public synchronized void set(String name) {
        //生产资源
        while (flag) {
            try {
                //线程等待。消费者消费资源
                wait();
            } catch (Exception e) {
            }
        }
        this.name = name + "---" + count++;
        System.out.println(Thread.currentThread().getName() + "...生产者..." + this.name);
        flag = true;
        //唤醒等待中的消费者
        this.notifyAll();
    }

    public synchronized void out() {
        //消费资源
        while (!flag) {
            //线程等待，生产者生产资源
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.println(Thread.currentThread().getName() + "...消费者..." + this.name);
        flag = false;
        //唤醒生产者，生产资源
        this.notifyAll();
    }
}

//生产者
class Producer implements Runnable {
    private Resource res;

    Producer(Resource res) {
        this.res = res;
    }

    //生产者生产资源
    @Override
    public void run() {
        while (true) {
            res.set("商品");
        }
    }
}

//消费者消费资源
class Consumer implements Runnable {
    private Resource res;

    Consumer(Resource res) {
        this.res = res;
    }

    @Override
    public void run() {
        while (true) {
            res.out();
        }
    }


    public static void main(String[] args) {
        Resource r = new Resource();
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);
        t1.start();
        t2.start();
    }
}
