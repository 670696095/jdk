package com.cuizhiwen.jdk.object.mulform;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 16:37
 */
public class Father {
    protected String name="父亲属性";
    public void method() {
        System.out.println("父类方法，对象类型：" + this.getClass());
    }

    public Father(String name) {
        this.name = name;
    }
}
