package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 10:12
 */
public class InstanceOf {
    /**
     * instanceof 运算符是用来在运行时指出对象是否是特定类的一个实例或子类的实例。
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
