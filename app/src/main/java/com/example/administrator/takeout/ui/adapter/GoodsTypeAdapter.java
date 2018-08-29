package com.example.administrator.takeout.ui.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.bean.GoodsInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/24.
 */

public class GoodsTypeAdapter extends BaseQuickAdapter<GoodsInfoBean.GoodsInfoListBean,BaseViewHolder> {


    public GoodsTypeAdapter(int layoutResId, @Nullable List<GoodsInfoBean.GoodsInfoListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsInfoBean.GoodsInfoListBean item) {
        TextView tv_type_name=helper.getView(R.id.tv_type_name);
        tv_type_name.setText(item.getTypeName());
        Log.i("typeDatas",item.getTypeName());
        if(item.isSelect()){
            tv_type_name.setTextColor(Color.parseColor("#ffd966"));
            tv_type_name.setBackgroundResource(R.color.white);
        }else {
            tv_type_name.setTextColor(Color.parseColor("#1f1f1f"));
            tv_type_name.setBackgroundResource(R.color.bggray);
        }
        helper.addOnClickListener(R.id.tv_type_name);
    }
}
