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
    private Account account;

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

        account.draw(drawAmount);
    }
}
