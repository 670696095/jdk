package com.cuizhiwen.jdk.common;

import java.util.UUID;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:02
 */
public class Uuid {
    /**
     * UUID生成不重复的随机数
     * @param args
     */
    public static void main(String[] args) {
       String str =  UUID.randomUUID().toString().replaceAll("-","").substring(0,13);
       System.out.println(str);

    }
}
