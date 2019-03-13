package com.cuizhiwen.jdk.jvm;

import java.util.Arrays;

/**
 * @author 01418061(cuizhiwen)
 * @Description: 入栈和出栈
 * @date 2019/3/6 13:54
 */
public class MyStack {
    /**
     * 对于 Java 的 GC 哪些内存需要回收？？？
     * 内存运行时 JVM 会有一个运行时数据区来管理内存。它主要包括 5 大部分：程序计数器(Program Counter
     * Register)、虚拟机栈(VM Stack)、本地方法栈(Native Method Stack)、方法区(Method Area)、堆(Heap).
     * 而其中程序计数器、虚拟机栈、本地方法栈是每个线程私有的内存空间，随线程而生，随线程而亡。例如栈中每一
     * 个栈帧中分配多少内存基本上在类结构确定是哪个时就已知了，因此这 3 个区域的内存分配和回收都是确定的，无需
     * 考虑内存回收的问题。
     * 但方法区和堆就不同了，一个接口的多个实现类需要的内存可能不一样，我们只有在程序运行期间才会知道会创
     * 建哪些对象，这部分内存的分配和回收都是动态的，GC 主要关注的是这部分内存。
     * 总而言之，GC 主要进行回收的内存是 JVM 中的方法区和堆；
     */
    private String[] elements;
    private int size = 0;
    private static final int INIT_CAPACITY = 2;

    public MyStack() {
        elements =  new String[INIT_CAPACITY];
    }

    public void push(String elem) {
        ensureCapacity();
        elements[size++] = elem;
        System.out.println("入栈:" + elem);
    }

    public String pop() {
        if (size == 0) {
        }
        System.out.println("出栈:"+elements[size-1]);
        return elements[size--];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.pop();
        myStack.pop();
        myStack.pop();


    }
}
