package com.example.administrator.takeout.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/15.
 */

public class IndexAllTypeBean {

    private List<TypeListBean> typeList;

    public List<TypeListBean> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<TypeListBean> typeList) {
        this.typeList = typeList;
    }

    public static class TypeListBean {
        /**
         * imageUrl : http://img4.imgtn.bdimg.com/it/u=379114902,527892946&fm=27&gp=0.jpg
         * name : 美食
         */

        private String imageUrl;
        private String name;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
