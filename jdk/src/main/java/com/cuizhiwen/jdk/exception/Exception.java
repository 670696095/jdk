package com.cuizhiwen.jdk.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/9 10:06
 */
public class Exception extends Throwable{
    /**
     * 异常: Throwable是所有Java程序中错误处理的父类 ，有两种子类：Error和Exception。
     *                  Error是错误，java.lang.Error  （AwtError ThreadDeath）
     *                      Error 类一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢出等。对于这类
     *                      错误的导致的应用程序中断，仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。
     *                  Exception是异常，java.lang.Exception 子类是IOException 类和 RuntimeException 类。
     *                      Exception 类表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复
     *                      运行，而不应该随意终止异常。
     *  Java的异常被分为两大类：Checked异常和Runtime异常（运行时异常）

     *                 1>Checked异常都是可以被处理（修复）的异常，所以Java程序必须显示处理Checked异常。如果程序没有处理Checked异常，
     *                 该程序在编译时就会发生错误，无法通过编译，对于Checked异常处理方式有如下两种：
     *                      （1）当前方法明确知道如何处理该异常，程序应该使用try...catch块来捕获该异常，然后在对应的catch块中修改该异常。
     *                      （2）当前方法不知道如何处理这种异常，应该在定义该方法时声明抛出该异常。
     *                 2>Runtime异常无需显式声明抛出，如果程序需要捕捉Runtime异常，也可以使用try...catch块来捕捉Runtime异常。
     *
     * 注意:出现运行时异常后，系统会把异常一直往上层抛，一直遇到处理代码。如果没有处理块，到最上层，
     *     如果是多线程就由Thread.run()抛出，如果是单线程就被main()抛出。
     *
     *
     * 两小原则: 1> 子类方法声明抛出异常类型是父类方法抛出异常类型子类或者相同。
     *         2> 子类方法抛出异常不能比父类多。
     *
     * RuntimeException:InputMismatchException 输入不匹配异常 ArithmeticException 算术运算异常 NullPointerException 空指针异常
     *                  ArrayIndexOutOfBoundsException 数组下标越界异常   ClassCastException 类型转换异常
     *                  IllegalArgumentException方法传递参数错误。
     *
     * checked：        IOException 文件异常  SQLException SQL数据库错误异常 ClassNotFoundException
     *
     *
     * 处理异常一般三种方式： 1>使用 try-catch-finally 来捕获和处理异常 (catch里的异常列表一般是子类在前，父类(Exception)在后)
     *                    2>使用throws关键字声明将要抛出何种类型的异常
     *                    3>自定义异常
     *
     * e.printStackTrace(): 跟踪栈总是最内部方法被调用并逐级上升，直到最外层业务操作的起点，通常为main或者thread类的run()方法。
     *
     * Java异常处理实际应用中的经验与总结：
     *
     * 1、处理运行时异常时，采用逻辑去合理规避同时辅助try-catch处理；
     * 2、在多重catch块后面，可以加一个catch（Exception）来处理可能会被遗漏的异常；
     * 3、对于不确定的代码，也可以加上try-catch，处理潜在异常；
     * 4、尽量去处理异常，切忌只是简单的调用printStackTrace()去打印输出；
     * 5、具体如何处理异常，要根据不同的业务需求和异常类型去决定；
     * 6、尽量添加finally语句块去释放占用的资源。
     *
     *Exception（异常）
     * 是程序本身可以处理的异常。主要包含RuntimeException等运行时异常和IOException，SQLException等非运行时异常。
     *      运行时异常 包括：都是RuntimeException类及其子类异常，如NullPointerException(空指针异常)、IndexOutOfBoundsException(下标越界异常)等，
     *      这些异常是不检查异常，程序中可以选择捕获处理，也可以不处理。这些异常一般是由程序逻辑错误引起的，程序应该从逻辑角度尽可能避免这类异常的发生。
     *      运行时异常的特点是Java编译器不会检查它，也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明抛出它，
     *      也会编译通过。
     *      非运行时异常（编译异常） 包括：RuntimeException以外的异常，类型上都属于Exception类及其子类。从程序语法角度讲是必须进行处理的异常，
     *      如果不处理，程序就不能编译通过。如IOException、SQLException等以及用户自定义的Exception异常，一般情况下不自定义检查异常
     *
     */
    public static void main(String[] args)
            throws java.lang.Exception
    {
        // 因为test()方法声明抛出IOException异常，
        // 所以调用该方法的代码要么处于try...catch块中，
        // 要么处于另一个带throws声明抛出的方法中。
        //test();
        System.out.println(getNum());



    }
    public static void test()throws IOException
    {
        // 因为FileInputStream的构造器声明抛出IOException异常，
        // 所以调用FileInputStream的代码要么处于try...catch块中，
        // 要么处于另一个带throws声明抛出的方法中。
        FileInputStream fis = new FileInputStream("a.txt");
    }

    public static int getNum(){
        try {
            int a = 1/0;
            return 1;
        } catch (java.lang.Exception e) {
            return 2;
        }finally{
            return 3;
        }
    }


}
