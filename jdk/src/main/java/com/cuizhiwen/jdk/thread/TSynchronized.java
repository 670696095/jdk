package com.cuizhiwen.jdk.thread;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/16 10:24
 */
public class TSynchronized {
    /**
     * synchronized:  可以修饰方法，修饰代码块，但是不能修饰构造器、成员变量等
     *
     * 一： 同步代码块
     *
     *      1.为了解决并发操作可能造成的异常，java的多线程支持引入了同步监视器来解决这个问题，使用同步监视器的通用方法就是同步代码块。其语法如下：
     *
     *          synchronized(obj){  其中obj就是同步监视器，
     *               同步代码块
     *          }
     *
     *          含义是：线程开始执行同步代码块之前，必须先获得对同步监视器的锁定。任何时刻只能有一个线程可以获得对同步监视器的锁定，
     *          当同步代码块执行完成后，该线程会释放对该同步监视器的锁定。虽然java程序允许使用任何对象作为同步监视器，
     *          但是同步监视器的目的就是为了阻止两个线程对同一个共享资源进行并发访问，因此通常推荐使用可能被并发访问的共享资源充当同步监视器。
     *
     * 二: 同步方法
     *      2.同步方法就是使用synchronized关键字修饰某个方法，无须显示指定同步监视器，同步方法的同步监视器就是this，
     *      通过同步方法可以非常方便的实现线程安全的类，线程安全的类有如下特征：
     *           1>该类的对象可以方便被多个线程安全的访问；
     *           2>每个线程调用该对象的任意方法之后都得到正确的结果；
     *           3>每个线程调用该对象的任意方法之后；该对象状态依然能保持合理状态。
     *           4> [不可变类]总是线程安全的，因为它的对象状态不可改变可变类需要额外的方法来保证其线程安全，在Account类中我们只需要balance的方法变成同步方法即可。
     * 注意:
     *      1>可变类的线程安全是以减低程序的运行效率为代价，不要对线程安全类的所有方法都进行同步，只对那些会改变竞争资源（共享资源）的方法进行同步。
     *      2>可变类有两种运行环境：单线程环境和多线程环境，则应该为可变类提供两个版本，即线程安全版本和线程不安全版本。
     *      3>如jdk提供的StringBuilder在单线程环境下保证更好的性能，StringBuffer可以保证多线程安全。
     * 同步方法使用时的注意事项：
     *      1.实例方法默认的同步锁对象是this,而静态方面默认的同步锁对象是类对象。
     *      2.同步方法默认锁定的是所有添加了相关同步锁的对象。怎么理解这句话呢？
     *      比如下面account对象有两个方法draw,otherDraw都是实例方法，默认同步锁是this。 那么如果有一个线程锁定了draw方法，那么其他线程也就不能访问otherDraw方法了。需要等地一个线程释放了锁后，才能访问。
     * 三:释放同步监视器的锁定
     *      1.任何线程进入同步代码块，同步方法之前，必须先获得对同步监视器的锁定，如何释放对同步监视器的锁定，
     *      线程会在以下几种情况下释放同步监视器：
     *
     *          1）当前线程的同步方法、同步代码块执行结束，当前线程即释放同步监视器；
     *          2）当前线程在同步代码块、同步方法中遇到break，return终止了该代码块、方法的继续执行；
     *          3）当前线程在同步代码块、同步方法中出现了未处理的Error或Exception，导致了该代码块、方法的异常结束；
     *          4）当前线程执行同步代码块或同步方法时，程序执行了同步监视器对象的wait（）方法，则当前线程暂停，并释放同步监视器。
     *      2.以下几种情况，线程不会释放同步监视器：
     *
     *          1）线程执行同步代码块或同步方法时，程序调用Thread.sleep()，Thread.yield()方法来暂停当前线程的执行，当前线程不会释放同步监视器；
     *          2）线程执行同步代码块时，其他线程调用了该线程的suspend（）方法将该线程挂起，该线程不会释放同步监视器，当然，程序应尽量避免使用suspend（）和resume（）方法来控制线程。
     * 四:同步锁
     *      1.java提供了一种功能更为强大的线程同步机制，通过显示定义同步锁对象来实现同步，这里的同步锁由Lock对象充当。
     *          1）Lock对象提供了比synchronized方法和synchronized代码块更广泛的锁定操作，Lock是控制多个线程对资源共享进行访问的工具，
     *             通常，锁提供了对共享资源的独占访问，每次只能有一个线程对Lock对象加锁，线程开始访问共享资源之前应该先获得Lock对象。
     *          2）某些锁可能允许对共享资源并发访问，如ReadWriteLock（读写锁），Lock，ReadWriteLock是Java5提供的两个接口，并为Lock提供了Reentrant实现类，为ReadWriteLock提供了ReentrantReadWriteLock实现类。
     *             在Java8中提供了新型的StampLock类，在大多数场景下它可以代替传统的ReentrantReadWriteLock。ReentrantReadWriteLock为读写操作提供了三种锁模式：Writing,ReadingOptimistic,Reading.
     *
     *      2.在实现线程安全的控制中，比较常用的是ReentrantLock（可重入锁）
     *    同步锁（Lock）使用的注意事项：
     *      1. Lock提供了同步方法和同步代码块所没有的其他功能，包括用于非块结构的tryLock()方法，以及试图获取可中断锁的lockInterruptibly方法，还有获取超时失效锁tryLock(long,TimeUnit); 方法。
     *      2. ReentrantLock锁具有可重入性，也是说，一个线程可以对已被加锁的ReentrantLock锁再次加锁，ReentrantLock对象会维持一个计数器来追踪lock()方法的嵌套调用，线程在每次调用lock()加锁后，
     *          必须显示调用unlock()释放锁，所以一段被锁保护的代码可以调用另一个被相同锁保护的方法。
     * 五:死锁
     *      1.两个线程互相等待对方释放同步监视器就会发生死锁，Java虚拟机没有检测，也没有采取措施来处理死锁的情况，
     *         所以多线程程序应该采取措施避免死锁出现，一旦出现死锁，程序既不会发生任何异常，也不会给出任何提示，只是所有线程都处于阻塞状态，无法继续
     *
     * 六:注意
     *      1.同步方法或同步代码块使用与竞争资源相关的，隐式的同步监视器，并且强制要求加锁和释放锁要出现在一个块结构中，
     *        而且当获取到多个锁时，它们必须以相反的顺序释放，且必须在与所有锁被释放时相同的范围内释放所有锁。
     */


}
