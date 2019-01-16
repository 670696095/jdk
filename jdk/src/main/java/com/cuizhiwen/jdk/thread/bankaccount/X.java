package com.cuizhiwen.jdk.thread.bankaccount;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 13:25
 */
public class X {
    /**
     * 同步锁
     * ReentrantLock ：可重入锁
     *      一个线程可以对已被加锁的ReentrantLock锁再次加锁，ReentrantLock对象会维持一个计数器来追踪lock()方法的嵌套调用，
     *      线程在每次调用lock()加锁后，必须显示调用unlock()来释放锁，所以一段被锁保护的代码可以调用另一个被相同锁保护的方法。
     */

    /**
     * 定义锁对象
     */
    private final ReentrantLock lock = new ReentrantLock();

    /**
     * 定义需要保护线程安全的方法
     */
    public void m(){
        //加锁
        lock.lock();
        try
        {
            //method body
        } catch (Exception e)
        {
            e.getStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

}
