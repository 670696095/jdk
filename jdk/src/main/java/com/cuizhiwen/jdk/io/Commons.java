package com.cuizhiwen.jdk.io;

import java.io.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/10 16:10
 */
public class Commons {
    /**
     * IO流：
     *      输入流:程序读取外部数据（磁盘，光盘等）到内存。
     *      输出流:程序把数据从内存输出到存储设备中。
     *      Java.io 包几乎包含了所有操作输入、输出需要的类。所有这些流类代表了输入源和输出目标。
     *      Java.io 包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。
     *
     * 分类：抽象基类
     *      字符   （ Reader 、writer  ）
     *      字节   (inputStream 、outputStream） 不支持缓存。
     *
     *      底层节点流（底层物理节点） 可以从/向特定Io设备读写数据的流。
     *      上层处理流 ( 底层物理节点流可以被包装成处理流，提供统一代码读取) 可嫁接在任何已存在的流基础上，装饰器模式
     * FileInputStream:
     *      有多种构造方法可用来创建对象。
     *          可以使用字符串类型的文件名来创建一个输入流对象来读取文件：
     *          InputStream f = new FileInputStream("C:/java/hello");
     *          也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：
     *          File f = new File("C:/java/hello");
     *          InputStream out = new FileInputStream(f);
     * File类：
     *       mkdir( )方法创建一个文件夹，成功则返回true，失败则返回false。失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
     *       mkdirs()方法创建一个文件夹和它的所有父文件夹。
     */

    public static void main(String[] args) throws IOException {
        File file = new File("E:/xiaocui.txt");
        InputStream in = new FileInputStream(file);
        byte[] byteData = new byte[8];
        // 从in 这个流中读取数据，每次最多读取200个字节，赋给byteData,
        // 返回值是一次实际读取的字节个数赋给length, 比如现在的流中只有150个字节，则第一次循环的时候length = 150
        // 第二次条件判断 length = -1 , 结束读取操作
        int count = 0;
        int temp;
        while ((temp = in.read()) != -1) {
            /**
             * 将读到的字节存储到byte数组中
             */
            byteData[count++] = (byte) temp;
        }
        /**
         * IO资源不属于内存资源，DC无法回收，应显示关闭。
         */
        in.close();
        System.out.println(new java.lang.String(byteData));


        File file1 = new File("E:/out.txt");
        OutputStream out = new FileOutputStream(file1);
        String string = "789";
        byte[] bytes = string.getBytes();
        out.write(bytes);
        out.close();


        String dirname = "/tmp/user/java/bin";
        File d = new File(dirname);
        // 现在创建目录
        d.mkdirs();

    }


}
