package com.cuizhiwen.jdk.common.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/9 10:06
 */
public class Exception {
    /**
     * 异常: Throwable是所有Java程序中错误处理的父类 ，有两种子类：Error和Exception。
     *                  Error是错误，java.lang.Error 
     *                  Exception是异常，java.lang.Exception
     *
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
     * 两小原则: 1> 子类方法声明抛出异常类型是父类方法抛出异常类型子类或者相同。
     *         2> 子类方法抛出异常不能比父类多。
     *
     * RuntimeException:InputMismatchException 输入不匹配异常 ArithmeticException 算术运算异常 NullPointerException 空指针异常
     *                  ArrayIndexOutOfBoundsException 数组下标越界异常   ClassCastException 类型转换异常
     * checked：        IOException 文件异常  SQLException SQL数据库错误异常
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
     *
     * 2、在多重catch块后面，可以加一个catch（Exception）来处理可能会被遗漏的异常；
     *
     * 3、对于不确定的代码，也可以加上try-catch，处理潜在异常；
     *
     * 4、尽量去处理异常，切忌只是简单的调用printStackTrace()去打印输出；
     *
     * 5、具体如何处理异常，要根据不同的业务需求和异常类型去决定；
     *
     * 6、尽量添加finally语句块去释放占用的资源。
     *
     */
    public static void main(String[] args)
            throws java.lang.Exception
    {
        // 因为test()方法声明抛出IOException异常，
        // 所以调用该方法的代码要么处于try...catch块中，
        // 要么处于另一个带throws声明抛出的方法中。
        test();

    }
    public static void test()throws IOException
    {
        // 因为FileInputStream的构造器声明抛出IOException异常，
        // 所以调用FileInputStream的代码要么处于try...catch块中，
        // 要么处于另一个带throws声明抛出的方法中。
        FileInputStream fis = new FileInputStream("a.txt");
    }


}
