package com.cuizhiwen.jdk.designpattern.strategy;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 9:38
 */
public class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
