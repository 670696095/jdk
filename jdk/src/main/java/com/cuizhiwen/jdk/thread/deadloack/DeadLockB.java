package com.cuizhiwen.jdk.thread.deadloack;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 15:45
 */
public class DeadLockB extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("LockB running");
            while(true){
                synchronized(Client.obj2){
                    System.out.println("LockB locked obj2");
                    System.out.println("LockB trying to lock obj1...");
                    synchronized(Client.obj1){
                        System.out.println("LockB locked obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
