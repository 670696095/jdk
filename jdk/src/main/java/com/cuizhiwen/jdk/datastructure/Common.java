package com.cuizhiwen.jdk.datastructure;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/29 13:39
 */
public class Common {
    /**
     * java数据结构:
     *      在Java中的数据结构主要包括以下几种接口和类：
     *          枚举（Enumeration） （The Enumeration）接口定义了一种从数据结构中取回连续元素的方式。
     *          位集合（BitSet）     实现了一组可以单独设置和清除的位或标志。
     *
     *          向量（Vector）       向量（Vector）类和传统数组非常相似，但是Vector的大小能根据需要动态的变化。和数组一样，Vector对象的元素也能通过索引访问。
     *                              使用Vector类最主要的好处就是在创建对象的时候不必给对象指定大小，它的大小会根据需要动态的变化
     *
     *          栈（Stack）          栈（Stack）实现了一个后进先出（LIFO）的数据结构。你可以把栈理解为对象的垂直分布的栈，当你添加一个新元素时，
     *                              就将新元素放在其他元素的顶部。当你从栈中取元素的时候，就从栈顶取一个元素。换句话说，最后进栈的元素最先被取出。
     *
     *          字典（Dictionary）    抽象类，它定义了键映射到值的数据结构。当你想要通过特定的键而不是整数索引来访问数据的时候，这时候应该使用Dictionary。
     *
     *          哈希表（Hashtable）   提供了一种在用户定义键结构的基础上来组织数据的手段。
     *                              例如，在地址列表的哈希表中，你可以根据邮政编码作为键来存储和排序数据，而不是通过人名
     *                              hashTable是原始的java.util的一部分， 是一个Dictionary具体的实现 。
     *                              然而，Java 2 重构的Hashtable实现了Map接口，因此，Hashtable现在集成到了集合框架中。它和HashMap类很相似，但是它支持同步。
     *
     *          属性（Properties）    Properties 继承于 Hashtable.表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
     *                              Properties 类被许多Java类使用。例如，在获取环境变量时它就作为System.getProperties()方法的返回值。
     */


        public static void main(String args[]) {
            /**
             * hashTabel
             */
            Hashtable balance = new Hashtable();
            Enumeration names;
            String str;
            double bal;

            balance.put("Zara", new Double(3434.34));
            balance.put("Mahnaz", new Double(123.22));
            balance.put("Ayan", new Double(1378.00));
            balance.put("Daisy", new Double(99.22));
            balance.put("Qadir", new Double(-19.08));

            // Show all balances in hash table.
            names = balance.keys();
            while(names.hasMoreElements()) {
                str = (String) names.nextElement();
                System.out.println(str + ": " +
                        balance.get(str));
            }
            System.out.println();
            // Deposit 1,000 into Zara's account
            bal = ((Double)balance.get("Zara")).doubleValue();
            balance.put("Zara", new Double(bal+1000));
            System.out.println("Zara's new balance: " +
                    balance.get("Zara"));


            /**
             * Properties
             */
            Properties capitals = new Properties();
            Set states;
            String str1 = "123";

            capitals.put("Illinois", "Springfield");
            capitals.put("Missouri", "Jefferson City");
            capitals.put("Washington", "Olympia");
            capitals.put("California", "Sacramento");
            capitals.put("Indiana", "Indianapolis");

            // Show all states and capitals in hashtable.
            states = capitals.keySet(); // get set-view of keys
            Iterator itr = states.iterator();
            while(itr.hasNext()) {
                str1 = (String) itr.next();
                System.out.println("The capital of " +
                        str1 + " is " + capitals.getProperty(str1) + ".");
            }
            System.out.println();

            // look for state not in list -- specify default
            str = capitals.getProperty("Florida", "Not Found");
            System.out.println("The capital of Florida is "
                    + str1 + ".");
        }
        }

