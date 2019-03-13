package com.cuizhiwen.jdk.java8.Lambda;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/13 10:55
 */
public class Lam1 {
    /**
     *  用 lambda 表达式实现 Runnable
     *
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     * 例如，如果你的方法不对参数进行修改、重写，只是在控制台打印点东西的话，那么可以这样写：
     * () -> System.out.println("Hello Lambda Expressions");
     * 如果你的方法接收两个参数，那么可以写成如下这样：
     * (int even, int odd) ) -> even + odd
     * @param args
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        }).start();

        new Thread(()->System.out.println("2")).start();
    }
}
