package com.cuizhiwen.jdk.type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/8 18:10
 */
public class Type<T> {
    /**
     * 泛型 ：
     *       为了让集合记住其元素数据类型
     *       因为 java5.0 之前任何对象都可以存在集合中，取出后要进行正确的强转。
     *
     * 本质 ：
     *       为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
     *       也就是说在泛型使用过程中操作的数据类型被指定为一个参数，
     *       这种参数类型可以用在类、接口和方法中，分别被称为1)泛型类、2)泛型接口、3)泛型方法
     *
     * 注意：
     *       1>Java中的泛型，只在编译阶段有效 编译后将泛型相关信息擦除，泛型信息不进入运行阶段。
     *       2>并不存在泛型类，所以静态方法，初始化块，变量声明与初始化中不允许使用类型参数。
     *       3>泛型类型参数只能是引用类型。数组没有参数化类型。
     * 类似:
     *       形参是方法运行时传值的占位符。
     *
     */


    /**
     * key这个成员变量的类型为T,T的类型由外部指定
     */
    private T key;

    /**
     * 泛型构造方法形参key的类型也为T，T的类型由外部指定
     */
    public Type(T key) {
        this.key = key;
    }

    /**
     * 泛型方法getKey的返回值类型为T，T的类型由外部指定
     */
    public T getKey(T t){
        return key;
    }


    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        /**
         * 菱形语法：省略了<>中的类型信息
         * */
        Map<String ,List<String>> info = new HashMap<>();
        arrayList.add("aaaa");

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println(item);
        }


        /**
         * 通配符
         */
        List<?> list ;
        /**
         * 通配符上限  应用于本类及其子类
         */
        List <? extends Object> list1;
        /**
         * 通配符下限  应用于本类及其父类
         */
        List <? super Object> list2;
    }
}
