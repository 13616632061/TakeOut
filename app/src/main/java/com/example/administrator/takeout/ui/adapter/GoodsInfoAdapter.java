package com.example.administrator.takeout.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.bean.GoodsInfoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/8/27.
 */

public class GoodsInfoAdapter extends BaseQuickAdapter<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean,BaseViewHolder> {

    private Context context;
    public GoodsInfoAdapter(Context context,int layoutResId, @Nullable List<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean> data) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    protected void convert(BaseViewHolder helper, GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean item) {
        ImageView iv_good= helper.getView(R.id.iv_good);
        Picasso.with(context).load(item.getGoodsPicture()).into(iv_good);
        helper.setText(R.id.tv_name,item.getGoodsName());
        helper.setText(R.id.tv_sale_nums,"月售"+item.getMonthSaleNums()+"    赞"+item.getPraiseNums());
        helper.setText(R.id.tv_dicount_price,"￥"+item.getDiscountPrice());
        helper.setText(R.id.tv_nomal_price,"￥"+item.getNomalPrice());
        helper.setText(R.id.tv_dicount,item.getDisconut()+"折");
    }
}
