package com.cuizhiwen.jdk.thread.bankaccount;

import lombok.Data;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 10:33
 */
@Data
public class Account {
    /**
     *  同步方法 / 同步锁
     * 1> 在Account类中定义draw（）方法，而不是直接在run（）方法中实现取钱逻辑，这种做法更符合面向对象规则。
     *     DDD设计方式，即Domain Driven Design(领域驱动设计)，认为每个类都应该是完备的领域对象，
     *     Account代表用户账户，就应该提供用户的相关方法，通过draw()方法执行取钱操作，而不是直接将setBalance方法暴露出来任人操作。
     *
     * 2> 使用Lock与使用同步代码块有点类似，只是使用Lock时可以显示使用Lock对象作为同步锁，而使用同步方法时系统隐式使用当前对象作为同步监视器。
     *    使用Lock时每个Lock对象对应一个Account对象，一样可以保证对于同一个Account对象，同一时刻只能有一个线程进入临界区。
     *    Lock提供了同步方法和同步代码块所没有的其他功能，包括使用非块状结构的tryLock（）方法，以及试图获得可中断锁的lockInterruptibly（）方法，
     *    还有获取超时失效锁的tryLock（long，TimeUnit）方法。
     */

    private final ReentrantLock lock = new ReentrantLock();

    public Account(String accountNo, double balance) {
        super();
        this.accountNo = accountNo;
        this.balance = balance;
    }
    private String accountNo ;
    private double balance;

    /**
     *   同步方法:
     *
     *   提供一个线程安全的draw（）方法完成取钱的操作
     */
    public synchronized void draw(double drawAmount)
    {
        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
            try{
                Thread.sleep(1);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
            balance-=drawAmount;
            System.out.println("\t余额为："+balance);
        }else{
            System.out.println(Thread.currentThread().getName()+"取钱失败，余额不足");
        }
    }

    /**
     * 同步锁
     * @param drawAmount
     */
    public void drawLock(double drawAmount)
    {
        lock.lock();
        try
        {
            if(balance>=drawAmount){
                System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
                try{
                    Thread.sleep(1);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                balance-=drawAmount;
                System.out.println("\t余额为："+balance);
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱失败，余额不足");
            }
        } finally {
            lock.unlock();
        }
    }

}
