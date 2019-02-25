package com.cuizhiwen.jdk.thread.concurrent.c;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/25 10:00
 */
public class TConcurrentHashMap {
    /**
     * ➢ConcurrentHashMap 非阻塞 Hash 集合
     *      ConcurrentHashMap 是 Java 并发包中提供的一个线程安全且高效的 HashMap 实现，ConcurrentHashMap
     *      在并发编程的场景中使用频率非常之高。
     *
     * 组成：
     *      ConcurrentHashMap 是由 Segment 数组结构和 HashEntry 数组结构组成。Segment 是一种可重入锁
     *      ReentrantLock ， 在 ConcurrentHashMap 里 扮 演 锁 的 角 色 ， HashEntry 则 用 于 存 储 键 值 对 数 据 。 一 个
     *      ConcurrentHashMap 里包含一个 Segment 数组，Segment 的结构和 HashMap 类似，是一种数组和链表结构， 一
     *      个 Segment 里包含一个 HashEntry 数组，每个 HashEntry 是一个链表结构的元素， 每个 Segment 守护者一个
     *      HashEntry 数组里的元素,当对 HashEntry 数组的数据进行修改时，必须首先获得它对应的 Segment 锁。
     *
     *      众所周知，哈希表是中非常高效，复杂度为 O(1)的数据结构，在 Java 开发中，我们最常见到最频繁使用的就是HashMap 和 HashTable，
     *      但是在线程竞争激烈的并发场景中使用都不够合理。
     *      HashMap ：
     *              先说 HashMap，HashMap 是线程不安全的，在并发环境下，可能会形成环状链表（扩容时可能造成，具体原因自行百度 google 或查看源码分析），
     *              导致 get 操作时，cpu 空转，所以，在并发环境中使用 HashMap是非常危险的。
     *      HashTable ：
     *              HashTable 和 HashMap 的实现原理几乎一样，差别无非是 1.HashTable 不允许 key 和 value 为null；2.HashTable
     *              是线程安全的。但是 HashTable 线程安全的策略实现代价却太大了，简单粗暴，get/put 所有相关操作都是 synchronized 的，
     *              这相当于给整个哈希表加了一把大锁，多线程访问时候，只要有一个线程访问或操作该对象，那其他线程只能阻塞，相当于将所有的操作串行化，
     *              在竞争激烈的并发场景中性能就会非常差。
     * 分段锁:
     *              HashTable 性能差主要是由于所有操作需要竞争同一把锁，而如果容器中有多把锁，每一把锁锁一段数据，这样
     *              在 多 线 程 访 问 时 不 同 段 的 数 据 时 ， 就 不 会 存 在 锁 竞 争 了 ， 这 样 便 可 以 有 效 地 提 高 并 发 效 率 。 这 就 是
     *              ConcurrentHashMap 所采用的"分段锁"思想
     *
     *              ConcurrentHashMap 采用了非常精妙的"分段锁"策略，ConcurrentHashMap 的主干是个 Segment 数组。
     *                  final Segment<K,V>[] segments;
     *              Segment 继承了 ReentrantLock，所以它就是一种可重入锁（ReentrantLock)。在 ConcurrentHashMap，
     *             一个 Segment 就是一个子哈希表，Segment 里维护了一个 HashEntry 数组，并发环境下，对于不同 Segment的数据进行操作是不用考虑锁竞争的。
     *             （就按默认的 ConcurrentLeve 为 16 来讲，理论上就允许 16 个线程并发执行，有木有很酷）所以，对于同一个Segment的操作才需考虑线程同步，
     *             不同的Segment则无需考虑。Segment类似于HashMap，一个 Segment 维护着一个 HashEntry 数组
     *                  transient volatile HashEntry<K,V>[] table;
     *              HashEntry是目前我们提到的最小的逻辑处理单元了。一个ConcurrentHashMap维护一个Segment数组，一个 Segment 维护一个 HashEntry 数组。
     *                  static final class HashEntry<K,V> {
     *                      final int hash;
     *                      final K key;
     *                      volatile V value;
     *                      volatile HashEntry<K,V> next; //其他省略
     *                      }
     *              我们说 Segment 类似哈希表，那么一些属性就跟我们之前提到的 HashMap 差不离，比如负载因子loadFactor，比如阈值 threshold 等等，
     *              看下 Segment 的构造方法
     *                  Segment(float lf, int threshold, HashEntry<K,V>[] tab) {
     *                  this.loadFactor = lf;//负载因子
     *                  this.threshold = threshold;//阈值
     *                  this.table = tab;//主干数组即 HashEntry 数组
     *                  }
     *
     *
     */
    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
    }
}
