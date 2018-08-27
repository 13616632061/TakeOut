package com.example.administrator.takeout.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.takeout.R;
import com.example.administrator.takeout.base.BaseActivity;
import com.example.administrator.takeout.base.BaseFragment;
import com.example.administrator.takeout.ui.fragment.ShopEvaluationFragment;
import com.example.administrator.takeout.ui.fragment.ShopGoodsInfoFragment;
import com.example.administrator.takeout.ui.fragment.ShopInfoFragment;
import com.example.administrator.takeout.ui.widght.CircleImageView;
import com.example.administrator.takeout.util.ScreenUtil;
import com.nshmura.recyclertablayout.RecyclerTabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShopDeatailActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener, ViewPager.OnPageChangeListener, View.OnClickListener {


    @InjectView(R.id.iv_search)
    ImageView ivSearch;
    @InjectView(R.id.iv_collect)
    ImageView ivCollect;
    @InjectView(R.id.iv_spell)
    CircleImageView ivSpell;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.iv_logo)
    ImageView ivLogo;
    @InjectView(R.id.tv_shop_name)
    TextView tvShopName;
    @InjectView(R.id.tv_shop_notice)
    TextView tvShopNotice;
    @InjectView(R.id.id_stickynavlayout_topview)
    LinearLayout idStickynavlayoutTopview;
    @InjectView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @InjectView(R.id.tab_layout)
    RecyclerTabLayout tabLayout;
    @InjectView(R.id.app_bar)
    AppBarLayout appBar;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    @InjectView(R.id.tv_title)
    TextView tvTitle;
    private String logo;
    private String name;
    private int toolBarPositionY;
    private List<BaseFragment> fragments;
    private FragmentPagerAdapter adapter;
    private String[] str_title = new String[]{
            "点菜", "评价", "商家"
    };


    private float mSelfHeight = 0;  //用以判断是否得到正确的宽高值
    private float mTitleScale;      //标题缩放值

    @Override
    protected int getContentId() {
        return R.layout.activity_shop_deatail;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.shop_menu_layout, menu);
        return true;
    }

    @Override
    protected void init() {
        super.init();
        name = getIntent().getStringExtra("name");
        logo = getIntent().getStringExtra("logo");
        String spell = "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=1686994733,2576422987&fm=26&gp=0.jpg";
        Picasso.with(this).load(spell).into(ivSpell);
        if (!TextUtils.isEmpty(name)) {
            tvShopName.setText(name);
            Picasso.with(this).load(logo).into(ivLogo);
            tvTitle.setText(name);
        }
        setSupportActionBar(toolbar);
        toolbar.setOnMenuItemClickListener(this);
        toolbar.setNavigationIcon(R.drawable.icon_back);
        toolbar.setNavigationOnClickListener(this);


        appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (verticalOffset >-90) {
                    tvTitle.setVisibility(View.GONE);
                }else {
                    tvTitle.setVisibility(View.VISIBLE);
                    tvTitle.setText(name);
                }
            }
        });
        initFragment();

    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShopGoodsInfoFragment());
        fragments.add(new ShopEvaluationFragment());
        fragments.add(new ShopInfoFragment());

        adapter = new FragmentAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
        viewpager.setOnPageChangeListener(this);

        tabLayout.setUpWithViewPager(viewpager);

    }


    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.iv_search:
                break;
            case R.id.iv_collect:
                break;
            case R.id.iv_spell:
                break;
            case R.id.iv_more:
                break;
        }
        return false;
    }

    /**
     * viewpage左右滑动
     *
     * @param i
     * @param v
     * @param i1
     */
    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    /**
     * 返回按钮
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        finish();
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return str_title[position];
        }
    }

}
