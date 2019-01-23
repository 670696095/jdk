package com.cuizhiwen.jdk.thread.local;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/23 14:46
 */
public class TThreadLocal {
    /**
     * ThreadLocal：
     *      1>一般称为线程本地变量，它是一种特殊的线程绑定机制，将变量与线程绑定在一起，为每一个线程维护一个独立的变量副本。
     *      每个线程可以访问自己内部的副本变量,通过ThreadLocal可以将对象的可见范围限制在同一个线程内。
     *      2>提供了一个“线程级”的变量作用域，它是一种线程封闭（每个线程独享变量）技术，
     *       更直白点讲，ThreadLocal可以理解为将对象的作用范围限制在一个线程上下文中，使得变量的作用域为“线程级”。
     * ThreadLocal类提供的几个方法：
     *      public T get() { }
     *      public void set(T value) { }   set()用来设置当前线程中变量的副本，
     *      public void remove() { }       remove()用来移除当前线程中变量的副本，
     *      protected T initialValue() { } initialValue()是一个protected方法，一般是用来在使用时进行重写的，它是一个延迟加载方法，
     * threadLocals：
     *      初始时，在Thread里面，threadLocals为空，当通过ThreadLocal变量调用get()方法或者set()方法，就会对Thread类中的threadLocals
     *      进行初始化，并且以当前ThreadLocal变量为键值，以ThreadLocal要保存的副本变量为value，存到threadLocals。然后在当前线程里面，
     *      如果要使用副本变量，就可以通过get方法在threadLocals里面查找。
     *  应用场景:
     *      数据库连接、Session管理等。
     * 总结一下：
     *
     * 　　1）实际的通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
     * 　　2）为何threadLocals的类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
     * 　　3）在进行get之前，必须先set，否则会报空指针异常；
     * 　　4)如果想在get之前不需要调用set就能正常访问的话，必须重写initialValue()方法。
     */

    ThreadLocal<Long> longLocal = new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        };
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        };
    };


    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final TThreadLocal test = new TThreadLocal();

        //在main线程中，没有先set，直接get的话，运行时会报空指针异常。
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());


        Thread thread1 = new Thread(){
            @Override
            public void run() {
                test.set();
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());


    }

}
