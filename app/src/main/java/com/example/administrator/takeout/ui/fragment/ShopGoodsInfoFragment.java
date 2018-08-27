package com.example.administrator.takeout.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.takeout.R;
import com.example.administrator.takeout.base.BaseFragment;
import com.example.administrator.takeout.bean.GoodsInfoBean;
import com.example.administrator.takeout.bean.IndexAllTypeBean;
import com.example.administrator.takeout.ui.adapter.GoodsTypeAdapter;
import com.example.administrator.takeout.ui.adapter.IndexTypeAdapter;
import com.example.administrator.takeout.util.JsonUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2018/8/23.
 */

public class ShopGoodsInfoFragment extends BaseFragment {
    @InjectView(R.id.list)
    RecyclerView list;

    private Context context;
    private List<GoodsInfoBean.GoodsInfoListBean> typeDatas=new ArrayList<>();
    private GoodsTypeAdapter goodsTypeAdapter;
    @Override
    protected int getContentId() {
        return R.layout.shop_goodinfo_fragment;
    }

    @Override
    protected void init() {
        super.init();
        context=getActivity();
        initTypeData();
    }

    /**
     * 分类
     */
    private void initTypeData() {
        //得到本地json文本内容
        String fileName = "goodsinfo.json";
        String json = JsonUtil.getJson(getActivity(), fileName);
        GoodsInfoBean bean = new Gson().fromJson(json, GoodsInfoBean.class);
        if (bean != null) {
            typeDatas.clear();
            for (GoodsInfoBean.GoodsInfoListBean bean1 : bean.getGoodsInfoList()) {
                typeDatas.add(bean1);
            }
        }
        Log.i("typeDatas",typeDatas.size()+"");
        goodsTypeAdapter=new GoodsTypeAdapter(R.layout.item_goods_type,typeDatas);
        list.setAdapter(goodsTypeAdapter);
        list.setLayoutManager(new LinearLayoutManager(context));
    }
}