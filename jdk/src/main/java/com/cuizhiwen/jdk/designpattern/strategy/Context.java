package com.cuizhiwen.jdk.designpattern.strategy;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 9:40
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }

    public static void main(String[] args) {
        /**
         * 此操作本质是实现了多态 ，向上转型
         * strategy是一个接口，而接口不能new对象，就无法调用方法，这时候就要向上转型，再调用方法，
         * 而且只能调用接口里的方法，而不能调用实现类方法，想要调用实现类中的方法就要向下转型。
         */
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
    }
}
