package com.cuizhiwen.jdk.common.compara;

import java.util.*;
import java.util.Comparator;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 10:57
 */
public class StringSort {
    /**
     * 要求：对String进行排序，且不区分大小写。
     */
    public static void main(String[] args) {

        String [] strings = {"D","a","A"};
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null){
                    return 0;
                }
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });
        for (String string : strings) {
            System.out.println(string);
        }

        //lists中的对象String 本身含有compareTo方法，所以可以直接调用sort方法，按自然顺序排序，即升序排序
        List<String> list = new ArrayList<String>();
        list.add("D");
        list.add("a");
        list.add("A");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null || o2 == null){
                    return 0;
                }
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });
        for (String s : list) {
            System.out.println(s);
        }
    }
}
