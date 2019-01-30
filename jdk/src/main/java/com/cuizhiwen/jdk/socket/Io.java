package com.cuizhiwen.jdk.socket;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 13:52
 */
public class Io {
    /**
     * 同步和异步：
     *      同步和异步是针对应用程序和内核的交互而言的，同步指的是用户进程触发IO 操作并等待或者轮询的去查看IO 操作是否就绪，而异步是指用户进程触发IO
     *      操作以后便开始做自己的事情，而当IO 操作已经完成的时候会得到IO 完成的通知。
     *
     * 以银行取款为例：
     *      同步 ： 自己亲自出马持银行卡到银行取钱（使用同步 IO 时，Java 自己处理IO 读写）；
     *      异步 ： 委托一小弟拿银行卡到银行取钱，然后给你（使用异步IO 时，Java 将 IO 读写委托给OS 处理，需要将数据缓冲区地址和大小传给OS(银行卡和密码)，
     *             OS 需要支持异步IO操作API）；
     *
     * 阻塞和非阻塞：
     *      阻塞和非阻塞是针对于进程在访问数据的时候，根据IO操作的就绪状态来采取的不同方式，说白了是一种读取或者写入操作方法的实现方式，
     *      阻塞方式下读取或者写入函数将一直等待，而非阻塞方式下，读取或者写入方法会立即返回一个状态值。
     *
     * 以银行取款为例：
     *      阻塞 ： ATM排队取款，你只能等待（使用阻塞IO时，Java调用会一直阻塞到读写完成才返回）；
     *      非阻塞 ： 柜台取款，取个号，然后坐在椅子上做其它事，等号广播会通知你办理，没到号你就不能去，你可以不断问大堂经理排到了没有，
     *      大堂经理如果说还没到你就不能去（使用非阻塞IO时，如果不能读写Java调用会马上返回，当IO事件分发器通知可读写时再继续进行读写，不断循环直到读写完成）
     *
     * 1.BIO 编程
     *      Blocking IO： 同步阻塞的编程方式。
     *      BIO方式适用于连接数目比较小且固定的架构，这种方式对服务器资源要求比较高，并发局限于应用中，JDK1.4以前的唯一选择，但程序直观简单易理解。
     * 2.NIO 编程：
     *      Unblocking IO（New IO）： 同步非阻塞的编程方式。
     *          1>NIO的最重要的地方是当一个连接创建后，不需要对应一个线程，这个连接会被注册到多路复用器上面，所以所有的连接只需要一个线程就可以搞定，
     *          当这个线程中的多路复用器进行轮询的时候，发现连接上有请求的话，才开启一个线程进行处理，也就是一个请求一个线程模式。
     *          2>在NIO的处理方式中，当一个请求来的话，开启线程进行处理，可能会等待后端应用的资源(JDBC连接等)，其实这个线程就被阻塞了，当并发上来的话，
     *          还是会有BIO一样的问题
     * 3.AIO编程：
     *      Asynchronous IO： 异步非阻塞的编程方式。
     */
}