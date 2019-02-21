package com.cuizhiwen.jdk.thread.local;

import lombok.Data;

import java.util.Random;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/21 14:18
 */

/**
 * 在 Runnable 中创建 ThreadLocal
 *      在线程类内部创建 ThreadLocal，基本步骤如下：
 *          ①、在多线程的类（如 ThreadDemo 类）中，创建一个 ThreadLocal 对象 threadXxx，用来保存线程间
 *          需要隔离处理的对象 xxx。
 *          ②、在 ThreadDemo 类中，创建一个获取要隔离访问的数据的方法 getXxx()，在方法中判断，若
 *          ThreadLocal 对象为 null 时候，应该 new()一个隔离访问类型的对象，并强制转换为要应用的类型
 *          ③、在 ThreadDemo 类的 run()方法中，通过调用 getXxx()方法获取要操作的数据，这样可以保证每个线
 *          程对应一个数据对象，在任何时刻都操作的是这个对象。
 */
public class ThreadLocalTest implements Runnable{
    ThreadLocal<Studen> studenThreadLocal = new ThreadLocal<Studen>();
    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();

        System.out.println(currentThreadName + " is running...");

        Random random = new Random();
        int age = random.nextInt(100);

        System.out.println(currentThreadName + " is set age: " + age);
        //通过这个方法，为每个线程都独立的 new 一个 student 对象，每个线程的的
        Studen studen = getStudent();
        //student 对象都可以设置不同的值
        studen.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + studen.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( currentThreadName + " is second get age: " + studen.getAge());
    }
    private Studen getStudent() {
        Studen studen = studenThreadLocal.get();
        if (null == studen) {
            studen = new Studen();
            studenThreadLocal.set(studen);
        }
        return studen;
    }
    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t,"Thread A");
        Thread t2 = new Thread(t,"Thread B");
        t1.start();
        t2.start();
    }
}
@Data
class Studen {
    int age;
}