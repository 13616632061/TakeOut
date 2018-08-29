package com.example.administrator.takeout.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.holder.Holder;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.bean.GoodsInfoBean;
import com.example.administrator.takeout.bean.MultiItemView;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2018/8/27.
 */

public class GoodsInfoAdapter extends BaseMultiItemQuickAdapter<MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean>, BaseViewHolder> {
    private Context context;

    public GoodsInfoAdapter(Context context, List<MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean>> data) {
        super(data);
        this.context = context;

        addItemType(MultiItemView.TITLE, R.layout.item_goods_info_title);
        addItemType(MultiItemView.BODY, R.layout.item_goods_info_layout);
    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean> item) {
        switch (item.getItemType()) {
            case MultiItemView.TITLE:
                helper.setText(R.id.tv_type_name,item.getGoodsTypeName());
                break;
            case MultiItemView.BODY:
                ImageView iv_good = helper.getView(R.id.iv_good);
                Picasso.with(context).load(item.getData().getGoodsPicture()).into(iv_good);
                helper.setText(R.id.tv_name, item.getData().getGoodsName());
                helper.setText(R.id.tv_sale_nums, "月售" + item.getData().getMonthSaleNums() + "    赞" + item.getData().getPraiseNums());
                helper.setText(R.id.tv_dicount_price, "￥" + item.getData().getDiscountPrice());
                helper.setText(R.id.tv_nomal_price, "￥" + item.getData().getNomalPrice());
                if(item.getData().getDisconut()>0){
                    helper.setText(R.id.tv_dicount, item.getData().getDisconut() + "折");
                }
                break;
        }
    }

//    private Context context;
//    public GoodsInfoAdapter(Context context,int layoutResId, @Nullable List<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean> data) {
//        super(layoutResId, data);
//        this.context=context;
//    }
//
//    @Override
//    protected void convert(BaseViewHolder helper, GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean item) {
//        ImageView iv_good= helper.getView(R.id.iv_good);
//        Picasso.with(context).load(item.getGoodsPicture()).into(iv_good);
//        helper.setText(R.id.tv_name,item.getGoodsName());
//        helper.setText(R.id.tv_sale_nums,"月售"+item.getMonthSaleNums()+"    赞"+item.getPraiseNums());
//        helper.setText(R.id.tv_dicount_price,"￥"+item.getDiscountPrice());
//        helper.setText(R.id.tv_nomal_price,"￥"+item.getNomalPrice());
//        helper.setText(R.id.tv_dicount,item.getDisconut()+"折");
//    }
}
