package com.cuizhiwen.jdk.designpattern.adapter;

/**
 * @author 01418061(cuizhiwen)
 * @Description:
 * @date 2019/1/21 17:45
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
