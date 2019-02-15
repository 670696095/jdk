package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/15 13:43
 */
public class Tequals {
    /**
     * equals：
     *      首先 equals 方法必须满足自反性（x.equals(x)必须返回 true）、对称性（x.equals(y)返回 true 时，y.equals(x)
     *      也必须返回 true）、传递性（x.equals(y)和 y.equals(z)都返回 true 时，x.equals(z)也必须返回 true）和一致性（当
     *      x 和 y 引用的对象信息没有被修改时，多次调用 x.equals(y)应该得到同样的返回值），而且对于任何非 null 值的引
     *      用 x，x.equals(null)必须返回 false。实现高质量的 equals 方法的诀窍包括：1. 使用==操作符检查"参数是否为这个
     *      对象的引用"；2. 使用 instanceof 操作符检查"参数是否为正确的类型"；3. 对于类中的关键属性，检查参数传入对象
     *      的属性是否与之相匹配；4. 编写完 equals 方法后，问自己它是否满足对称性、传递性、一致性；5. 重写 equals 时
     *      总是要重写 hashCode；6. 不要将 equals 方法参数中的 Object 对象替换为其他的类型，在重写时不要忘掉
     *      @Override 注解。
     */
    public static void main(String[] args) {
        String string = "123";
         System.out.println(string.equals(null));
    }

}
