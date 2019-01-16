package com.cuizhiwen.jdk.thread.bankaccount;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 10:59
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("01418061", 1000);
        new DrawThread("甲", account, 600).start();
        new DrawThread("乙", account, 600).start();

    }

}
