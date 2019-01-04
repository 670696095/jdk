package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 10:03
 */
public class IsNull {
    /**
     * 判空的方式
     * @param args
     */
    public static void main(String[] args) {
        String s = null;
        if(s == null ||"".equals(s)){
            System.out.println("方法一");
        }
        if(s == null || s.length() <= 0){
            System.out.println("方法二");
        }
        if (s == null || s == ""){
            System.out.println("方法三");
        }

    }
}
