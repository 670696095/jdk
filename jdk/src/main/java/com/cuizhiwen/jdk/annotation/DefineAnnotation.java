package com.cuizhiwen.jdk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DefineAnnotation {
    /**
     * 自定义注解
     *          一旦定义了成员变量后，使用Annotation时应该为成员变量
     *          1>要么使用时指定。
     *          2>要么定义时设置default值。
     * @return
     */
    int id() default 1;

    String msg() default  "hello";

}
