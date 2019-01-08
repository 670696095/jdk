package com.cuizhiwen.jdk.string;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 16:41
 */
public class StringBu {
    /**
     * 运行速度快慢为：StringBuilder > StringBuffer > String
     *              原因:
     *              String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，
     *              即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的。
     *
     *           String：适用于少量的字符串操作的情况
     *
     * 　　       StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
     *
     * 　　       StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况,很多方法可以带有synchronized关键字
     */
}
