package com.cuizhiwen.jdk.exception;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 15:27
 */
public class Try {
    /**
     * try    中有return，先记下返回值，执行完finally后再返回
     * catch  去捕捉一个异常，并且程序退出。
     * throw  去抛出一个异常
     * throws 标注方法可能抛出的异常
     *
     * finally 确保代码不论发生什么都执行。finally中加入return会影响try中的return。
     *         finally一般用于回收try块中打开的物理资源。位于所有catch之后。
     *         用system.exit()可以阻止finally执行。
     *
     * @param args
     */
    public static void main(String[] args) {
        String str =null;
        for(int i = 0 ;i< 2;i++) {
            try {
                str.length();
                System.out.println(str.length());
                return;
            }catch (java.lang.Exception e){
                System.out.println("----"+i);
                break;
            }
            finally {
                System.out.println("finally:"+i);
            }
        }
    }

}
