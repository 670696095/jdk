package com.cuizhiwen.jdk.java8.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/13 13:33
 */
public class Lam4 {
    /**
     *列表的每个元素应用函数
     *
     * 我们通常需要对列表的每个元素使用某个函数，例如逐一乘以某个数、除以某个数或者做其它操作。这些操作都
     * 很适合用 map() 方法，可以将转换逻辑以 lambda 表达式的形式放在 map() 方法里，就可以对集合的各个元素进行
     * 转换了
     */
    public static void main(String[] args) {
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);



        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s, Square Without duplicates : %s %n", numbers, distinct);

    }
}
