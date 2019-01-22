package com.cuizhiwen.jdk.designpattern.responsibility;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/22 10:01
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
