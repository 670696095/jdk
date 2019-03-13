package com.cuizhiwen.jdk.java8.Lambda;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/31 9:26
 */
public class Lambda {
    /**
     * Lambda 表达式
     *      也可称为闭包，它是推动 Java 8 发布的最重要新特性。
     *      Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
     *      使用 Lambda 表达式可以使代码变的更加简洁紧凑。
     * 语法
     *      (parameters) -> expression
     *      或
     *      (parameters) ->{ statements; }
     * lambda表达式的重要特征:
     *      1>可选类型声明：不需要声明参数类型，编译器可以统一识别参数值。
     *      2>可选的参数圆括号：一个参数无需定义圆括号，但多个参数需要定义圆括号。
     *      3>可选的大括号：如果主体包含了一个语句，就不需要使用大括号。
     *      4>可选的返回关键字：如果主体只有一个表达式返回值则编译器会自动返回值，大括号需要指定明表达式返回了一个数值。
     * 实例:
     *      // 1. 不需要参数,返回值为 5
     *          () -> 5
     *      // 2. 接收一个参数(数字类型),返回其2倍的值
     *          x -> 2 * x
     *      // 3. 接受2个参数(数字),并返回他们的差值
     *          (x, y) -> x – y
     *      // 4. 接收2个int型整数,返回他们的和
     *          (int x, int y) -> x + y
     *      // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
     *          (String s) -> System.out.print(s)
     *
     * 要点 3：lambda 表达式内部引用资源
     * lambda 内部可以使用静态、非静态和局部变量，这称为 lambda 内的变量捕获。
     * 要点 4：lambda 表达式也成闭包
     * Lambda 表达式在 Java 中又称为闭包或匿名函数，所以如果有同事把它叫闭包的时候，不用惊讶。
     * 要点 6：lambda 表达式的限制
     * lambda 表达式有个限制，那就是只能引用 final 或 final 局部变量，这就是说不能在 lambda 内部修改定义在
     * 域外的变量。
     */
    public static void main(String[] args) {
    }
}
