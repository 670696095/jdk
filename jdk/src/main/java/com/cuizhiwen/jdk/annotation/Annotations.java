package com.cuizhiwen.jdk.annotation;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/9 14:57
 */
@DefineAnnotation(id=3,msg="hello annotation")
public class Annotations {
    /**
     * Annotation：注解
     *              1>可在编译，类加载 ，运行时被读取并执行相应的处理(不改变原有逻辑情况下，在源文件中嵌入一些补充信息进行验证或部署)
     *              2>通过反射获取指定元素的Annotation对象，通过该对象获取注解中的元数据。
     *              3>Java所有注解都继承了Annotation接口
     *
     * 元注解：就是标记其他注解的注解
     * @Retentain: 指定被修饰的对象使用时期
     * @Target:    指定能修饰哪些程序单元
     * @Documented: 被修饰的注解会生成到javadoc中
     * @Inherited: 具有继承性，父类使用子类自动使用。不是真正的继承，只是通过使用@Inherited，可以让子类Class对象使用getAnnotations()获取父类被@Inherited修饰的注解
     * @Repeatable: 是JDK1.8新加入的，它表示在同一个位置重复相同的注解。
     *
     * @Override： 用于标明此方法覆盖了父类的方法。
     * @Deprecated： 用于标明已经过时的方法或类。
     * @SuppressWarnnings： 用于有选择的关闭编译器对类、方法、成员变量、变量初始化的警告。
     * @SafeVarargs: 参数安全类型注解。它的目的是提醒开发者不要用参数做一些不安全的操作
     * @FunctionalInterface: 函数式接口注解
     * @Test 标记了要进行测试的方法
     *
     * 注解有许多用处，主要如下：
     *                    - 提供信息给编译器： 编译器可以利用注解来探测错误和警告信息
     *                    - 编译阶段时的处理： 软件工具可以用来利用注解信息来生成代码、Html文档或者做其它相应处理。
     *                    - 运行时的处理： 某些注解可以在程序运行的时候接受代码的提取
     *
     * 1>如果注解难于理解，你就把它类同于标签，标签为了解释事物，注解为了解释代码。
     * 2>注解的基本语法，创建如同接口，但是多了个 @ 符号。
     * 3>注解的元注解。
     * 4>注解的属性。
     * 5>注解主要给编译器及工具类型的软件用的。
     * 6>注解的提取需要借助于 Java 的反射技术，反射比较慢，所以注解使用时也需要谨慎计较时间成本。
     */
    public static void main(String[] args) {
        /**
         *  isAnnotationPresent() 方法判断它是否应用了某个注解
         */
        boolean hasAnnotation = Annotations.class.isAnnotationPresent(DefineAnnotation.class);

        if ( hasAnnotation ) {
            /**
             * getAnnotation() 方法来获取 Annotation 对象。
             */
            DefineAnnotation defineAnnotation = Annotations.class.getAnnotation(DefineAnnotation.class);

            System.out.println("id:"+defineAnnotation.id());
            System.out.println("msg:"+defineAnnotation.msg());
        }

    }

}
