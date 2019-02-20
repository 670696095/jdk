package com.cuizhiwen.jdk.collection.map;

import java.util.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 17:51
 */
public class THashMap {
    /**
     * hashMap: jdk1.8用到红黑树，既要保证查询也要保证插入。
     *
     * Map 接口有三个实现类（
     *      HashMap：基于 hash 表的 Map 接口实现，非线程安全，高效，支持 null 值和 null键；
     *      HashTable：线程安全，低效，不支持 null 值和 null 键；
     *      LinkedHashMap：是 HashMap 的一个子类，保存了记录的插入顺序；
     *      SortMap 接口：TreeMap，能够把它保存的记录根据键排序，默认是键值的升序排序）。
     * null：
     *      HashMap 对象的 key、value 值均可为 null。
     *      HahTable 对象的 key、value 值均不可为 null。
     *      且两者的的 key 值均不能重复，若添加 key 相同的键值对，后面的 value 会自动覆盖前面的 value，但不会报错
     *
     */
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        System.out.println(map.get(1));
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("周瑜","周瑜");
        hashMap.put("曹操","曹操");
        hashMap.put("刘备","刘备");
        hashMap.put("孙权","孙权");
        System.out.println(hashMap.keySet());
        for (String key : hashMap.keySet()){
            System.out.println(String.format("hashcode="+key.hashCode()%8));
        }


        Map<String, String> hashMap1 = new HashMap<String, String>();//HashMap 对象
        Map<String, String> tableMap = new Hashtable<String, String>();//HashTable 对象
        map.put(null, null);
        System.out.println("hashMap 的[key]和[value]均可以为 null:" + hashMap1.get(null));
        try {
            tableMap.put(null, "3");
            System.out.println(tableMap.get(null));
            } catch (Exception e) {
            System.out.println("【ERROR】：hashTable 的[key]不能为 null");
            }

         try {
         tableMap.put("3", null);
         System.out.println(tableMap.get("3"));
            } catch (Exception e) {
            System.out.println("【ERROR】：hashTable 的[value]不能为 null");
            }
        }


}
