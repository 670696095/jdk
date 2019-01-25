package com.cuizhiwen.jdk.common.InstanceOf;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 10:12
 */
public class InstanceOf {
    /**
     * instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例或子类的实例。
     *            该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。
     *
     * instanceof运算符使用格式如下：
     *            ( Object reference variable ) instanceof  (class/interface type)
     *            如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。
     */

    private final char value[];
    public InstanceOf() {

        this.value = new char[0];
    }

    @Override
    public boolean equals(java.lang.Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            /*if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i]) {
                        return false;
                        i++;
                    }
                }
                return true;
            }*/
        }
        return false;
    }
}
