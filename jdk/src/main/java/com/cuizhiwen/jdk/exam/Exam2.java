package com.cuizhiwen.jdk.exam;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/12 17:04
 */
public class Exam2 {
    public static void main(String[] args) {
        System.out.println(Price.INSTANCE.currentPrice);
        Price price = new Price(2.8);
        System.out.println(price.currentPrice);
    }
    static  class Price{
        final static Price INSTANCE = new Price(2.8);
        static  double initPrice = 20;
        double currentPrice ;
        public Price(double discount) {
            currentPrice = initPrice - discount;
        }
    }
}
