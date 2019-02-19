package com.cuizhiwen.jdk.collection.map;

import java.util.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 16:24
 */
public class TMapSort {
    /**
     * Map：
     *      存储一组键值对象，提供K-V映射 （map键不可以重复，重复会覆盖，值可以重复）
     * hashMap TreeMap:
     *      hashMap 和 hashTable都实现了map接口。
     *      hashTable不允许空键和空值，
     *      hashMap允许空键和空值，并且线程同步。
     *
     */


    /**
     * 已知一个 HashMap<Integer，User>集合， User 有 name（String）和 age（int）属性。请写一个方法实现对HashMap 的排序功能，
     * 该方法接收 HashMap<Integer，User>为形参，返回类型为 HashMap<Integer，User>，要求对 HashMap 中的 User 的 age 倒序进行排序。
     * 排序时 key=value 键值对不得拆
     * @param args
     */
    public static void main(String[] args) {
        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, new User("张三", 25));
        users.put(3, new User("李四", 22));
        users.put(2, new User("王五", 28));
        System.out.println(users);
        HashMap<Integer,User> sortHashMap = sortHashMap(users);
        System.out.println(sortHashMap);

        }

        public static HashMap<Integer, User> sortHashMap(HashMap<Integer, User> map) {
        // 首先拿到 map 的键值对集合
        Set<Map.Entry<Integer, User>> entrySet = map.entrySet();

        // 将 set 集合转为 List 集合，为什么，为了使用工具类的排序方法
        List<Map.Entry<Integer, User>> list = new ArrayList<>(entrySet);
         // 使用 Collections 集合工具类对 list 进行排序，排序规则使用匿名内部类来实现
         Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {

             @Override
             public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                 return o2.getValue().getAge()-o1.getValue().getAge();
             }
});
         //创建一个新的有序的 HashMap 子类的集合
         LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<Integer, User>();
       //将 List 中的数据存储在 LinkedHashMap 中
         for(Map.Entry<Integer, User> entry : list){
            linkedHashMap.put(entry.getKey(), entry.getValue());
             }
       //返回结果
        return linkedHashMap;
        }

}
