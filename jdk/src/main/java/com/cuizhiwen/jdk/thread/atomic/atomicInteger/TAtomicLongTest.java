package com.cuizhiwen.jdk.thread.atomic.atomicInteger;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 13:12
 */
public class TAtomicLongTest {
    /**
     * AtomicLong、AtomicLongArray 的 API 跟 AtomicInteger、AtomicIntegerArray 在使用方法都是差不多的。
     * 区别在于用前者是使用原子方式更新的 long 值和 long 数组，后者是使用原子方式更新的 Integer 值和 Integer 数组。
     * 两者的相同处在于它们此类确实扩展了 Number，允许那些处理基于数字类的工具和实用工具进行统一访问。在实际
     * 开发中，它们分别用于不同的场景。
     * @param args
     */
    public static void main(String[] args) {
        final AtomicLong orderIdGenerator = new AtomicLong(0);
        final List<Item> orders = Collections.synchronizedList(new ArrayList<Item>());
        for (int i = 0; i < 10; i++) {
            Thread orderCreationThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        long orderId = orderIdGenerator.incrementAndGet();
                        Item order = new Item(Thread.currentThread().getName(),
                                orderId);
                        orders.add(order);
                    }
                }
            });
            orderCreationThread.setName("Order Creation Thread " + i);
            orderCreationThread.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<Long> orderIds = new HashSet<Long>();
        for (Item order : orders) {
            orderIds.add(order.getID());
            System.out.println("Order name:" + order.getItemName()
                    +"----"+"Order id:" + order.getID());
        }
    }
}
    class Item {
    String itemName;
    long id;
    Item(String n, long id) {
        this.itemName = n;
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public long getID() {
        return id;
    }
}

