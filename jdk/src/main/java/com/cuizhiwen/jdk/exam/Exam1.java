package com.cuizhiwen.jdk.exam;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/3/12 17:02
 */

public class Exam1 {
        public static void main(String[] args) {
            StringBuffer a = new StringBuffer("a");
            StringBuffer b = new StringBuffer("b");
            append1(a, b);
            System.out.println(a + "&&&" + b);
            System.out.println(a);

            String str1 = new StringBuilder().append("1").toString();
            System.out.println(str1.intern() == str1);
            String str2 = new StringBuilder().append("3").append("4").toString();
            System.out.println(str2.intern() == str2);

        }

        private static void append1(StringBuffer a, StringBuffer b) {
            a.append(b);
            System.out.println(a + "---" + b);
            b = a;
            System.out.println(a + "***" + b);
        }
    }