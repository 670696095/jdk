package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 15:44
 */
public class DeadLockA extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("LockA running");
            while(true){
                synchronized(Client.obj1){
                    System.out.println("LockA locked obj1");
                    //获取obj1后先等一会儿，让LockB有足够的时间锁住obj2
                    Thread.sleep(100);
                    System.out.println("LockA trying to lock obj2...");
                    synchronized(Client.obj2){
                        System.out.println("LockA locked obj2");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
