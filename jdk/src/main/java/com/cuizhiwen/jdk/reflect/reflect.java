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
     *
     * 说说你对 Java 中反射的理解
     *      Java 中 的 反 射 首 先 是 能 够 获 取 到 Java 中 要 反 射 类 的 字 节 码 ， 获 取 字 节 码 有 三 种 方 法 ，
     *      1.Class.forName(className)
     *      2.类名.class
     *      3.this.getClass()。
     *      然后将字节码中的方法，变量，构造函数等映射成相应的 Method、Filed、Constructor 等类，这些类提供了丰富的方法可以被我们所使用。
     */


    Class cl = this.getClass();
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

        try {
            Class c = Class.forName("com.cuizhiwen.jdk.string.StringBu");
            System.out.println("类名称：" + c.getName());
            System.out.println("是否为接口：" + c.isInterface());
            System.out.println("是否为基本类型：" + c.isPrimitive());
            System.out.println("是否为数组：" + c.isArray());
            System.out.println("父类：" + c.getSuperclass().getName());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("没有指定类名称");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的类");
        }
    }

    }
