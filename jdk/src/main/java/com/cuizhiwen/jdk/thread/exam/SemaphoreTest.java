package com.cuizhiwen.jdk.thread.exam;

import java.util.concurrent.Semaphore;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/28 9:19
 */
public class SemaphoreTest {
    /**
     * 控制某个方法允许并发访问线程的个数
     */
    static Semaphore semaphore = new Semaphore(5, true);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    test();
                }
            }).start();
        }

    }

    public static void test() {
        try {
            //申请一个请求
            semaphore.acquire();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "进来了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "走了");
        //释放一个请求
        //semaphore.release();
    }
}

