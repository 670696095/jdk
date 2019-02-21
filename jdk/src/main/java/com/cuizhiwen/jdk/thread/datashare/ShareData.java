package com.cuizhiwen.jdk.thread.datashare;

/**
 * @author 01418061(cuizhiwen)
 * @Description:   共享数据类
 * @date 2019/2/21 14:34
 */
public class ShareData {
    /**
     * 在 Java 传统线程机制中的共享数据方式，大致可以简单分两种情况：
     *      ➢ 多个线程行为一致，共同操作一个数据源。也就是每个线程执行的代码相同，可以使用同一个 Runnable 对
     *      象，这个 Runnable 对象中有那个共享数据，例如，卖票系统就可以这么做。
     *      ➢ 多个线程行为不一致，共同操作一个数据源。也就是每个线程执行的代码不同，这时候需要用不同的
     *      Runnable 对象。例如，银行存取款。
     */

    /**
     * 多个线程行为一致共同操作一个数据
     */
    private int num = 10 ;
    public synchronized void inc() {
            num++;
            System.out.println(Thread.currentThread().getName()+": invoke inc method num =" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    /**
     *多线程类
     **/
    static class RunnableCusToInc implements Runnable {
        private ShareData shareData;

        public RunnableCusToInc(ShareData shareData) {
            this.shareData = shareData;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                shareData.inc();
            }
        }

    }

    /**
     *测试方法
     **/
    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        for (int i = 0; i < 4; i++) {
            new Thread(new RunnableCusToInc(shareData),"Thread "+ i).start();
        }
    }
    }
