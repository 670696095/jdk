package com.cuizhiwen.jdk.collection;

import java.util.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 17:20
 */
public class Common {
    /**
     * 集合: 所有的集合类都继承了Iterator接口,有hashNext() next()方法
     * 1>ArrayList 数组方式存储，有索引便于查找 不利于删除，插入，数组元素数量大于实际存储。允许重复
     * 2>Vector 有synchronized修饰，线程安全。
     * 3>LinkedList 双向链表存储 不利于查找 便于插入 删除
     * 4>Array可存储基本类型和对象类型，ArrayList只能存储对象类型。Array大小固定。
     * 5>collection 是set list的父类
     * 6>collections 是一个工具类，提供一系列静态方法来辅助容器操作。
     * 7>hashMap 和 hashTable都实现了map接口。hashTable不允许空键和空值，hashMap允许，并且线程同步。
     *            （map键不可以重复，值可以）
     * 8>set  有序并且不可以重复，(Set - 散列集合) 删除和插入效率高，插入和删除不会引起元素位置改变
     *         HashSet : HashSet类按照哈希算法来存取集合中的对象，存取速度比较快
     *         TreeSet : TreeSet类实现了SortedSet接口，能够对集合中的对象进行排序。必须实现comparable接口
     *
     * 9>List 无序并且可以重复 查找元素效率高，插入删除效率低，因为会引起其他元素位置改变
     *
     * Collections：集合工具类，提供大量方法对集合排序 查询 修改，将集合设为不可变类，同步控制等。
     *
     * 区别:
     *      List 集合中对象按照索引位置排序，可以有重复对象，允许按照对象在集合中的索引位置检索对象，
     *      Map 中的每一个元素包含一个键和一个值，成对出现，键对象不可以重复，值对象可以重复；
     *      Set 集合中的对象不按照特定的方式排序，并且没有重复对象，但它的实现类能对集合中的对象按照特定的方式排序，
     *      例如 TreeSet 类，可以按照默认顺序，也可以通过实现 Java.util.Comparator<Type>接口来自定义排序方式
     */
    public static void main(String[] args) {
        /**
         * 去除vector中重复的元素
         */
        Vector v = new Vector();
        Vector vn = new Vector();
        for (int i = 0; i <v.size() ; i++) {
            Object obj= v.get(i);
            if(! vn.contains(obj)){
                vn.add(obj);
            }
        }

        List<String> data=Collections.synchronizedList(new ArrayList<String>());
        Hashtable hashtable = new Hashtable();
        //hashtable.put(1,null);

        HashMap hashMap = new HashMap();
        hashMap.put(null,null);




    }
}
