package com.example.administrator.takeout.ui.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.takeout.R;
import com.example.administrator.takeout.bean.IndexAllTypeBean;
import com.example.administrator.takeout.ui.widght.CircleImageView;
import com.squareup.picasso.Picasso;
import com.yhy.gvp.adapter.GVPAdapter;

import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */

public class IndexTypeAdapter extends GVPAdapter<IndexAllTypeBean.TypeListBean> {
    private Context context;
    public IndexTypeAdapter(Context context,int layoutResId, @Nullable List<IndexAllTypeBean.TypeListBean> data) {
        super(layoutResId, data);
        this.context=context;
    }

    @Override
    public void bind(View item, int position, IndexAllTypeBean.TypeListBean data) {
        CircleImageView iv_image=item.findViewById(R.id.iv_image);
        TextView tv_type_name=item.findViewById(R.id.tv_type_name);
        Picasso.with(context).load(data.getImageUrl()).into(iv_image);
        if(data.getName().length()==2){
            tv_type_name.setText("  "+data.getName()+"  ");
        }else {
            tv_type_name.setText(data.getName());
        }
    }
}
