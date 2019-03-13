package com.cuizhiwen.jdk.java8.Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/13 13:23
 */
public class Lam3 {
    /**
     * 在 lambda 表达式中加入 Predicate
     * 上允许将两个或更多的 Predicate 合成一个。它提供类似于逻辑操作
     * 符 AND 和 OR 的方法，名字叫做 and()、or()和 xor()，用于将传入 filter() 方法的条件合并起来。例如，要得到所有
     * 以J开始，长度为四个字母的语言，可以定义两个独立的 Predicate 示例分别表示每一个条件，然后用 Predicate.and()
     * 方法将它们合并起来，如下所示
     */
    public static void main(String[] args) {
        // 甚至可以用 and()、or()和 xor()逻辑函数来合并 Predicate，
        // 例如要找到所有以 J 开始，长度为四个字母的名字，你可以合并两个 Predicate 并传入
        List names = Arrays.asList("Jame", "Default Method", "Stream API", "Date and Time API");
        Predicate<String> startsWithJ = (n) -> n.startsWith("J");
        Predicate<String> fourLetterLong = (n) -> n.length() == 4;
        names.stream()
                .filter(startsWithJ.and(fourLetterLong))
                .forEach((n) -> System.out.print("nName, which starts with 'J' and four letter long is : " +
                        n));
    }
}
