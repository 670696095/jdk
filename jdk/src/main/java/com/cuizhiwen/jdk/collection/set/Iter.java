package com.cuizhiwen.jdk.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/18 9:57
 */
public class Iter {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("123");

        /**
         * 方法一:
         *      集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
         */
        Iterator it1 = set.iterator();
        while(it1.hasNext()){
            System.out.println(it1.next());
        }

        /**
         * 方法二:
         *      集合类的通用遍历方式, 从很早的版本就有, 用迭代器迭代
         */
        for(Iterator it2 = set.iterator();it2.hasNext();){
            System.out.println(it2.next());
        }


        /**
         * 方法三：
         *      增强型for循环遍历
         */
        for(Object value: set){
            System.out.println(value);
        }

        /**
         * 方法四:
         *      lambda表达式
         */
        set.forEach(s -> System.out.println(s));
    }

}
