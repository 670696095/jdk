package com.cuizhiwen.jdk.collection.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 17:34
 */
public class TTreeSet {
    /**TreeSet:
     *         不仅实现了set集合还实现了sortedSet接口，可以对插入的元素按一定的算法排序。
     *         两种排序方式：自然排序 或者 根据创建TreeSet 时提供的 Comparator 进行排序。这取决于使用的构造方法。
     * 使用方式：
     *      a.自然顺序(Comparable)
     *          TreeSet类的add()方法中会把存入的对象提升为Comparable类型
     *          调用对象的compareTo()方法和集合中的对象比较
     *          根据compareTo()方法返回的结果进行存储
     *      b.比较器顺序(Comparator)
     *          创建TreeSet的时候可以制定 一个Comparator
     *          如果传入了Comparator的子类对象, 那么TreeSet就会按照比较器中的顺序排序
     *          add()方法内部会自动调用Comparator接口中compare()方法排序
     *          调用的对象是compare方法的第一个参数,集合中的对象是compare方法的第二个参数
     *      c.两种方式的区别
     *          TreeSet构造函数什么都不传, 默认按照类中Comparable的顺序(没有就报错ClassCastException)
     *          TreeSet如果传入Comparator, 就优先按照Comparator
     */
    public static void main(String[] args) {
        /**
         * 比较自定义对象
         */
        TreeSet ts = new TreeSet();
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 13));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));
        System.out.println(ts);
        demo4();

    }

    static class  CompareByLen  implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            int num = o1.length() - o2.length();
            return num == 0 ? o1.compareTo(o2) : num;
        }

    }
    /**
     * 比较对象元素
     */
    public static void demo4() {

        //需求:将字符串按照长度排序
        TreeSet<String> ts = new TreeSet<>(new CompareByLen());
        ts.add("aaaaaaaa");
        ts.add("z");
        ts.add("wc");
        ts.add("nba");
        ts.add("cba");
        System.out.println(ts);
    }

}

