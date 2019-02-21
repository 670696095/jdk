package com.cuizhiwen.jdk.thread.local;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/21 13:38
 */
public class SerialNum {
    /**
     * ➢在关联数据类中创建 private static ThreadLocal
     *      在下面的类中，私有静态 ThreadLocal 实例（serialNum）为调用该类的静态 SerialNum.get() 方法的每个
     *      线程维护了一个“序列号”，该方法将返回当前线程的序列号。（线程的序列号是在第一次调用 SerialNum.get() 时
     *      分配的，并在后续调用中不会更改。）
     */
        // The next serial number to be assigned
        private static int nextSerialNum = 0;
        private static ThreadLocal serialNum = new ThreadLocal(){
            @Override
            protected synchronized Object initialValue() {
                return new Integer(nextSerialNum++);
            }
        };
        public static int get() {
            return ((Integer) (serialNum.get())).intValue();
        }
    }
