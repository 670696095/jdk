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
     * hashMap:
     */
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"java");
        Set<Map.Entry<Integer,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer,String>> it = entrySet.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,String> entry = it.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
