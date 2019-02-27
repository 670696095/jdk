package com.cuizhiwen.jdk.proxy.jdkproxy.dao;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 15:21
 */
public class UserDaoImpl implements  UserDao {
    @Override
    public void query(String name){
        System.out.println(name);
    }
}
