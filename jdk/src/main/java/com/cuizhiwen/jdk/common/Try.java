package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 15:27
 */
public class Try {
    /**
     * try  中有return，先记下返回值，执行完finally后再返回
     * catch去捕捉一个异常
     * throw去抛出一个异常
     * throws标注方法可能抛出的异常
     * finally确保代码不论发生什么都执行。
     * @param args
     */
    public static void main(String[] args) {
        String str =null;
        for(int i = 0 ;i< 2;i++) {
            try {
                str.length();
                System.out.println(str.length());
                return;
            }catch (Exception e){
                System.out.println("----"+i);
                break;
            }
            finally {
                System.out.println("finally:"+i);
            }
        }
    }

}
