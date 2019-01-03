package com.cuizhiwen.jdk.common;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 13:45
 */
public class Switch {
    /**
     * swtich()变量类型只能是int、short、char、byte和enum类型（JDK 1.7 之后，类型也可以是String了）
     */

    /**
     * 若未找到，则执行默认的case
     *
     * @return
     */
    public void fun1() {
        int i = 5;
        switch (i) {
            case 0:
                System.out.println("0");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

    /**
     * 当每一个case都不存在break时，JVM并不会顺序输出每一个case对应的返回值，而是继续匹配，匹配不成功则返回默认case
     *
     * @return
     */
    public void fun2() {
        int i = 5;
        switch (i) {
            case 0:
                System.out.println("000");
            case 1:
                System.out.println("111");
            case 2:
                System.out.println("222");
            default:
                System.out.println("default");
        }
    }


    /**
     * 当每一个case都不存在break时，匹配成功后，从当前case开始，依次返回后续所有case的返回值。
     *
     * @return
     */
    public void fun3() {
        int i = 2;
        switch (i) {
            case 0:
                System.out.println("00");
            case 1:
                System.out.println("11");
            case 2:
                System.out.println("22");
            default:
                System.out.println("default");
        }
    }

    /**
     * 若当前匹配成功的case不存在break，则从当前case开始，依次返回后续case的返回值，直到遇到break，跳出判断。
     *
     * @return
     */
    public void fun4() {
        int i = 2;
        switch (i) {
            case 0:
                System.out.println("0");
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println("3");
                break;
            default:
                System.out.println("default");
        }
    }
}
