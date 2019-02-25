package com.cuizhiwen.jdk.thread.concurrent.c;

import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/25 9:35
 */
public class ConcurrentLinkedQueueTest {
    public static int threadCount = 5;
    public static ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();

    static class Offer implements Runnable {
        @Override
        public void run() {
            //不建议使用 queue.size()==0，影响效率。可以使用!queue.isEmpty()
            if(queue.isEmpty()){
                String ele = new Random().nextInt(Integer.MAX_VALUE)+"";
                queue.offer(ele);
                System.out.println("入队元素为: "+ele);
            }
        }
    }
    static class Poll implements Runnable {
        @Override
        public void run() {
            if(!queue.isEmpty()){
                String ele = queue.poll();
                System.out.println("出队元素为"+ele);
            }
        }
    }
    public static void main(String[] agrs) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int x=0;x<threadCount;x++){
            executorService.submit(new Offer());
            executorService.submit(new Poll());
        }
        executorService.shutdown();
    }
}
