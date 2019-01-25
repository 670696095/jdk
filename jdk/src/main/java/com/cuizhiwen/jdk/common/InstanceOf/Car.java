package com.cuizhiwen.jdk.common.InstanceOf;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/24 16:31
 */
public class Car extends Vehicle {
    /**
     * 子类是父类的类型，但父类不是子类的类型。
     * 子类的实例可以声明为父类型，但父类的实例不能声明为子类型。
     * @param args
     */

    public static void main(String args[]){
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();
        Car c1 = new Car();
        Car car = (Car) v2;

        boolean result1 =  c1 instanceof Vehicle;    // true
        boolean result2 =  c1 instanceof Car;        // true
        boolean result3 =  v1 instanceof Vehicle;    // true
        boolean result4 =  v1 instanceof Car;          // false
        boolean result5 =  v2 instanceof Vehicle;    // true
        boolean result6 =  v2 instanceof Car;          // true

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
    }
}
