package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 11:00
 */
public class DataType {
    /**
     * java数据类型:
     *          变量就是申请内存来存储值。也就是说，当创建变量的时候，需要在内存中申请空间。
     *          内存管理系统根据变量的类型为变量分配存储空间，分配的空间只能用来储存该类型数据。
     *      Java 的两大数据类型:
     *          内置数据类型
     *          引用数据类型
     *
     * Java语言提供了八种基本类型:
     *          六种数字类型（四个整数型，两个浮点型），一种字符类型，还有一种布尔型。
     * 数据类型转换:
     *          byte->short->char->int->long->float->double
     *      数据类型转换必须满足如下规则：
     *          1. 不能对boolean类型进行类型转换。
     *          2. 不能把对象类型转换成不相关类的对象。
     *          3. 在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
     *          4. 转换过程中可能导致溢出或损失精度
     *          5. 浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入。
     * java引用类型:
     *      在Java中，引用类型的变量非常类似于C/C++的指针。引用类型指向一个对象，指向对象的变量是引用变量。
     *      这些变量在声明时被指定为一个特定的类型,变量一旦声明后，类型就不能被改变了。
     *          1>对象、数组都是引用数据类型。
     *          2>所有引用类型的默认值都是null。
     * Java 常量
     *      常量在程序运行时是不能被修改的。
     *      在 Java 中使用 final 关键字来修饰常量，声明方式和变量类似：
     *      虽然常量名也可以用小写，但为了便于识别，通常使用大写字母表示常量。
     * 自动类型转换:
     *      必须满足转换前的数据类型的位数要低于转换后的数据类型，
     * 隐含强制类型转换：
     *      1. 整数的默认类型是 int。
     *      2. 浮点型不存在这种情况，因为在定义 float 类型时必须在数字后面跟上 F 或者 f。
     *
     */
    public static void main(String[] args) {
        /**
         * 8位 -128 ~  127
         */
        byte b = -128;
        /**
         * 16位 -32768 ~ 32767
         */
        short s = -32768;
        /**
         * 32位
         */
        int i = 1;
        /**
         * 64位
         */
        long l = 10000L;
        /**
         * 浮点型 32位 / 64位
         * 浮点数不能用来表示精确的值，如货币；
         */
        float f = 234.5f;
        double d = 123.5;
        double d1 = 3.14E3;
        final double PI = 3.1415927;
        /**
         * 字符型 16 位 Unicode 字符 0~65535
         */
        char c ='A';
        char c1 = 65535;
        /**
         * 布尔型
         */
        boolean boo = true;



            // byte
            System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);
            System.out.println("包装类：java.lang.Byte");
            System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);
            System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);
            System.out.println();

            // short
            System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
            System.out.println("包装类：java.lang.Short");
            System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);
            System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);
            System.out.println();

            // int
            System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);
            System.out.println("包装类：java.lang.Integer");
            System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);
            System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);
            System.out.println();

            // long
            System.out.println("基本类型：long 二进制位数：" + Long.SIZE);
            System.out.println("包装类：java.lang.Long");
            System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);
            System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);
            System.out.println();

            // float
            System.out.println("基本类型：float 二进制位数：" + Float.SIZE);
            System.out.println("包装类：java.lang.Float");
            System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);
            System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);
            System.out.println();

            // double
            System.out.println("基本类型：double 二进制位数：" + Double.SIZE);
            System.out.println("包装类：java.lang.Double");
            System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);
            System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);
            System.out.println();

            // char
            System.out.println("基本类型：char 二进制位数：" + Character.SIZE);
            System.out.println("包装类：java.lang.Character");
            // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台
            System.out.println("最小值：Character.MIN_VALUE="
                    + (int) Character.MIN_VALUE);
            // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台
            System.out.println("最大值：Character.MAX_VALUE="
                    + (int) Character.MAX_VALUE);
        }



}
