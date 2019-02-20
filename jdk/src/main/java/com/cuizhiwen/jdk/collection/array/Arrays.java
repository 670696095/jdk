package com.cuizhiwen.jdk.collection.array;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 17:08
 */
public class Arrays {
    /**
     *数组:用一个表示符封装在一起具有相同类型的对象 或 基本类型数据序列。数组是对象，由jvm直接创建。
     *数组和链表的区别：
     *    1.数组是将元素在内存中连续存储的；它的优点：因为数据是连续存储的，内存地址连续，所以在查找数据的时候效
     *      率比较高；它的缺点：在存储之前，我们需要申请一块连续的内存空间，并且在编译的时候就必须确定好它的空间的大
     *      小。在运行的时候空间的大小是无法随着你的需要进行增加和减少而改变的，当数据两比较大的时候，有可能会出现
     *      越界的情况，数据比较小的时候，又有可能会浪费掉内存空间。在改变数据个数时，增加、插入、删除数据效率比较低。
     *
     *    2.链表是动态申请内存空间，不需要像数组需要提前申请好内存的大小，链表只需在用的时候申请就可以，根据需
     *      要来动态申请或者删除内存空间，对于数据增加和删除以及插入比数组灵活。还有就是链表中数据在内存中可以在任
     *      意的位置，通过应用来关联数据（就是通过存在元素的指针来联系）
     * 链表和数组使用场景
     *      1.数组应用场景：数据比较少；经常做的运算是按序号访问数据元素；数组更容易实现，任何高级语言都支持；构建的线性表较稳定。
     *      2.链表应用场景：对线性表的长度或者规模难以估计；频繁做插入删除操作；构建动态性比较强的线性表。
     */
    public static void main(String[] args) {

        /**
         * 静态初始化
         */
        int[] intArr;
        intArr = new int[]{1,2,3};
        /**
         * 隐式初始化
         */
        int [] arr ={1,2,3};
        /**
         * 动态初始化
         */
        int [] prices = new int[5];
        /**
         * 二维数组
         */
        int [][] in   = {{1,2,3},{4,5}};
        int [][] ints = new int[4][5];
        /**
         * 变长二维数组
         */
        int [][] intss = new int[4][];
        intss[0] = new int[2];
    }
}
