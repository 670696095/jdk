package com.cuizhiwen.jdk.common.serializable;

import java.io.*;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 13:10
 */
public class TSerializable {
    /**
     * 序列化:
     *      1>Java 提供了一种对象序列化的机制，该机制中，一个对象可以被表示为一个字节序列，
     *        该字节序列包括该对象的数据、有关对象的类型的信息和存储在对象中数据的类型。
     *      2>将序列化对象写入文件之后，可以从文件中读取出来，并且对它进行反序列化，
     *        也就是说，对象的类型信息、对象的数据，还有对象中的数据类型可以用来在内存中新建对象
     * 必须满足两个条件：
     *
     *      1)该类必须实现 java.io.Serializable 对象。
     *      2)该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的
     *      3)检验一个类的实例是否能序列化十分简单， 只需要查看该类有没有实现 java.io.Serializable接口。
     */

    public static void main(String [] args)
    {
        Employee e = new Employee();
        e.name = "cuizhiwen";
        e.address = "xi an";
        e.SSN = 666;
        e.number = 187;
        try
        {
            FileOutputStream fileOut =
                    new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        }catch(IOException i)
        {
            i.printStackTrace();
        }



        Employee ee = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ee = (Employee) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
