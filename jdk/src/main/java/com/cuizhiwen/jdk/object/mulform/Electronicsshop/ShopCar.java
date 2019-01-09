package com.cuizhiwen.jdk.object.mulform.Electronicsshop;

import java.util.ArrayList;
import java.util.List;

/**
 * 购物车
 */
public class ShopCar {

    private List<Electronics> mlist = new ArrayList<>();

    public void add(Electronics electronics){

        mlist.add(electronics);

    }

    public int getSize(){

        return mlist.size();
    }


    public Electronics getListItem(int position){

        return mlist.get(position);

    }


}
