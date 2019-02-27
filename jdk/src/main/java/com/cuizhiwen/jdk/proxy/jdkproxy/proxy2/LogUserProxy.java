package com.cuizhiwen.jdk.proxy.jdkproxy.proxy2;

import com.cuizhiwen.jdk.proxy.jdkproxy.dao.UserDao;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/26 15:25
 */
public class LogUserProxy implements UserDao {
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void query(String name){
        System.out.println("log *****");
        System.out.println(name);
    }
}
