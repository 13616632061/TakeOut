package com.example.administrator.takeout.ui.activity;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.administrator.takeout.R;
import com.example.administrator.takeout.base.BaseActivity;
import com.example.administrator.takeout.ui.fragment.IndexFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @InjectView(R.id.tab_index)
    RadioButton tabIndex;
    @InjectView(R.id.tab_recommend)
    RadioButton tabRecommend;
    @InjectView(R.id.tab_order)
    RadioButton tabOrder;
    @InjectView(R.id.tab_my)
    RadioButton tabMy;
    @InjectView(R.id.tabs_rg)
    RadioGroup tabsRg;
    @InjectView(R.id.main_fragment)
    FrameLayout mainFragment;

    @Override
    protected int getContentId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        super.init();

        tabsRg.setOnCheckedChangeListener(this);
        tabsRg.getChildAt(0).performClick();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        //设置底部导航栏字体颜色
        RadioButton rb = (RadioButton) radioGroup.findViewWithTag("checked");
        if (rb != null) {
            rb.setTextColor(rb.getResources().getColor(R.color.text_color_title));
            rb.setTag(null);
        }
        RadioButton radioButton = (RadioButton) radioGroup.findViewById(checkedId);
        radioButton.setTag("checked");
        radioButton.setTextColor(radioButton.getResources().getColor(R.color.red));

        switch (checkedId) {
            case R.id.tab_index:
                showFragment(R.id.main_fragment,new IndexFragment());
                break;
            case R.id.tab_recommend:
//                showFragment(R.id.main_fragment,new RecomendFragment());
                break;
            case R.id.tab_order:
//                showFragment(R.id.main_fragment,new SearchFragment());
                break;
            case R.id.tab_my:
//                showFragment(R.id.main_fragment,new ChatFragment());
                break;

        }
    }
}
