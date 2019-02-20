package com.cuizhiwen.jdk.collection.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/20 15:11
 */
public class TQueue {
    /**
     * Queue:
     *    队列是一种特殊的线性表，它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作。进行插入操作的端称为队尾，进行删除操作的端称为队头。
     *  队列中没有元素时，称为空队列。在队列这种数据结构中，最先插入的元素将是最先被删除的元素；反之最后插入的元素将是最后被删除的元素，
     *  因此队列又称为“先进先出”（FIFO—first in first out）的线性表。在java5中新增加了java.util.Queue接口，用以支持队列的常见操作。
     *  该接口扩展了java.util.Collection接口。Queue使用时要尽量避免Collection的add()和remove()方法，而是要使用offer()来加入元素，
     *  使用poll()来获取并移出元素。它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。 如果要使用前端而不移出该元素，使用
     *  element()或者peek()方法。值得注意的是LinkedList类实现了Queue接口，因此我们可以把LinkedList当成Queue来用。
     */

    /**
     * 用两个队列模拟堆栈结构
     * @param args
     */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>(); //a 队列
        Queue<String> queue2=new LinkedList<String>(); //b 队列
        ArrayList<String> a=new ArrayList<String>(); //arrylist 集合是中间参数
        //往 a 队列添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        System.out.print("进栈：");
        //a 队列依次加入 list 集合之中
        for(String q : queue){
            a.add(q);
           System.out.print(q);
            }
        //以倒序的方法取出（a 队列依次加入 list 集合）之中的值，加入 b 对列
         for(int i=a.size()-1;i>=0;i--){
            queue2.offer(a.get(i));
            }
        //打印出栈队列
        System.out.println("");
        System.out.print("出栈：");
        for(String q : queue2){
            System.out.print(q);
        }
    }
}
