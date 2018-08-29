package com.example.administrator.takeout.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/24.
 */

public class GoodsInfoBean {


    private List<GoodsInfoListBean> goodsInfoList;

    public List<GoodsInfoListBean> getGoodsInfoList() {
        return goodsInfoList;
    }

    public void setGoodsInfoList(List<GoodsInfoListBean> goodsInfoList) {
        this.goodsInfoList = goodsInfoList;
    }

    public static class GoodsInfoListBean {
        /**
         * typeId : 0
         * typeName : 热销
         * typeGoodsList : [{"goodsId":"001","goodsName":"什锦坛子菜肉末饭+雪梨炖银耳+蒸蛋","goodsPicture":"https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3747848266,2546375444&fm=15&gp=0.jpg","monthSaleNums":684,"praiseNums":17,"nomalPrice":45,"discountPrice":21.9,"disconut":4.87}]
         */

        private String typeId;
        private String typeName;
        private boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean select) {
            isSelect = select;
        }

        private List<TypeGoodsListBean> typeGoodsList;

        public String getTypeId() {
            return typeId;
        }

        public void setTypeId(String typeId) {
            this.typeId = typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public List<TypeGoodsListBean> getTypeGoodsList() {
            return typeGoodsList;
        }

        public void setTypeGoodsList(List<TypeGoodsListBean> typeGoodsList) {
            this.typeGoodsList = typeGoodsList;
        }

        public static class TypeGoodsListBean {
            /**
             * goodsId : 001
             * goodsName : 什锦坛子菜肉末饭+雪梨炖银耳+蒸蛋
             * goodsPicture : https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3747848266,2546375444&fm=15&gp=0.jpg
             * monthSaleNums : 684
             * praiseNums : 17
             * nomalPrice : 45
             * discountPrice : 21.9
             * disconut : 4.87
             */
            private String typeId;
            private String typeName;
            private String goodsId;
            private String goodsName;
            private String goodsPicture;
            private int monthSaleNums;
            private int praiseNums;
            private double nomalPrice;
            private double discountPrice;
            private double disconut;

            public String getTypeId() {
                return typeId;
            }

            public void setTypeId(String typeId) {
                this.typeId = typeId;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public String getGoodsId() {
                return goodsId;
            }

            public void setGoodsId(String goodsId) {
                this.goodsId = goodsId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public String getGoodsPicture() {
                return goodsPicture;
            }

            public void setGoodsPicture(String goodsPicture) {
                this.goodsPicture = goodsPicture;
            }

            public int getMonthSaleNums() {
                return monthSaleNums;
            }

            public void setMonthSaleNums(int monthSaleNums) {
                this.monthSaleNums = monthSaleNums;
            }

            public int getPraiseNums() {
                return praiseNums;
            }

            public void setPraiseNums(int praiseNums) {
                this.praiseNums = praiseNums;
            }

            public double getNomalPrice() {
                return nomalPrice;
            }

            public void setNomalPrice(double nomalPrice) {
                this.nomalPrice = nomalPrice;
            }

            public double getDiscountPrice() {
                return discountPrice;
            }

            public void setDiscountPrice(double discountPrice) {
                this.discountPrice = discountPrice;
            }

            public double getDisconut() {
                return disconut;
            }

            public void setDisconut(double disconut) {
                this.disconut = disconut;
            }
        }
    }
}
