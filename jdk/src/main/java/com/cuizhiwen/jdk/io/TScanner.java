package com.cuizhiwen.jdk.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/26 10:12
 */
public class TScanner {
    /**
     * next() 与 nextLine() 区别
     *      next():
     *          1、一定要读取到有效字符后才可以结束输入。
     *          2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
     *          3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
     *          4、next() 不能得到带有空格的字符串。
     *      nextLine()：
     *          1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
     *          2、可以获得空白。
     * 控制台的输出由 print( ) 和 println() 完成:
     *          这些方法都由类 PrintStream 定义，System.out 是该类对象的一个引用。
     *          PrintStream 继承了 OutputStream类，并且实现了方法 write()。这样，write() 也可以用来往控制台写操作。
     *          println() 是一个方法。
     *          System 是系统类。
     *          out 是标准输出对象。
     */
    public static void main(String[] args) throws IOException{
        BRRead();
        BRReadLines();
        ScannerDemo1();
        WriteDemo();
    }

    private static void BRRead () throws IOException {
        char c;
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符, 按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }

    private static void BRReadLines () throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
    private static void ScannerDemo1(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }
    private static void ScannerDemo2(){
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // nextLine方式接收字符串
        System.out.println("nextLine方式接收：");
        // 判断是否还有输入
        if (scan.hasNextLine()) {
            String str2 = scan.nextLine();
            System.out.println("输入的数据为：" + str2);
        }
        scan.close();
    }

    private static void WriteDemo(){
        int b;
        b = 'A';
        System.out.write(b);
        System.out.write('\n');
    }
}
