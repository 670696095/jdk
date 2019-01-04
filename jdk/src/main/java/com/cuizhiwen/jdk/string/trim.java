package com.cuizhiwen.jdk.string;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/3 13:24
 */
public class trim {
    /**
     * 字符串去空格
     * @return
     */
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    private String name;

    /**
     * trim:去除字符串两端，不仅仅是空格字符，它总共能去除25种字符。
     * @param args
     */
    public static void main(String[] args) {
            String str = "abc";
            System.out.println(str.length());
            str = str.trim();
            System.out.println(str.length());
            String string  = "    abc******";
            System.out.println(string.trim());
    }
}
