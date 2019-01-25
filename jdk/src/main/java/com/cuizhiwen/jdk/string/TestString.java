package com.cuizhiwen.jdk.string;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 14:33
 */
public class TestString {
    /**
     * String类
     *      在java.lang包中,用final修饰，对象创建后不可以修改，赋值后将会生成新的对像来存放新的内容，原先的对象依旧在内存中。
     *
     *      (循环体中的字符串连接推荐使用StringBuilder的append进行扩展，因为string会不断创建对象，造成内存资源浪费）
     *
     *      new关键字创建String时，会先使用常量池，再调用构造器创建一个新string 保存在堆中。
     */

    public static void main(String[] args) {
        /**
         * 声明
         */
        String string;
        /**
         * 声明并初始化
         */
        String str = " cui:zhi:wen ";

        /**
         * 1>charAt() 从字符串中取出指定位置的字符
         */
        char ch = str.charAt(2);
        /**
         * 2>toCharArray() 将字符串变成一个字符数组
         */
        char c[] = str.toCharArray();
        /**
         * 3>toUpperCase() toLowerCase()；字符串大小写的转换
         */
        str.toUpperCase();
        /**
         * 4>String[] split("字符")　　根据给定的正则表达式的匹配来拆分此字符串。
         */
        String[] arr1 = str.split(":");
        /**
         * 5>trim() 去左右空格
         */
        str.trim();
        /**
         * 6>replace() 替换
         *   replaceAll(String,String) 将某个内容全部替换成指定内容
         */
        str.replace(" ","");
        /**
         * 7>substring(int beginIndex,int endIndex) 截取字符串　
         */
        str.substring(0,3);
        /**
         * 8>equalsIgnoreCase(String) 忽略大小写的比较两个字符串的值是否一模一样，返回一个布尔值
         */
        str.equalsIgnoreCase(" CUI:ZHI:WEN ");
        /**
         * 9>boolean contains(String) 判断一个字符串里面是否包含指定的内容，返回一个布尔值
         */
        str.contains("cui");

        /**
         * java会确保每个字符串常量只有一个，不会产生副本
         */
        String s0 = "hello";
        String s1 = "hello";
        String s2 = "he"+"llo";
        System.out.println(s0==s1);
        System.out.println(s0==s2);

        char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
        String helloString = new String(helloArray);
        System.out.println( helloString );


    }
}
