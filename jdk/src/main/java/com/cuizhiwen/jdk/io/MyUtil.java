package com.cuizhiwen.jdk.io;

import java.io.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/19 9:34
 */
public class MyUtil {
    /**
     * 注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，这项检查是编译器完成的，
     *      不是在运行时抛出异常，这种是方案明显优于使用 Object 类的 clone方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行
     */
        private MyUtil() {
        throw new AssertionError();
        }
        @SuppressWarnings("unchecked")
        public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
        // 说明：调用 ByteArrayInputStream 或 ByteArrayOutputStream 对象的 close 方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        }
}
