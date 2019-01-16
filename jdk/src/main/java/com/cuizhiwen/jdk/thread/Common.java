package com.cuizhiwen.jdk.thread;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 16:32
 */
public class Common extends Thread{
    /**
     *  Java多线程实现方式主要有四种：
     *      继承Thread类、实现Runnable接口、实现Callable接口通过FutureTask包装器来创建Thread线
     *      重写run方法（线程执行体）, 启动线程.start() 不是用start启动线程，run()就是一个普通方法。
     *      java程序执行后至少创建一个主线程，主线程由main确定。
     *
     *  进程:
     *      1>当一个程序进入内存，就变成了进程，进程是系统资源分配和调度的一个独立单位。
     *      2>程序是一个静态指令集合，而进程是正在系统中活动的指令集合。
     *
     *  并发与并行:
     *      1>并发:同一时刻，多条指定在多个处理器上同时执行。
     *      2>并行:同一时刻，只能有一条指令，多个进程指令快速轮换执行。宏观上会有多个进程同时执行效果。
     *
     *  线程：
     *      1>线程共享内存，堆栈，局部变量。
     *      2>创建进程需要重新分配系统资源。
     *
     *  应用:
     *      1>浏览器同时下载多个图片
     *      2>web服务器同时响应多个用户请求
     *      3>java虚拟机多线程垃圾回收
     *
     *  Thread类和Runnable接口
     *      1>Thread创建子类既为线程对象
     *      2>Runnable对象只作为线程对象的target
     *
     *  线程生命周期
     *      新建（分配内存初始化）  就绪（start） 运行(何时运行取决于jvm调度) 阻塞 死亡
     *
     *  后台线程（守护线程，精灵线程）
     *      为其他线程提供服务，例：jvm垃圾回收线程
     */
    public static void main(String[] args) {
        System.out.println("主线程ID:"+Thread.currentThread().getId());
        new Common().start();
        new Common().run();

    }
    @Override
    public void run(){
        System.out.println(this.getName());
    }

}
