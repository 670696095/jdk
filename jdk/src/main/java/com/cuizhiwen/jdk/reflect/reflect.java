package com.cuizhiwen.jdk.reflect;

import java.lang.reflect.Method;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/7 16:38
 */
public class reflect {
    /**
     * 反射：程序可以访问，检测，修改它本身状态或者行为的一种能力。对任意一个类都可以知道这个类所有属性和方法。
     * $Proxy
     *      jdk代理对象
     */

    /**
     * 通过反射获取类的属性
     * @param args
     */
    public static void main(String[] args) {
        Class clazz = Math.class;
        /**
         *获取完整类名com.sg.myReflection.bean.User
         */
        String strName01 = clazz.getName();
        System.out.println(strName01);
        String strName02 = clazz.getSimpleName();
        System.out.println(strName02);

        Method [] studentMethods = Math.class.getMethods();
        System.out.println("Math类中方法个数："+studentMethods.length);

        for (Method method : studentMethods) {
            //得到返回类型
            System.out.print("方法名称和参数："+method.getName()+"(");
            //取得某个方法对应的参数类型数组
            Class[] paramsType =  method.getParameterTypes();
            for (Class paramType : paramsType) {
                System.out.print(paramType.getTypeName()+" ");
            }
            System.out.print(")");
            Class returnType = method.getReturnType();
            System.out.println("返回类型："+returnType.getTypeName());
        }

    }
}
