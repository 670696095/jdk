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
     * 泛型 ：为了让集合记住其元素数据类型。java5.0之前任何对象都可以存在集合中，取出后要进行正确的强转。
     * 本质 ：为了参数化类型（在不创建新的类型的情况下，通过泛型指定的不同类型来控制形参具体限制的类型）。
     *       也就是说在泛型使用过程中操作的数据类型被指定为一个参数，
     *       这种参数类型可以用在类、接口和方法中，分别被称为泛型类、泛型接口、泛型方法
     *
     * 注意： Java中的泛型，只在编译阶段有效
     *
     *       并不存在泛型类，所以静态方法，初始化块，变量声明与初始化中不允许使用类型参数。
     *
     *
     */

    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Type(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        /**
         * 菱形语法：省略了<>中的类型信息
         * */
        Map<String ,List<String>> info = new HashMap<>();
        //List arrayList = new ArrayList();
        arrayList.add("aaaa");
        //arrayList.add(100);

        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println(item);
        }
        /**
         * 通配符
         */
        List<?> list ;
        /**
         * 通配符上限
         */
        List <? extends Object> list1;
        /**
         * 通配符下限
         */
        List <? super Object> list2;
    }
}
