package com.cuizhiwen.jdk.collection.set;

import java.util.LinkedHashSet;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 16:24
 */
public class TSet {
    /**
     * set:不可以重复并且无序
     *      hashSet
     *      linkedSet
     * 唯一性:
     *      通过哈希表保证元素唯一性，哈希表通郭hashcode和equals方法共同保证。
     *
     * Set 接口有两个实现类（
     *      HashSet：底层是由 HashMap 实现，不允许集合中有重复的值，使用该方式时需要重写 equals()和 hashCode()方法；
     *      LinkedHashSet：继承与 HashSet，同时又基于 LinkedHashMap 来进行实现，底层使用的是 LinkedHashMp）。
     * hashSet
     *      说白了，HashSet就是限制了功能的HashMap，所以了解HashMap的实现原理，这个HashSet自然就通
     *      对于HashSet中保存的对象，主要要正确重写equals方法和hashCode方法，以保证放入Set对象的唯一性
     *      虽说是Set是对于重复的元素不放入，倒不如直接说是底层的Map直接把原值替代了（这个Set的put方法的返回值真有意思）
     *      HashSet没有提供get()方法，愿意是同HashMap一样，Set内部是无序的，只能通过迭代的方式获得
     * LinkedHashSet
     *      同HashSet相比并没有实现新的功能（新的方法），只不过把HashSet中预留的构造方法启用了，因而可以实现有序插入，
     *      而这个具体的实现要去看LinkedHashMap了，我们使用时是不需要再可以去设置参数的，直接拿来用即可。
     * TreeSet
     *      TreeSet中存放的元素是有序的（不是插入时的顺序，是有按关键字大小排序的），且元素不能重复。
     *      而如何实现有序存储，就需要有一个比较器，其实说起来，TreeSet更受关注的是不重复且有序，
     *      这个有序就需要有一个compare的过程，因此会需要参数实现Comparable接口。
     */
    public static void main(String[] args) {
         LinkedHashSet linkedHashSet =  new LinkedHashSet();
         linkedHashSet.add("123");
         for (Object o : linkedHashSet) {
              System.out.println(o);
         }
    }

     }