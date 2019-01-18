package com.cuizhiwen.jdk.collection.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/18 9:49
 */
public class Iter {
    /**
     * list的遍历
     */
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("123");

        /**
         * 方法1：
         *      集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
         */

        Iterator it1 = list.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        /**
         * 方法2：
         *      集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
         */
        for(Iterator it2 = list.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }

        /**
         * 方法3：
         *      增强型for循环遍历
         */
        for (Object o : list) {
            System.out.println(o);
        }


        /**
         *  方法4:
         *       一般型for循环遍历
         */
        for(int i = 0;i < list.size(); i ++){
            System.out.println(list.get(i));
        }
        /**
         * 方法5:
         *      lambda表达式
         */
        list.forEach(s -> System.out.println(s));

    }
}
