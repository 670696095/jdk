package com.cuizhiwen.jdk.collection.array;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/2/20 14:45
 */
public class Tarray {
    /**
     * 面向对象的方法求出数组中重复 value 的个数
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};
        int[] brr = new int[123];

        for(int i = 0 ; i<arr.length; i ++) {
            //System.out.print(i+",");
            //System.out.print(arr[i]+",");
            //System.out.print(brr[arr[i]]+",");
            //System.out.println(brr[arr[i]]++);

            brr[arr[i]]++;

        }
        for(int i = 0 ; i<brr.length; i ++) {
            if(brr[i]!=0) {
                System.out.println("字符：" + i + "出现" + brr[i] +"次");
            }
        }
    }
    }

