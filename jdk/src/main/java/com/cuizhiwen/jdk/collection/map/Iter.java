package com.cuizhiwen.jdk.collection.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/18 10:01
 */
public class Iter {
    public static void main(String[] args){

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("tom1",1);
        map.put("tom2",2);
        map.put("tom3",3);
        map.put("tom5",5);
        map.put("tom4",4);

        /**
         * 1.4版本之前
         */
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.print(key+" -->: "+value+"\t");
        }
        System.out.println("\n================");

        /**
         *   1.5 for-each 循环操作  普遍使用，二次取值
         */
        for(String o : map.keySet()){
            System.out.print (map.get(o)+"\t");
        }


        /**
         * 方法一: 用entrySet()
         *        返回的 set 中的每个元素都是一个 Map.Entry 类型。
         *        推荐，尤其是容量大时
         */
        System.out.println("\n=====用entrySet()=======");
        Iterator it1 = map.entrySet().iterator();
        while(it1.hasNext()){
            Map.Entry m=(Map.Entry)it1.next();
            System.out.println("[name = " + m.getKey()
                    + "] age = " + m.getValue());
        }


        /**
         * 方法二：
         *      jdk1.5支持，用entrySet()和For-Each循环() 推荐，尤其是容量大时
         */
        System.out.println("\n=用entrySet()和For-Each===");
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            System.out.println("[name = " + m.getKey() + "] age = " + m.getValue());
        }


        /**
         * 方法三：
         *      用keySet() 普遍使用，二次取值
         */
        System.out.println("\n=====用keySet()=======");
        Iterator it2 = map.keySet().iterator();
        while (it2.hasNext()){
            String key = (String) it2.next();
            System.out.println("[name = " + key
                    + "] age = " + map.get(key) );
        }


        /**
         * 方法四：
         *      jdk1.5支持，用keySEt()和For-Each循环
         */
        System.out.println("\n=====用keySet()和For-Each=====");
        for(Object key: map.keySet()){
            System.out.println("[name = " + key
                    + "] age = " + map.get(key) );
        }
        /**
         * 方法六: 通过Map.values()遍历所有的value，但不能遍历key
         */
        for (Integer integer : map.values()) {
            System.out.println(integer);
        }


    }





    /**
     * entrySet()
     * @param map
     */
    private void printMap(Map<String,Integer> map){
        Set<Map.Entry<String, Integer>> entries = map.entrySet( );
        if(entries != null) {
            Iterator  iterator = entries.iterator( );
            while(iterator.hasNext( )) {
                Map.Entry  entry = (Map.Entry<String, Integer>) iterator.next( );
                System.out.println(
                        entry.getKey()+"\t\t:"+entry.getValue());
            }
        }

    }



}
