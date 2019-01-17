package com.cuizhiwen.jdk.collection.set;

import lombok.Data;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 16:56
 */
@Data
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 当compareTo方法返回0的时候集合中只有一个元素
     * 当compareTo方法返回正数的时候集合会怎么存就怎么取
     * 当compareTo方法返回负数的时候集合会倒序存储
     *
     * 为什么返回0，只会存一个元素，返回-1会倒序存储，返回1会怎么存就怎么取呢？
     *      原因在于TreeSet底层其实是一个二叉树机构，且每插入一个新元素(第一个除外)都会调用```compareTo()```方法去和上一个插入的元素作比较，并按二叉树的结构进行排列。
     *      1. 如果将```compareTo()```返回值写死为0，元素值每次比较，都认为是相同的元素，这时就不再向TreeSet中插入除第一个外的新元素。所以TreeSet中就只存在插入的第一个元素。
     *      2. 如果将```compareTo()```返回值写死为1，元素值每次比较，都认为新插入的元素比上一个元素大，于是二叉树存储时，会存在根的右侧，读取时就是正序排列的。
     *      3. 如果将```compareTo()```返回值写死为-1，元素值每次比较，都认为新插入的元素比上一个元素小，于是二叉树存储时，会存在根的左侧，读取时就是倒序序排列的。
     *
     * String类的compareTo()方法
     *       按字典顺序比较两个字符串。该比较基于字符串中各个字符的 Unicode 值。按字典顺序将此 String 对象表示的字符序列与参数字符串所表示的字符序列进行比较。
     *       如果按字典顺序此 String 对象位于参数字符串之前，则比较结果为一个负整数。如果按字典顺序此 String 对象位于参数字符串之后，则比较结果为一个正整数。
     *       如果这两个字符串相等，则结果为 0；compareTo 只在方法 equals(Object) 返回 true 时才返回 0。
     */
    @Override
    public int compareTo(Person o) {
        int num = this.age - o.age;
        return num == 0 ? this.name.compareTo(o.name) : num;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
