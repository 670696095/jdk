package com.cuizhiwen.jdk.designpattern.adapter;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 17:46
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
