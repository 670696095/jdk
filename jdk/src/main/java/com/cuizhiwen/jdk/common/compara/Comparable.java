package com.cuizhiwen.jdk.common.compara;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/4 10:26
 */
public class Comparable implements java.lang.Comparable<Comparable> {
    /**
     * 1>Comparable是一个内比较器，是一个排序接口。它依赖compareTo方法的实现比较
     *   实现了Comparable接口的类的对象的列表或数组可以通过Collections.sort或Arrays.sort进行自动排序。
     */
    private  String str;

    Comparable(String str){
        this.str = str;
    }
    @Override
    public int compareTo(Comparable o) {
        if (this.str.compareTo(o.str)>0){
            return 1;
        }else if(this.str.compareTo(o.str)==0){
            return 0;
        }else {
            return -1;
        }

    }

    public String getStr(){
        return str;
    }

    public static void main(String[] args)
    {
        Comparable t1 = new Comparable("c");
        Comparable t2 = new Comparable("c");
        Comparable t3 = new Comparable("b");
        Comparable t4 = new Comparable("d");
        System.out.println(t1.compareTo(t2));
        System.out.println(t1.compareTo(t3));
        System.out.println(t1.compareTo(t4));
    }
}
