package com.cuizhiwen.jdk.designpattern.strategy;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 9:39
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
