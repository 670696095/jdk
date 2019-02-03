package com.cuizhiwen.jdk.collection.map;

import java.util.HashMap;
import java.util.Iterator;

public class ExceptionTest {
    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("1","1");
        hashMap.put("2","2");
        for (String key:hashMap.keySet()){
            if (key.equals("1")){
                hashMap.remove(key);
            }
        }
        System.out.println(hashMap.get("2"));

        Iterator<String> iterable = hashMap.keySet().iterator();
        while (((Iterator) iterable).hasNext()){
            String key = iterable.next();
            if (key.equals("2")){
                hashMap.remove(key);
            }
        }
        System.out.println(hashMap.get("2"));
    }
}
