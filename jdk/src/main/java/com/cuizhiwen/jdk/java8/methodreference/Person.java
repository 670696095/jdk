package com.cuizhiwen.jdk.java8.methodreference;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 10:43
 */
public class Person {
    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }

    /**
     * 普通方法排序
     */
    public void test() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016,9,1)),
                new Person("001", LocalDate.of(2016,2,1)),
                new Person("002", LocalDate.of(2016,3,1)),
                new Person("004", LocalDate.of(2016,12,1))};

        // 使用匿名类
        Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        });

        System.out.println(Arrays.asList(pArr));
    }

    /**
     * lambda表达式 未调用已存在的方法
     */
    public void test1() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016,9,1)),
                new Person("001", LocalDate.of(2016,2,1)),
                new Person("002", LocalDate.of(2016,3,1)),
                new Person("004", LocalDate.of(2016,12,1))};

        //使用lambda表达式
        Arrays.sort(pArr, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });

        System.out.println(Arrays.asList(pArr));
    }

    /**
     * lambda表达式  调用已存在的方法
     *
     */
    public void test2() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016,9,1)),
                new Person("001", LocalDate.of(2016,2,1)),
                new Person("002", LocalDate.of(2016,3,1)),
                new Person("004", LocalDate.of(2016,12,1))};

        //使用lambda表达式和类的静态方法
        Arrays.sort(pArr, (a ,b) -> Person.compareByAge(a, b));

        System.out.println(Arrays.asList(pArr));
    }

    /**
     * 方法引用
     */
    public void test3() {
        Person[] pArr = new Person[]{
                new Person("003", LocalDate.of(2016,9,1)),
                new Person("001", LocalDate.of(2016,2,1)),
                new Person("002", LocalDate.of(2016,3,1)),
                new Person("004", LocalDate.of(2016,12,1))};

        //使用方法引用，引用的是类的静态方法
        Arrays.sort(pArr, Person::compareByAge);

        System.out.println(Arrays.asList(pArr));
    }

    public static void main(String[] args) {
        Person p = new Person("崔智文",LocalDate.of(1994,8,30));
        p.test();
        p.test1();
        p.test2();
        p.test3();


    }
}
