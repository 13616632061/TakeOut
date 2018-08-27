package com.example.administrator.takeout.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.base.BaseFragment;
import com.example.administrator.takeout.bean.IndexAllTypeBean;
import com.example.administrator.takeout.bean.ShopInfoBean;
import com.example.administrator.takeout.contsants.Database;
import com.example.administrator.takeout.ui.activity.ShopDeatailActivity;
import com.example.administrator.takeout.ui.adapter.IndexTypeAdapter;
import com.example.administrator.takeout.ui.adapter.ShopInfoAdapter;
import com.example.administrator.takeout.ui.widght.NetworkImageHolderView;
import com.example.administrator.takeout.util.JsonUtil;
import com.google.gson.Gson;
import com.yhy.gvp.widget.GridViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Administrator on 2018/8/14.
 */

public class IndexFragment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {
    @InjectView(R.id.iv_convenientbanner)
    ConvenientBanner ivConvenientbanner;
    @InjectView(R.id.grid_viewpager)
    GridViewPager gridViewpager;
    @InjectView(R.id.indicator_container)
    MagicIndicator indicatorContainer;
    @InjectView(R.id.list)
    RecyclerView list;


    private Context context;
    private List<IndexAllTypeBean.TypeListBean> typeDatas = new ArrayList<>();
    private IndexTypeAdapter indexTypeAdapter;

    private List<ShopInfoBean.ShopInfoListBean> shopDatas = new ArrayList<>();
    private ShopInfoAdapter adapter;

    @Override
    protected int getContentId() {
        return R.layout.index_fragment_layout;
    }

    @Override
    protected void init() {
        super.init();
        context = getActivity();
        initAdData();
        initTypeData();
        initShopInfo();
    }

    /**
     * 广告轮播
     */
    private void initAdData() {
        List<String> ad_url = new ArrayList<>();
        for (String url : Database.ad_url) {
            ad_url.add(url);
        }
        ivConvenientbanner.startTurning(3000);
        ivConvenientbanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {

            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, ad_url);
    }

    /**
     * 分类
     */
    private void initTypeData() {
        //得到本地json文本内容
        String fileName = "index_ad.json";
        String json = JsonUtil.getJson(getActivity(), fileName);
        IndexAllTypeBean bean = new Gson().fromJson(json, IndexAllTypeBean.class);
        if (bean != null) {
            typeDatas.clear();
            for (IndexAllTypeBean.TypeListBean bean1 : bean.getTypeList()) {
                typeDatas.add(bean1);
            }
        }
        indexTypeAdapter = new IndexTypeAdapter(getActivity(), R.layout.item_index_type, typeDatas);
        gridViewpager.setGVPAdapter(indexTypeAdapter);

        Log.i("datas", (int) Math.ceil(typeDatas.size() / 10) + "");
        CommonNavigator commonNavigator = new CommonNavigator(context);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                int num = typeDatas.size() / 10;
                if (typeDatas.size() % 10 > 0) {
                    num++;
                }
                return typeDatas == null ? 0 : num;
            }

            @Override
            public IPagerTitleView getTitleView(Context mContext, final int i) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                View view = View.inflate(context, R.layout.single_image_layout, null);
                final ImageView iv_image = view.findViewById(R.id.iv_image);
                iv_image.setImageResource(R.drawable.point_unfocused);

                commonPagerTitleView.setContentView(view);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.OnPagerTitleChangeListener() {
                    @Override
                    public void onSelected(int i, int i1) {
                        iv_image.setImageResource(R.drawable.point_focused);
                    }

                    @Override
                    public void onDeselected(int i, int i1) {
                        iv_image.setImageResource(R.drawable.point_unfocused);
                    }

                    @Override
                    public void onLeave(int i, int i1, float v, boolean b) {

                    }

                    @Override
                    public void onEnter(int i, int i1, float v, boolean b) {

                    }
                });
                return commonPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                return null;
            }
        });
        indicatorContainer.setNavigator(commonNavigator);
        ViewPagerHelper.bind(indicatorContainer, gridViewpager);
    }

    private void initShopInfo() {
        //得到本地json文本内容
        String fileName = "shopInfo.json";
        String json = JsonUtil.getJson(getActivity(), fileName);
        ShopInfoBean bean = new Gson().fromJson(json, ShopInfoBean.class);
        if (bean != null) {
            shopDatas.clear();
            for (ShopInfoBean.ShopInfoListBean bean1 : bean.getShopInfoList()) {
                shopDatas.add(bean1);
            }
        }
        adapter = new ShopInfoAdapter(context, R.layout.item_shop_info, shopDatas);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(context));
        list.setNestedScrollingEnabled(false);

        adapter.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(BaseQuickAdapter madapter, View view, int position) {
        if(madapter==adapter){
            Intent intent=new Intent(context, ShopDeatailActivity.class);
            intent.putExtra("logo",shopDatas.get(position).getLogo());
            intent.putExtra("name",shopDatas.get(position).getName());
            startActivity(intent);
        }
    }
}
