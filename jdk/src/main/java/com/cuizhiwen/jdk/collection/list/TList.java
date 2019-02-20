package com.cuizhiwen.jdk.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 16:24
 */
public class TList {
    /**
     * List:
     *      可以重复并且有序
     * ArrayList linkedList:
     *      ArrayList、数组方式存储，有连续索引便于查找 不利于删除，插入（会影响固定元素位置）数组元素数量大于实际存储。允许重复
     *      LinkedList、双向链表存储 不利于查找（没有索引不利于快速查询） 便于插入 删除
     *      voctor 底层结构是数组 线程安全的,增删慢,查询慢
     * List和Set：
     *      List 和 Set 是存储单列数据的集合，
     *      Map 是存储键和值这样的双列数据的集合；
     *      List 中存储的数据是有顺序，并且允许重复；
     *      Map 中存储的数据是没有顺序的，其键是不能重复的，它的值是可以有重复的，
     *      Set 中存储的数据是无序的，且不允许有重复，但元素在集合中的位置由元素的 hashcode 决定，位置是固定的（Set 集合根据 hashcode 来
     *          进行数据的存储，所以位置是固定的，但是位置不是用户可以控制的，所以对于用户来说 set 中的元素还是无序的）
     *  实现类
     *      List 接口有三个实现类（
     *      LinkedList：基于链表实现，链表内存是散乱的，每一个元素存储本身内存地址的同时还存储下一个元素的地址。链表增删快，查找慢；
     *      ArrayList：基于数组实现，非线程安全的，效率高，便于索引，但不便于插入删除；
     *      Vector：基于数组实现，线程安全的，效率低）。
     *  List a=new ArrayList()和 ArrayList a =new ArrayList()的区别：
     *      List list = new ArrayList();这句创建了一个 ArrayList 的对象后把上溯到了 List。此时它是一个 List 对象了，有些
     *      ArrayList 有但是 List 没有的属性和方法，它就不能再用了。而 ArrayList list=new ArrayList();创建一对象则保留了
     *      ArrayList 的所有属性。 所以需要用到 ArrayList 独有的方法的时候不能用前者。实例代码如下：
     *
     */
    public static void main(String[] args) {
        List<String> list3 = new ArrayList();
        List<String> list1 = new ArrayList(list3);
        List<String> list2 = new LinkedList<>();
        list1.add("1");
        list2.add("2");
        list2.add("3");

        /**
         * 遍历
         */
        Iterator iterator = list1.iterator();
        while(iterator.hasNext()){
            String next = (String) iterator.next();
            System.out.println(next);
        }

        /**
         * 利用linkedList实现栈和队列
         */
        ((LinkedList<String>) list2).addFirst("0");
        ((LinkedList<String>) list2).removeLast();
        System.out.println(list2.isEmpty());
        for (Object o : list2) {
            System.out.println(o);
        }
    }
}
