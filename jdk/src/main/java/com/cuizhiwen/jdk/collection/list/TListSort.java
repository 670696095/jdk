package com.cuizhiwen.jdk.collection.list;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Comparator.comparing;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 10:24
 */
public class TListSort {
    public static void main(String[] args) {
        ArrayList<Apple> inventory = Lists.newArrayList(
                new Apple(4, "red"),
                new Apple(5, "red"),
                new Apple(1, "green"),
                new Apple(3, "green"),
                new Apple(2, "red"));

        // 1、传递代码，函数式编程
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        // 2、匿名内部类
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        //3、使用lambda表达式
        inventory.sort((a,b)->a.getWeight()-b.getWeight());

        // 4、使用Comparator的comparing
        //Comparator<Apple> comparing = comparing((Apple a) -> a.getWeight());
        inventory.sort(comparing((Apple a) -> a.getWeight()));
        // 1>根据重量逆序排序
        inventory.sort(comparing(Apple::getWeight).reversed());
        // 2>如果两个苹果的重量一样重，怎么办？那就再找一个条件进行排序呗
        inventory.sort(comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));

    }


}
