package com.cuizhiwen.jdk.thread.bankaccount;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 10:46
 */
@Data
public class DrawThread extends Thread {
    /**
     *  同步代码块
     */

    /**
     *取钱的用户
     */
    private Account account;
    /**
     *当前线程所希望取的钱
     */
    private double drawAmount;

    public DrawThread(String name , Account account, double drawAmount)
    {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    @Override
    public void run() {
        /**
         * 同步代码块
         * account为同步监视器
         *         我们可以把同步监视器理解成一个门，要锁定的代码理解成门后的东西。我们要禁止其他人通过门去访问门后的东西，那就要把门锁住。
         */
        synchronized (account)
        {
            if(account.getBalance() >= drawAmount){
                System.out.println(getName()+"取钱成功，吐出钞票："+ drawAmount);
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            }else{
                System.out.println(getName()+"取钱失败，余额不足");
            }
        }
        System.out.println(getName()+"测试同步代码块后面的代码能否执行！ 答案是:不执行");
        account.draw(drawAmount);
    }
}
