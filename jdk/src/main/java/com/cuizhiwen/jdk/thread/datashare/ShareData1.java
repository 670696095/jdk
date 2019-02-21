package com.cuizhiwen.jdk.thread.datashare;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/21 15:39
 */
public class ShareData1 {
    /**
     * 多个线程行为不一致共同操作一个数据
     *      如果每个线程执行的代码不同，这时候需要用不同的 Runnable 对象，有如下两种方式来实现这些 Runnable 对象之间的数据共享：
     *          1) 将共享数据封装在另外一个对象中，然后将这个对象逐一传递给各个 Runnable 对象。每个线程对共享
     *           数据的操作方法也分配到那个对象身上去完成，这样容易实现针对该数据进行的各个操作的互斥和通信
     *          2) 将这些 Runnable 对象作为某一个类中的内部类，共享数据作为这个外部类中的成员变量，每个线程对共享数据的操作方法也分配给外部类，
     *              以便实现对共享数据进行的各个操作的互斥和通信，作为内部类的各个Runnable 对象调用外部类的这些方
     */

    //封装共享数据类
    static class RunnableCusToInc implements Runnable{
        //封装共享数据
        private ShareData shareData;

        public RunnableCusToInc(ShareData data) {
            this.shareData = data;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareData.inc();
            }
        }
    }
    //封装共享数据类
    static class RunnableCusToDec implements Runnable{
        //封装共享数据
        private ShareData shareData;
        public RunnableCusToDec(ShareData data) {
            this.shareData = data;
        }
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareData.dec();
            }
        }
    }
    /**
     *共享数据类
     **/
    static class ShareData {
        private int num = 10;

        public synchronized void inc() {
            num++;
            System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void dec() {
            num--;
            System.out.println(Thread.currentThread().getName() + ": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            ShareData shareData = new ShareData();
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    new Thread(new RunnableCusToInc(shareData), "Thread " + i).start();
                } else {
                    new Thread(new RunnableCusToDec(shareData), "Thread " + i).start();
                }
            }
        }


    }}
