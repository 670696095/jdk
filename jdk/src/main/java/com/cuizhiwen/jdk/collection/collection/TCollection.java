package com.cuizhiwen.jdk.collection.collection;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/17 16:20
 */
public class TCollection {
    /**
     * Collectiont 是集合类的根接口，没有提供直接实现类。
     *             产生了两个接口 list和set
     *
     *             整个集合框架就围绕一组标准接口而设计。可以直接使用这些接口的标准实现，
     *             诸如： LinkedList, HashSet, 和 TreeSet 等,也可以通过这些接口实现自己的集合。
     * 请问 ArrayList、HashSet、HashMap 是线程安全的吗？如果不是我想要线程安全的集合怎么办？
     *        每个方法都没有加锁，显然都是线程不安全的。
     *        在集合中 Vector 和 HashTable 倒是线程安全的。其实就是把各自核心方法添加上了synchronized 关键字。
     *        Collections 工具类提供了相关的 API，可以让上面那 3 个不安全的集合变为安全的。
     */

    public static void main(String[] args) {
     /*   Collections.synchronizedCollection(c);
        Collections.synchronizedList(list);
        Collections.synchronizedMap(m);
        Collections.synchronizedSet();*/
    }
}
