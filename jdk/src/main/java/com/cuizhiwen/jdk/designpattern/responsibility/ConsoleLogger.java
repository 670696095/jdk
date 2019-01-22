package com.cuizhiwen.jdk.designpattern.responsibility;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 9:59
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
