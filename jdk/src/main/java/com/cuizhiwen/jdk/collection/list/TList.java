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
     */
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
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
