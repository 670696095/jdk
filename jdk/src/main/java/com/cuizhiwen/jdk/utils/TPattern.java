package com.cuizhiwen.jdk.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/11 11:25
 */
public class TPattern {
    /**
     * 正则表达式 pattern类
     *      正则表达式定义了字符串的模式。
     *      正则表达式可以用来搜索、编辑或处理文本。
     *      正则表达式并不仅限于某一种语言，但是在每种语言中有细微的差别。
     *      一个字符串其实就是一个简单的正则表达式 .匹配任何一个字符
     * Pattern 类：
     *      pattern 对象是一个正则表达式的编译表示。Pattern 类没有公共构造方法。要创建一个 Pattern 对象，
     *      你必须首先调用其公共静态编译方法，它返回一个 Pattern 对象。该方法接受一个正则表达式作为它的第一个参数。
     * Matcher 类：
     *      Matcher 对象是对输入字符串进行解释和匹配操作的引擎。与Pattern 类一样，Matcher 也没有公共构造方法。
     *      你需要调用 Pattern 对象的 matcher 方法来获得一个 Matcher 对象。
     * ^\d+(\.\d+)? :
     *      ^ 定义了以什么开始
     *      \d+ 匹配一个或多个数字
     *      ? 设置括号内的选项是可选的
     *      \. 匹配 "."
     *      \s+ 可以匹配多个空格
     * 注意:
     *       Java 的正则表达式中，两个 \\ 代表其他语言中的一个 \，这也就是为什么表示一位数字的正则表达式是 \\d，而表示一个普通的反斜杠是 \\\\
     * 方法:
     *      start 和 end 方法：                索引方法
     *      matches 和 lookingAt 方法         研究方法
     *      replaceFirst 和 replaceAll方法       替换方法
     *      appendReplacement 和 appendTail方法
     *
     */
    private static Pattern ERROR_PATTERN = Pattern.compile("^([1-9]\\d{0,9}|0)([.]?|(\\.\\d{1,2})?)$");

    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT = "cat cat cat cattie cat";
    public static void main(String[] args) {
        Matcher m = ERROR_PATTERN.matcher("123");
        Boolean b = m.matches();
        System.out.println(b);

        String content = "I am noob "+"from runoob.com.";
        String pattern = ".*runoob.*";
        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);


            Pattern p = Pattern.compile(REGEX);
            // 获取 matcher 对象
            Matcher mm = p.matcher(INPUT);
            int count = 0;

            while(mm.find()) {
                count++;
                System.out.println("Match number "+count);
                System.out.println("start(): "+m.start());
                System.out.println("end(): "+m.end());
            }
        }

}
