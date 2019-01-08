package com.cuizhiwen.jdk.common.compara;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 10:40
 */
public class Comparator implements java.util.Comparator<Comparable> {
    /**
     * Comparator是一个外比较器.Comparator接口里面有一个compare方法，方法有两个参数T o1和T o2，是泛型的表示方式。
     * 使用条件：
     * 1、一个对象不支持自己和自己比较（没有实现Comparable接口），但是又想对两个对象进行比较
     * 2、一个对象实现了Comparable接口，但是开发者认为compareTo方法中的比较方式并不是自己想要的那种比较方式
     */
    @Override
    public int compare(Comparable o1, Comparable o2) {
        if (o1.getStr().compareTo(o2.getStr())>0){
            return 1;
        }else if(o1.getStr().compareTo(o2.getStr()) == 0){
            return 0;
        }else {
            return -1;
        }
    }

    public static void main(String[] args)
    {
        Comparable t1 = new Comparable("c");
        Comparable t2 = new Comparable("c");
        Comparable t3 = new Comparable("b");
        Comparable t4 = new Comparable("d");
        Comparator co = new Comparator();
        System.out.println(co.compare(t1, t2));
        System.out.println(co.compare(t1, t3));
        System.out.println(co.compare(t1, t4));
    }
}
