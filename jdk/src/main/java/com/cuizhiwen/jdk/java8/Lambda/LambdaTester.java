package com.cuizhiwen.jdk.java8.Lambda;

import java.util.Comparator;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 9:53
 */
public class LambdaTester {
    /**
     * 初步理解为:
     *          接口的是实现类用lambda表达式。并且接口只能有一个抽象方法。
     *
     *  Lambda 表达式主要用来定义行内执行的方法类型接口，例如，一个简单方法接口。
     *          在下面例子中，我们使用各种类型的Lambda表达式来定义MathOperation接口的方法。然后我们定义了sayMessage的执行。
     *  Lambda 表达式免去了使用匿名方法的麻烦，并且给予Java简单但是强大的函数化的编程能力
     */
    final static String salutation = "Hello!!!! ";

    public static void main(String args[]){
        LambdaTester tester = new LambdaTester();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;
        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;
        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> { return a * b; };
        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + tester.operate(10, 5, division));

        // 不用括号
        GreetingService greetService1 = message -> System.out.println("Hi " + message);
        // 用括号
        GreetingService greetService2 = (message) ->System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");

        int  num = 66;
        GreetingService greetService3 = message -> System.out.println(salutation + message +num);
        greetService3.sayMessage("apple");

        String abc = "";
        Comparator<String> comparator = (first, second) -> Integer.compare(first.length(), second.length());

    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }






}
