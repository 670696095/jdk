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
     *      (循环体中的字符串连接推荐使用StringBuilder的append进行扩展，因为string会不断创建对象，造成内存资源浪费）
     *      new关键字创建String时，会先使用常量池，再调用构造器创建一个新string 保存在堆中。
     *
     * String s = "Hello";s = s + " world!";这两行代码执行后，原始的 String 对象中的内容到底变了没有？
     *      答:  没有。因为 String 被设计成不可变(immutable)类，所以它的所有对象都是不可变对象。在这段代码中，s 原先指
     *      向一个 String 对象，内容是 "Hello"，然后我们对 s 进行了“+”操作，那么 s 所指向的那个对象是否发生了改变呢？
     *      答案是没有。这时，s 不指向原来那个对象了，而指向了另一个 String 对象，内容为"Hello world!"，原来那个对象还
     *      存在于内存之中，只是 s 这个引用变量不再指向它了。通过上面的说明，我们很容易导出另一个结论，
     *      如果经常对字符串进行各种各样的修改，或者说，不可预见的修改，那么使用 String 来代表字符串的话会引起很大的内存开销。
     *      因为 String 对象建立之后不能再改变，所以对于每一个不同的字符串，都需要一个 String 对象来表示。这时，应该考虑使用
     *      StringBuffer 类，它允许修改，而不是每个不同的字符串都要生成一个新的对象s = new String("Initial Value");
     *      每次都会调用构造器，生成新对象，性能低下且内存开销大，并且没有意义，因为 String 对象不可改变，所
     *      以对于内容相同的字符串，只要一个 String 对象来表示就可以了。也就说，多次调用上面的构造器创建多个对象，他
     *      们的 String 类型属性 s 都指向同一个对象。上面的结论还基于这样一个事实：对于字符串常量，如果内容相同，
     *      Java 认为它们代表同一个 String 对象。而用关键字 new 调用构造器，总是会创建一个新的对象，无论内容是否相同。
     *      至于为什么要把 String 类设计成不可变类，是它的用途决定的。其实不只 String，很多 Java 标准类库中的类都是不可变的
     *      不可变类有一些优点，比如因为它的对象是只读的，所以多线程并发访问也不会有任何问题。当然也有一些缺点，比如每个不同的状态都要一个对象来
     *      代表，可能会造成性能上的问题。所以 Java 标准类库还提供了一个可变版本，即 StringBuffer
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

        String s6 = "Hello";
        String s5 = s6 + " world!";

        String s7 = "Initial Value";
        //总会产生一个新的对象，并且浪费一块内存
        String s8 = new String("Initial Value");


    }
}
