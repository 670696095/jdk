package com.cuizhiwen.jdk.collection.list;

import java.util.Comparator;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 10:25
 */
public class AppleComparator implements Comparator<Apple> {
    @Override
    public int compare(Apple o1, Apple o2) {
        return o1.getWeight() - o2.getWeight();
    }
}
