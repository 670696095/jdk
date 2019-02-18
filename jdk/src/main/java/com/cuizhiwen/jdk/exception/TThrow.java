package com.cuizhiwen.jdk.exception;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/18 14:07
 */
public class TThrow {
    /**
     * throw 和 throws 的区别
     * throw：
     *      1）throw 语句用在方法体内，表示抛出异常，由方法体内的语句处理。
     *      2）throw 是具体向外抛出异常的动作，所以它抛出的是一个异常实例，执行 throw 一定是抛出了某种异常。
     * throws：
     *      1）throws 语句是用在方法声明后面，表示如果抛出异常，由该方法的调用者来进行异常的处理。
     *      2）throws 主要是声明这个方法会抛出某种类型的异常，让它的使用者要知道需要捕获的异常的类型。
     *      3）throws 表示出现异常的一种可能性，并不一定会发生这种异常。
     * final、finally、finalize 的区别？
     *      1）final：用于声明属性，方法和类，分别表示属性不可变，方法不可覆盖，被其修饰的类不可继承。
     *      2）finally：异常处理语句结构的一部分，表示总是执行。
     *      3）finalize：Object 类的一个方法，在垃圾回收器执行的时候会调用被回收对象的此方法，可以覆盖此方法
     *      提供垃圾收集时的其他资源回收，例如关闭文件等。该方法更像是一个对象生命周期的临终方法，当该方法
     *      被系统调用则代表该对象即将“死亡”，但是需要注意的是，我们主动行为上去调用该方法并不会导致该对
     *      象“死亡”，这是一个被动的方法（其实就是回调方法），不需要我们调用。
     */
}
