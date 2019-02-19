package com.cuizhiwen.jdk.io;

import com.cuizhiwen.jdk.common.clone.Age;
import com.cuizhiwen.jdk.common.clone.Person;

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
     *      按照实现功能分：
     *          1)节点流（可以从或向一个特定的地方（节点）读写数据。如 FileReader）和2)处理流（是对一个
     *          已存在的流的连接和封装，通过所封装的流的功能调用实现数据读写。如 BufferedReader。处理流的构造方法总是要
     *          带一个其他的流对象做参数。一个流对象经过其他流的多次包装，称为流的链接。
     *      按照处理数据的单位：
     *          字节流和字符流。字节流继承于 InputStream 和 OutputStream，
     *          字符流继承于InputStreamReader 和 OutputStreamWrite
     *
     *      Java.io 包几乎包含了所有操作输入、输出需要的类。所有这些流类代表了输入源和输出目标。
     *      Java.io 包中的流支持很多种格式，比如：基本类型、对象、本地化字符集等等。
     *
     * 分类：抽象基类
     *      字符   （ Reader 、writer  ）
     *      字节   (inputStream 、outputStream） 不支持缓存。
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
     *
     * 字节流和字符流的区别：
     *      1>字节流读取的时候，读到一个字节就返回一个字节； 字符流使用了字节流读到一个或多个字节（中文对应的字节
     *      数是两个，在 UTF-8 码表中是 3 个字节）时。先去查指定的编码表，将查到的字符返回。 字节流可以处理所有类型数
     *      据，如：图片，MP3，AVI 视频文件，而字符流只能处理字符数据。只要是处理纯文本数据，就要优先考虑使用字符
     *      流，除此之外都用字节流。字节流主要是操作 byte 类型数据，以 byte 数组为准，主要操作类就是 OutputStream、InputStream
     *
     *      2>字符流处理的单元为 2 个字节的 Unicode 字符，分别操作字符、字符数组或字符串，而字节流处理单元为 1 个字
     *      节，操作字节和字节数组。所以字符流是由 Java 虚拟机将字节转化为 2 个字节的 Unicode 字符为单位的字符而成的，
     *      所以它对多国语言支持性比较好！如果是音频文件、图片、歌曲，就用字节流好点，如果是关系到中文（文本）的，用
     *      字符流好点。在程序中一个字符等于两个字节，java 提供了 Reader、Writer 两个专门操作字符流的类。
     * 注意:
     *      使用 Unicode 意味着字符在 JVM 内部和外部有不同的表现形式，在 JVM 内部都是 Unicode，当这个字符被
     *      从 JVM 内部转移到外部时（例如存入文件系统中），需要进行编码转换。所以 Java 中有字节流和字符流，以及在字
     *      符流和字节流之间进行转换的转换流，如 InputStreamReader 和 OutputStreamReader，这两个类是字节流和字符
     *      流之间的适配器类，承担了编码转换的任务；
     */

    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

        /**
         * 将一个 java 对象序列化到文件里
         */
        //对象输出流
        ObjectOutputStream objectOutputStream =
                new ObjectOutputStream(new FileOutputStream(new File("D://obj")));
        objectOutputStream.writeObject(new Person(new Age(18), "cui"));
        objectOutputStream.close();
        //对象输入流
        ObjectInputStream objectInputStream =
                new ObjectInputStream(new FileInputStream(new File("D://obj")));
        Person person = (Person)objectInputStream.readObject();
        System.out.println(person);
        objectInputStream.close();

    }


}
