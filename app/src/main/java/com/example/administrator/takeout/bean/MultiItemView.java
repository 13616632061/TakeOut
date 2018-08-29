package com.example.administrator.takeout.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2018/8/28.
 */

public class MultiItemView<T> implements MultiItemEntity {

    public static final int TITLE = 1;
    public static final int BODY = 2;
    public static final int FOOTER = 3;
    private int itemType;
    private T data;
    private String goodsTypeName;

    public String getGoodsTypeName() {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName) {
        this.goodsTypeName = goodsTypeName;
    }

    public MultiItemView(int itemType) {
        this.itemType = itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public int getItemType() {
        return itemType;
    }
}
