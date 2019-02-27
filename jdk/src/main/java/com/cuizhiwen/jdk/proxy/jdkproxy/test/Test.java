package com.cuizhiwen.jdk.proxy.jdkproxy.test;

import com.cuizhiwen.jdk.proxy.jdkproxy.dao.UserDaoImpl;
import com.cuizhiwen.jdk.proxy.jdkproxy.proxy.LogUserProxy;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 15:24
 */

/**
 * 类爆炸
 * 单一职责性
 * 代理对象：增强后的对象
 * 目标对象：被代理的对象
 * 静态代理
 */
public class Test {
    public static void main(String[] args) {
        UserDaoImpl userDao = new LogUserProxy();
        userDao.query("崔智文");
    }
}
