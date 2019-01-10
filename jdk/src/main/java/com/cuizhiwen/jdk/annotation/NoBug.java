package com.cuizhiwen.jdk.annotation;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/10 14:01
 */
public class NoBug {

    @Jiecha
    public void suanShu() {
        System.out.println("1234567890");
    }

    @Jiecha
    public void jiafa() {
        System.out.println("1+1=" + 1 + 1);
    }

    @Jiecha
    public void jiefa() {
        System.out.println("1-1=" + (1 - 1));
    }

    @Jiecha
    public void chengfa() {
        System.out.println("3 x 5=" + 3 * 5);
    }

    @Jiecha
    public void chufa() {
        System.out.println("6 / 0=" + 6 / 0);
    }

    public void ziwojieshao() {
        System.out.println("我写的程序没有 bug!");
    }

}