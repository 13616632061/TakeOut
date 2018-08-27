package com.example.administrator.takeout.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.bean.ShopInfoBean;
import com.example.administrator.takeout.ui.widght.WarpLinearLayout;
import com.squareup.picasso.Picasso;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ShopInfoAdapter extends BaseQuickAdapter<ShopInfoBean.ShopInfoListBean,BaseViewHolder> {

    private Context context;
    public ShopInfoAdapter(Context context,int layoutResId, @Nullable List<ShopInfoBean.ShopInfoListBean> data) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ShopInfoBean.ShopInfoListBean item) {
        ImageView iv_logo=helper.getView(R.id.iv_logo);
        Picasso.with(context).load(item.getLogo()).into(iv_logo);

        helper.setText(R.id.tv_shop_name,item.getName());
        MaterialRatingBar rating_bar=helper.getView(R.id.rating_bar);
        rating_bar.setNumStars((int) item.getCode());
        helper.setText(R.id.tv_code,item.getCode()+"");
        helper.setText(R.id.tv_sale_nums,"月售"+item.getCode()+"");
        helper.setText(R.id.tv_send_time,item.getTime()+"分钟 | "+item.getPositon());
        helper.setText(R.id.tv_send_fee,item.getSend());
        helper.setText(R.id.tv_shop_type,item.getType());
        WarpLinearLayout warpLinear_layout=helper.getView(R.id.warpLinear_layout);

    }
}
