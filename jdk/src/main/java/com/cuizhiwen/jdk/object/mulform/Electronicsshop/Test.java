package com.cuizhiwen.jdk.object.mulform.Electronicsshop;

public class Test {
    public static final int THINKPAD = 0;
    public static final int MOUSE = 1;
    public static final int KEYBOARD = 2;

    public static void main(String[] args){

        //添加进购物车
        ShopCar shopcar = new ShopCar();
        shopcar.add(new Thinkpad());
        shopcar.add(new Mouse());
        shopcar.add(new Keyboard());

        //获取大小
        System.out.println("购物车存放的电子产品数量为 ——> "+shopcar.getSize());


        //开始测试thinkpad电脑
        Thinkpad thinkpad = (Thinkpad)shopcar.getListItem(THINKPAD);
        thinkpad.boot();
        thinkpad.program();

        System.out.println("-------------------");

        //开始测试Mouse鼠标
        Mouse mouse = (Mouse)shopcar.getListItem(MOUSE);
        mouse.move();
        mouse.onClick();

        System.out.println("-------------------");

        //开始测试Keyboard键盘
        Keyboard keyboard = (Keyboard)shopcar.getListItem(KEYBOARD);
        keyboard.input();
    }



}
