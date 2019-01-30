package com.cuizhiwen.jdk.common.serializable;

import java.io.Serializable;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/30 13:15
 */
public class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck()
    {
        System.out.println("Mailing a check to " + name
                + " " + address);
    }
}
