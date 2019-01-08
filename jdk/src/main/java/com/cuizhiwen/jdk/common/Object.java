package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 15:23
 */
public class Object {
    /**
     * 创建对象时，构造器调用顺序
     * 1>先初始化静态成员变量
     * 2>调用父类构造器
     * 3>初始化非静态成员变量
     * 4>调用自身构造器
     *
     * 注意:初始化块在创建java对象时候隐式执行，总在 构造器之前 静态初始化之后 执行。(初始化块是对无需接收参数的代码的抽离)
     *
     * po持久对象 Do领域对象 To传输对象 Dto数据传输对象 Vo值对象  Bo业务对象 DAo数据访问对象
     */
}
