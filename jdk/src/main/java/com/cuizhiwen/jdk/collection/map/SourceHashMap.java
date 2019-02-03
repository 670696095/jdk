package com.cuizhiwen.jdk.collection.map;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * hashMap源码分析
 * @param <K>
 * @param <V>
 */
public class SourceHashMap<K,V> {
    private  Entry<K,V> [] table;

    static final int CAPACITY = 1 << 3;

    private int  size = 0;

    public SourceHashMap() {
        this.table = new Entry[CAPACITY];
    }

    class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }
    }


    public int size() {
        return size;
    }

    public Object get(Object key) {
        Integer  hashCode = key.hashCode();
        Integer index = hashCode%CAPACITY;

        for (Entry<K, V> entry = table[index];entry!=null;entry = entry.next) {
            if (entry.key.equals(key)){

                return entry.value;
            }
        }
        return null;
    }


    public Object put(K key, V value) {
        Integer  hashCode = key.hashCode();
        Integer index = hashCode%CAPACITY;

        for (Entry<K, V> entry = table[index];entry!=null;entry = entry.next) {
            if (entry.key.equals(key)){
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        addEntry(key, value, index);
        return null;
    }

    private void addEntry(K key, V value, Integer index) {
        Entry<K,V> entry = new Entry(key,value,table[index]);
        table[index] = entry;
        size++;
    }

    public static void main(String[] args) {
        SourceHashMap<String,String> hashMap = new SourceHashMap<>();
        for (int i = 0; i <10 ; i++) {
            hashMap.put("1"+i,"2"+i);
        }
        System.out.println(hashMap.get("10"));
    }

}
