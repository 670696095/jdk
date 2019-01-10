package com.cuizhiwen.jdk.annotation;

import java.lang.reflect.Method;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/10 14:03
 */

public class TestNoBug {
/**
 * —— 程序员 A : 我写了一个类，它的名字叫做 NoBug，因为它所有的方法都没有错误。
 * —— 我：自信是好事，不过为了防止意外，让我测试一下如何？
 * —— 程序员 A: 怎么测试？
 * —— 我：把你写的代码的方法都加上 @Jiecha 这个注解就好了。
 * —— 程序员 A: 好的
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub

    NoBug testobj = new NoBug();

    Class clazz = testobj.getClass();

    Method[] method = clazz.getDeclaredMethods();
    //用来记录测试产生的 log 信息
    StringBuilder log = new StringBuilder();
    // 记录异常的次数
    int errornum = 0;

    for ( Method m: method ) {
        // 只有被 @Jiecha 标注过的方法才进行测试
        if ( m.isAnnotationPresent( Jiecha.class )) {
            try {
                m.setAccessible(true);
                m.invoke(testobj, null);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                errornum++;
                log.append(m.getName());
                log.append(" ");
                log.append("has error:");
                log.append("\n\r  caused by ");
                //记录测试过程中，发生的异常的名称
                log.append(e.getCause().getClass().getSimpleName());
                log.append("\n\r");
                //记录测试过程中，发生的异常的具体信息
                log.append(e.getCause().getMessage());
                log.append("\n\r");
            }
        }
    }


    log.append(clazz.getSimpleName());
    log.append(" has  ");
    log.append(errornum);
    log.append(" error.");

    // 生成测试报告
    System.out.println(log.toString());

}

}
