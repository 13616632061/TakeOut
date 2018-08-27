package com.example.administrator.takeout.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/17.
 */

public class ShopInfoBean {

    private List<ShopInfoListBean> shopInfoList;

    public List<ShopInfoListBean> getShopInfoList() {
        return shopInfoList;
    }

    public void setShopInfoList(List<ShopInfoListBean> shopInfoList) {
        this.shopInfoList = shopInfoList;
    }

    public static class ShopInfoListBean {
        /**
         * name : 吾虎将（龙岗天安店）
         * logo : https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1761247437,2627743593&fm=27&gp=0.jpg
         * code : 4.3
         * nums : 3780
         * time : 40分钟
         * send : 起送￥15|配送￥3|人均￥25
         * positon : 362m
         * type : 中式简餐
         * discount : [{"detail":"30减15"}]
         */

        private String name;
        private String logo;
        private double code;
        private int nums;
        private String time;
        private String send;
        private String positon;
        private String type;
        private List<DiscountBean> discount;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public double getCode() {
            return code;
        }

        public void setCode(double code) {
            this.code = code;
        }

        public int getNums() {
            return nums;
        }

        public void setNums(int nums) {
            this.nums = nums;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSend() {
            return send;
        }

        public void setSend(String send) {
            this.send = send;
        }

        public String getPositon() {
            return positon;
        }

        public void setPositon(String positon) {
            this.positon = positon;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<DiscountBean> getDiscount() {
            return discount;
        }

        public void setDiscount(List<DiscountBean> discount) {
            this.discount = discount;
        }

        public static class DiscountBean {
            /**
             * detail : 30减15
             */

            private String detail;

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }
        }
    }
}
