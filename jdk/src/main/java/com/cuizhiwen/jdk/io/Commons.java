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
     *
     * 分类：抽象基类
     *      字符   （ Reader 、writer  ）
     *      字节   (inputStream 、outputStream） 不支持缓存。
     *
     *      底层节点流（底层物理节点） 可以从/向特定Io设备读写数据的流。
     *      上层处理流 ( 底层物理节点流可以被包装成处理流，提供统一代码读取) 可嫁接在任何已存在的流基础上，装饰器模式
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
    }
}
