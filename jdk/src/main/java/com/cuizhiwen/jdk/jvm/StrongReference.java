package com.cuizhiwen.jdk.jvm;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/1 10:44
 */
public class StrongReference {
    /**
     * Java 中引用类型都有哪些？（重要）
     *      Java 中对象的引用分为四种级别，这四种级别由高到低依次为：强引用、软引用、弱引用和虚引用。
     *
     * 强引用（StrongReference）
     *      这个就不多说，我们写代码天天在用的就是强引用。如果一个对象被被人拥有强引用，那么垃圾回收器绝不
     *      会回收它。当内存空间不足，Java 虚拟机宁愿抛出 OutOfMemoryError 错误，使程序异常终止，也不会靠随意
     *      回收具有强引用的对象来解决内存不足问题。
     *      Java 的对象是位于 heap 中的，heap 中对象有强可及对象、软可及对象、弱可及对象、虚可及对象和不可到
     *      达对象。应用的强弱顺序是强、软、弱、和虚。对于对象是属于哪种可及的对象，由他的最强的引用决定。
     */
    public static void main(String[] args) {
        /**
         * 第一行在 heap 堆中创建内容为“abc”的对象，并建立 abc 到该对象的强引用，该对象是强可及的。
         * 第二行和第三行分别建立对 heap 中对象的软引用和弱引用，此时 heap 中的 abc 对象已经有 3 个引用，显然此
         * 时 abc 对象仍是强可及的。
         * 第四行之后 heap 中对象不再是强可及的，变成软可及的。
         * 第五行执行之后变成弱可及的。
         */
        String abc = new String("abc");
        SoftReference<String> softRef = new SoftReference<String>(abc);
        WeakReference<String> weakRef = new WeakReference<String>(abc);
        abc = null;
        softRef.clear();
    }
}
