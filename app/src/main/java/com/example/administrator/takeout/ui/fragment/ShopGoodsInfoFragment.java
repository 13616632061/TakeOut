package com.example.administrator.takeout.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.base.BaseFragment;
import com.example.administrator.takeout.bean.GoodsInfoBean;
import com.example.administrator.takeout.bean.MultiItemView;
import com.example.administrator.takeout.ui.adapter.GoodsInfoAdapter;
import com.example.administrator.takeout.ui.adapter.GoodsTypeAdapter;
import com.example.administrator.takeout.util.JsonUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2018/8/23.
 */

public class ShopGoodsInfoFragment extends BaseFragment implements BaseQuickAdapter.OnItemChildClickListener {
    @InjectView(R.id.list)
    RecyclerView list;
    @InjectView(R.id.list_goods)
    RecyclerView listGoods;

    private Context context;
    private List<GoodsInfoBean.GoodsInfoListBean> typeDatas = new ArrayList<>();
    private GoodsTypeAdapter goodsTypeAdapter;
    private List<MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean>> goodsDatas = new ArrayList<>();
    private GoodsInfoAdapter goodsInfoAdapter;

    @Override
    protected int getContentId() {
        return R.layout.shop_goodinfo_fragment;
    }

    @Override
    protected void init() {
        super.init();
        context = getActivity();
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
            goodsDatas.clear();
            for (GoodsInfoBean.GoodsInfoListBean bean1 : bean.getGoodsInfoList()) {
                typeDatas.add(bean1);
                MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean> multiItemViewTitle=new MultiItemView<>(MultiItemView.TITLE);
                multiItemViewTitle.setGoodsTypeName(bean1.getTypeName());
                goodsDatas.add(multiItemViewTitle);
                for (GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean bean3 : bean1.getTypeGoodsList()) {
                    MultiItemView<GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean> multiItemViewBody=new MultiItemView<>(MultiItemView.BODY);
                    GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean bean4=new GoodsInfoBean.GoodsInfoListBean.TypeGoodsListBean();
                    bean4.setGoodsName(bean3.getGoodsName());
                    bean4.setDisconut(bean3.getDisconut());
                    bean4.setDiscountPrice(bean3.getDiscountPrice());
                    bean4.setGoodsId(bean3.getGoodsId());
                    bean4.setGoodsPicture(bean3.getGoodsPicture());
                    bean4.setMonthSaleNums(bean3.getMonthSaleNums());
                    bean4.setNomalPrice(bean3.getNomalPrice());
                    bean4.setPraiseNums(bean3.getPraiseNums());
                    bean4.setMonthSaleNums(bean3.getMonthSaleNums());
                    multiItemViewBody.setData(bean4);
                    goodsDatas.add(multiItemViewBody);
                }
            }

        }
        Log.i("typeDatas", typeDatas.size() + "");
        goodsTypeAdapter = new GoodsTypeAdapter(R.layout.item_goods_type, typeDatas);
        list.setAdapter(goodsTypeAdapter);
        list.setLayoutManager(new LinearLayoutManager(context));
        typeDatas.get(0).setSelect(true);
        goodsTypeAdapter.setOnItemChildClickListener(this);

        goodsInfoAdapter = new GoodsInfoAdapter(context, goodsDatas);
        listGoods.setAdapter(goodsInfoAdapter);
        listGoods.setLayoutManager(new LinearLayoutManager(context));
        listGoods.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // 第一个可见位置
                int firstItemPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
                String firstItemPosition_typeId=goodsDatas.get(firstItemPosition).getGoodsTypeName();
                if(!TextUtils.isEmpty(firstItemPosition_typeId)){
                    for(int i=0;i<typeDatas.size();i++){
                        if(firstItemPosition_typeId.equals(typeDatas.get(i).getTypeName())){
                            for(int k=0;k<typeDatas.size();k++){
                                typeDatas.get(k).setSelect(false);
                            }
                            typeDatas.get(i).setSelect(true);
                            goodsTypeAdapter.notifyDataSetChanged();
                            list.scrollToPosition(i);
                            break;
                        }
                    }
                }
            }
        });
    }

    /**
     * 商品分类点击事件
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        for(int i=0;i<typeDatas.size();i++){
            typeDatas.get(i).setSelect(false);
        }
        typeDatas.get(position).setSelect(true);
        goodsTypeAdapter.notifyDataSetChanged();

        for(int i=0;i<goodsDatas.size();i++){
            if(typeDatas.get(position).getTypeName().equals(goodsDatas.get(i).getGoodsTypeName())){
                smoothMoveToPosition(listGoods,i);
                break;
            }
        }

    }
    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    /**
     * 使指定的项平滑到顶部
     *
     * @param mRecyclerView
     * @param position      待指定的项
     */
    private void smoothMoveToPosition(final RecyclerView mRecyclerView, final int position) {
        int firstItemPosition = -1;
        int lastItemPosition = -1;

        //todo 获取第一个和最后一个可见位置方式1
        // 第一个可见位置
        firstItemPosition = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        lastItemPosition = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));
        Log.i("firstItemPosition",firstItemPosition+"");
        Log.i("lastItemPosition",lastItemPosition+"");
        if (position < firstItemPosition) {
            // 第一种可能:跳转位置在第一个可见位置之前
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItemPosition) {
            // 第二种可能:跳转位置在第一个可见位置之后,在最后一个可见项之前
            int movePosition = position - firstItemPosition;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);//dx>0===>向左  dy>0====>向上
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;

            //监听事件的设置，仅仅是为了第三种情况，即：要跳转的位置在可见项之后
            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if (mShouldScroll && RecyclerView.SCROLL_STATE_IDLE == newState) {//
                        mShouldScroll = false;
                        smoothMoveToPosition(mRecyclerView, mToPosition);
                    }
                }
            });
        }
    }
}
