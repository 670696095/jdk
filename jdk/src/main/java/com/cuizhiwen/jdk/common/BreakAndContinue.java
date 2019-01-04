package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 15:09
 */
public class BreakAndContinue {
    /**
     * 1>break 跳出一个或者结束一个循环
     * 2>continue 结束本次循环，继续执行下一个循环。
     */

    public static void main(String[] args) {
        /**
         * 方法一 跳出多重循环 打标号
         */
        ok:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) {
                    break ok;
                }
            }

        }

        /**
         * 方法二 外层循环条件表达式受内层循环控制
         */
        int [][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        boolean flag = false;
        for (int i = 0; i <arr.length &&!flag; i++) {
            for (int j = 0; j <arr[i].length ; j++) {
                if (arr[i][j]==5){
                    flag = true;
                    break;
                }
            }
        }

    }

}
