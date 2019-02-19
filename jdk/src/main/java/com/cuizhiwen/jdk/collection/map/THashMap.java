package com.cuizhiwen.jdk.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 17:51
 */
public class THashMap {
    /**
     * hashMap: jdk1.8用到红黑树，既要保证查询也要保证插入。
     *
     *
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


    }
}
