package com.cuizhiwen.jdk.java8.Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/13 13:11
 */
public class Lam2 {
    /**
     * 使用 lambda 表达式对列表进行迭代
     */
    public static void main(String[] args) {
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (Object feature : features) {
            System.out.println(feature);
        }
        // Java 8 之后：
        List featuress = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        featuress.forEach(n -> System.out.println(n));
        // 使用 Java 8 的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像 C++的作用域解析运算符
        featuress.forEach(System.out::println);




    }
}
