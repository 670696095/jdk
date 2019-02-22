package com.cuizhiwen.jdk.thread.concurrent.a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/22 13:22
 */
public class TForkJoinPool extends RecursiveAction {
    /**
     * ➢ForkJoinPool 合并和分叉（线程池）
     *          ForkJoinPool 在 Java 7 中被引入。它和 ExecutorService 很相似，除了一点不同。ForkJoinPool 让我们可以
     *          很方便地把任务分裂成几个更小的任务，这些分裂出来的任务也将会提交给 ForkJoinPool。任务可以继续分割成更小
     *          的子任务，只要它还能分割。
     * 合并和分叉的解释:
     *          在我们开始看 ForkJoinPool 之前我们先来简要解释一下分叉和合并的原理。
     *          分叉和合并原理包含两个递归进行的步骤。两个步骤分别是分叉步骤和合并步骤。
     *              分叉:
     *                  一个使用了分叉和合并原理的任务可以将自己分叉(分割)为更小的子任务，这些子任务可以被并发执行。
     *                  通过把自己分割成多个子任务，每个子任务可以由不同的 CPU 并行执行，或者被同一个 CPU 上的不同线程执
     *                  行。只有当给的任务过大，把它分割成几个子任务才有意义。把任务分割成子任务有一定开销，因此对于小型任务，这
     *                  个分割的消耗可能比每个子任务并发执行的消耗还要大。
     *                  什么时候把一个任务分割成子任务是有意义的，这个界限也称作一个阀值。这要看每个任务对有意义阀值的决定。
     *                  很大程度上取决于它要做的工作的种类。
     *              合并:
     *                  当一个任务将自己分割成若干子任务之后，该任务将进入等待所有子任务的结束之中。一旦子任务执行结束，该
     *                  任务可以把所有结果合并到同一个结果。
     *                  当然，并非所有类型的任务都会返回一个结果。如果这个任务并不返回一个结果，它只需等待所有子任务执行完
     *                  毕。也就不需要结果的合并啦。
     *
     *              所以我们可以将 ForkJoinPool 是一个特殊的线程池，它的设计是为了更好的配合 分叉-和-合并 任务分割的工
     *              作。ForkJoinPool 也在 java.util.concurrent 包中，其完整类名为 java.util.concurrent.ForkJoinPool
     * 1.创建一个 ForkJoinPool:
     *      你可以通过其构造子创建一个 ForkJoinPool。作为传递给 ForkJoinPool 构造子的一个参数，你可以定义你期望的并行级别。
     *      并行级别表示你想要传递给 ForkJoinPool 的任务所需的线程或 CPU 数量。以下是一个 ForkJoinPool
     *      示例：
     *      //创建了一个并行级别为 4 的
     *      ForkJoinPoolForkJoinPool forkJoinPool = new ForkJoinPool(4);
     * 2.提交任务到 ForkJoinPool:
     *      就像提交任务到 ExecutorService 那样，把任务提交到 ForkJoinPool。你可以提交两种类型的任务。
     *          一种是没有任何返回值的(一个 “行动”)  另一种是有返回值的(一个”任务”)。
     *          这两种类型分别由 RecursiveAction 和RecursiveTask 表示。接下来介绍如何使用这两种类型的任务，以及如何对它们进行提交
     */
    long workLoad = 0;

    public TForkJoinPool(long workLoad) {
        this.workLoad = workLoad;
    }

    /**
     * RecursiveAction:
     *      RecursiveAction 是一种没有任何返回值的任务。它只是做一些工作，比如写数据到磁盘，然后就退出了。一个RecursiveAction
     *      可以把自己的工作分割成更小的几块，这样它们可以由独立的线程或者 CPU 执行。可以通过继承来实现一个 RecursiveAction。
     */
    @Override
    protected void compute() {
        //if work is above threshold, break tasks up into smaller tasks
        // 翻译：如果工作超过门槛，把任务分解成更小的任务
        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);
            List<TForkJoinPool> subtasks = new ArrayList<TForkJoinPool>();
            subtasks.addAll(createSubtasks());
            for (RecursiveAction subtask : subtasks) {
                subtask.fork();
            }
        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
        }
    }

    private List<TForkJoinPool> createSubtasks() {
        List<TForkJoinPool> subtasks = new ArrayList<TForkJoinPool>();
        TForkJoinPool subtask1 = new TForkJoinPool(this.workLoad / 2);
        TForkJoinPool subtask2 = new TForkJoinPool(this.workLoad / 2);
        subtasks.add(subtask1);
        subtasks.add(subtask2);
        return subtasks;
    }

    public static void main(String[] args) {

        //创建了一个并行级别为 4 的 ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        //创建一个没有返回值的任务
        TForkJoinPool myRecursiveAction = new TForkJoinPool(24);
        //ForkJoinPool 执行任务
        forkJoinPool.invoke(myRecursiveAction);


        //创建一个有返回值的任务
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(128);
        //线程池执行并返回结果
        long mergedResult = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("mergedResult = " + mergedResult);
    }

    /**
     * RecursiveTask:
     *      RecursiveTask 是一种会返回结果的任务。它可以将自己的工作分割为若干更小任务，并将这些子任务的执行结果合并到一个集体结果。
     *      可以有几个水平的分割和合并。
     *
     *      除 了 有 一 个 结 果 返 回 之 外 ， 这 个 示 例 和 RecursiveAction 的 例 子 很 像 。 MyRecursiveTask 类 继 承 自
     *      RecursiveTask<Long>，这也就意味着它将返回一个 Long 类型的结果。
     *      MyRecursiveTask 示例也会将工作分割为子任务，并通过 fork() 方法对这些子任务计划执行。此外，本示例还
     *      通过调用每个子任务的 join() 方法收集它们返回的结果。子任务的结果随后被合并到一个更大的结果，并最终将其返
     *      回。对于不同级别的递归，这种子任务的结果合并可能会发生递归
     */
    static class MyRecursiveTask extends RecursiveTask<Long> {

        private long workLoad = 0;
        public MyRecursiveTask(long workLoad) {
            this.workLoad = workLoad;
        }
        @Override
        protected Long compute() {
        //if work is above threshold, break tasks up into smaller tasks
            if(this.workLoad > 16) {
                System.out.println("Splitting workLoad : " + this.workLoad);
                List<MyRecursiveTask> subtasks =
                        new ArrayList<MyRecursiveTask>();
                subtasks.addAll(createSubtasks());
                for(MyRecursiveTask subtask : subtasks){
                    subtask.fork();
                }
                long result = 0;
                for(MyRecursiveTask subtask : subtasks) {
                    result += subtask.join();
                }
                return result;
            } else {
                System.out.println("Doing workLoad myself: " + this.workLoad);
                return workLoad ;
            }
        }
        private List<MyRecursiveTask> createSubtasks() {
            List<MyRecursiveTask> subtasks =
                    new ArrayList<MyRecursiveTask>();
            MyRecursiveTask subtask1 = new MyRecursiveTask(this.workLoad / 2);
            MyRecursiveTask subtask2 = new MyRecursiveTask(this.workLoad / 2);
            subtasks.add(subtask1);
            subtasks.add(subtask2);
            return subtasks;
        }
    }
}
