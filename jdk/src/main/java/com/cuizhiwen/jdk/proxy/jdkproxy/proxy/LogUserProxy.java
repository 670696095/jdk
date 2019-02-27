package com.cuizhiwen.jdk.proxy.jdkproxy.proxy;

import com.cuizhiwen.jdk.proxy.jdkproxy.dao.UserDaoImpl;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 15:25
 */
public class LogUserProxy extends UserDaoImpl {
    @Override
    public void query(String name){
        System.out.println("log *****");
        System.out.println(name);
    }
}
