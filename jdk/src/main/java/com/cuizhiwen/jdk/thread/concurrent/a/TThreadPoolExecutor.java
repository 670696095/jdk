package com.cuizhiwen.jdk.thread.concurrent.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 11:15
 */
public class TThreadPoolExecutor {
    /**
     * ➢ThreadPoolExecutor 线程池执行者
     *      java.util.concurrent.ThreadPoolExecutor 是 ExecutorService 接口的一个实现。ThreadPoolExecutor
     *      使用其内部池中的线程执行给定任务(Callable 或者 Runnable)。
     *
     *      ThreadPoolExecutor 包含的线程池能够包含不同数量的线程。池中线程的数量由以下变量决定：
     *           corePoolSize
     *           maximumPoolSize
     *
     *      当一个任务委托给线程池时，如果池中线程数量低于 corePoolSize，一个新的线程将被创建，即使池中可能尚有空闲线程 。
     *      如果内部任务队列已满而且有至少corePoolSize正在运行，但是运行线程的数量低于maximumPoolSize，一个新的线程将被创建去执行该任务。
     */

    /**
     * 构造方法参数列表解释：
     * corePoolSize - 池中所保存的线程数，包括空闲线程。
     * maximumPoolSize - 池中允许的最大线程数。
     * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
     * unit - keepAliveTime 参数的时间单位。
     * workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
     */
    int corePoolSize = 5;
    int maxPoolSize = 10;
    long keepAliveTime = 5000;
    ExecutorService threadPoolExecutor =
            new ThreadPoolExecutor(
                    corePoolSize,
                    maxPoolSize,
                    keepAliveTime,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>()
            );

}
