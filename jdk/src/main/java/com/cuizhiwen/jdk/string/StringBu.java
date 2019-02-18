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
     *            String：适用于少量的字符串操作的情况
     * 　　       StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
     * 　　       StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况,很多方法可以带有synchronized关键字、
     *
     *
     *  注意:
     *      1>在 Java 中无论使用何种方式进行字符串连接，实际上都使用的是 StringBuilder。但是+ 操作会创建多个StringBuilder对象，增加了内存开支，
     *      在使用 StringBuilder 时要注意，尽量不要"+"和 StringBuilder 混着用，否则会创建更多的 StringBuilder对象。
     *      2>StringBuilder、StringBuffer 的方法都会调用 AbstractStringBuilder 中的公共方法，如 super.append(...)。
     *      只是 StringBuffer 会在方法上加 synchronized 关键字，进行同步。最后，如果程序不是多线程的，那么使用
     *      StringBuilder 效率高于 StringBuffer
     *
     *
     */
    public static void main(String[] args) {
        String str = "abc";
        StringBuilder sbd = new StringBuilder(10);
        StringBuffer  sbf = new StringBuffer(20);
        /**
         * 1. String 对象的 intern（）方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与
         * String 对象的 equals 结果是 true），如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返
         * 回常量池中字符串的引用；
         * 2. 字符串的+操作其本质是创建了 StringBuilder 对象进行 append 操作，然后将拼接后的 StringBuilder 对
         * 象用 toString 方法处理成 String 对象，这一点可以用 javap -c StringEqualTest.class 命令获得 class 文件对应
         * 的 JVM 字节码指令就可以看出来。
         */
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
         System.out.println(s1 == s2); //false
         System.out.println(s1 == s5); //true
         System.out.println(s1 == s6); //false
         System.out.println(s1 == s6.intern()); //true
         System.out.println(s2 == s2.intern()); //false
        System.out.println(s1==s2.intern());//true
         }

}
