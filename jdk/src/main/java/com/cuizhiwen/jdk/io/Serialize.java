package com.cuizhiwen.jdk.io;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/11 14:02
 */
public class Serialize {
    /**
     * 对象序列化：
     *          把java对象转换成二进制字节流，同时存入磁盘或传入网络。
     *
     * 反序列化：从IO流中恢复java对象
     *
     * transient:标注不可序列化属性
     *
     *  什么是 java 序列化，如何实现 java 序列化？
     *      序列化就是一种用来处理对象流的机制，所谓对象流也就是将对象的内容进行流化。可以对流化后的对象进行读写操作，也可将流化后的对象传输于网络之间。
     *      序列化是为了解决在对对象流进行读写操作时所引发的问题。
     *      序列化的实现：将需要被序列化的类实现Serializable接口，该接口没有需要实现的方法 ，implements Serializable 只是为了标注该对象是可被序列化的，
     *      然后使用一个输出流(如：FileOutputStream)来构一个 ObjectOutputStream(对象流)对象，接着，使用 ObjectOutputStream 对象的
     *      writeObject(Object obj)方法就可以将参数为 obj 的对象写出(即保存其状态)，要恢复的话则用输入流。
     */
    transient  private String accountNo;

    public static void main(String[] args) {
        try {
            Person p1 = new Person("czw", 26, new Car("Benz", 300));
            // 深度克隆
            Person p2 = MyUtil.clone(p1);
            System.out.println(p1);
            p2.getCar().setBrand("BYD");
            // 修改克隆的 Person 对象 p2 关联的汽车对象的品牌属性
            // 原来的 Person 对象 p1 关联的汽车不会受到任何影响
            // 因为在克隆 Person 对象时其关联的汽车对象也被克隆了
             System.out.println(p2);
            System.out.println(p1);
             } catch (Exception e) {
            e.printStackTrace();
             }
        }

}
