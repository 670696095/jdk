package com.cuizhiwen.jdk.io;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/11 14:02
 */
public class Serialize {
    /**
     * 对象序列化：
     *          把java对象转换成二进制字节流，同时存入磁盘或传入网络。
     *
     * 反序列化：从IO流中恢复java对象
     *
     * transient:标注不可序列化属性
     */
    transient  private String accountNo;
}
