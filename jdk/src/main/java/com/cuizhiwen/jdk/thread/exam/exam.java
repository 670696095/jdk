package com.cuizhiwen.jdk.thread.exam;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/21 10:26
 */
public class exam {
    /**
     * 要求：子线程运行执行 10 次后，主线程再运行 5 次。这样交替执行三遍
     * @param args
     */
    public static void main(String[] args) {
        final Bussiness bussiness = new Bussiness();
        //子线程
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 0; i < 3; i++) {
                bussiness.subMethod();}}}).start();
        //主线程
        for (int i = 0; i < 3; i++) {
            bussiness.mainMethod();}}
        }
        class Bussiness {

            private boolean subFlag = true;
            public synchronized void mainMethod() {
                    while (subFlag) {
                         try {
                             wait();
        } catch (InterruptedException e) {
                e.printStackTrace();}
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName()+ " : main thread running loop count -- " + i);
            try {Thread.sleep(1000);
            }catch (InterruptedException e) {
                e.printStackTrace();}
        }
        subFlag = true;
        notify();
    }

        public synchronized void subMethod() {
        while (!subFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();}
        }
        for (int i = 0; i < 10; i++) {
            System.err.println(Thread.currentThread().getName()+ " : sub thread running loop count -- " + i);
            try {Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();}
        }

        subFlag = false;
        notify();
    }
}
