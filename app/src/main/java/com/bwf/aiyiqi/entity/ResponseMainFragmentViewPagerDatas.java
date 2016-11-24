package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/23.
 */

public class ResponseMainFragmentViewPagerDatas {


    /**
     * error : 0
     * message : ok
     * data : [{"title":"来自一起装修APP的分享","imagesrc":"http://appmanager.17house.com/upload/20161123/58356f0278d6d_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161123/58356f02842e6_t.jpg","tid":"","type":4,"banner_url":"http://tuan.17house.com/bj/2680.html"},{"title":"来自一起装修APP的分享","imagesrc":"http://appmanager.17house.com/upload/20161123/58356eabc82f4_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161123/58356eabe31e7_t.jpg","tid":"","type":4,"banner_url":"http://m.lianjia.com/subject/13622.html"},{"title":"装修省40%的秘笈，看这里！","imagesrc":"http://appmanager.17house.com/upload/20161105/581d862ee5809_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161105/581d862f1812b_t.jpg","tid":"","type":4,"banner_url":"http://m.17house.com/2662k0s1e2008.html"},{"title":"0元装修","imagesrc":"http://appmanager.17house.com/upload/20161109/5822e89f15dc6_t.jpg","imagesrc2":"http://appmanager.17house.com/upload/20161109/5822e89f371ab_t.jpg","tid":"","type":4,"banner_url":"http://wap.17house.com/daikuan/"},{"title":"全包装修80平米仅需5.4万","imagesrc":"http://appmanager.17house.com/upload/20160712/5784c5d8ec177_t.png","imagesrc2":"http://appmanager.17house.com/upload/20160712/5784c5d91e7a3_t.png","tid":"","type":4,"banner_url":"http://beijing.17zhuangxiu.com/zhengzhuang/"},{"title":"7年服务700万业主，口碑太好了！","imagesrc":"http://appmanager.17house.com/upload/20160709/57810cf956f1d_t.png","imagesrc2":"http://appmanager.17house.com/upload/20160709/57810cf9811e5_t.png","tid":"","type":4,"banner_url":"http://m.17house.com/banner/index.html"}]
     */

    private int error;
    private String message;
    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 来自一起装修APP的分享
         * imagesrc : http://appmanager.17house.com/upload/20161123/58356f0278d6d_t.jpg
         * imagesrc2 : http://appmanager.17house.com/upload/20161123/58356f02842e6_t.jpg
         * tid :
         * type : 4
         * banner_url : http://tuan.17house.com/bj/2680.html
         */

        private String title;
        private String imagesrc;
        private String imagesrc2;
        private String tid;
        private int type;
        private String banner_url;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImagesrc() {
            return imagesrc;
        }

        public void setImagesrc(String imagesrc) {
            this.imagesrc = imagesrc;
        }

        public String getImagesrc2() {
            return imagesrc2;
        }

        public void setImagesrc2(String imagesrc2) {
            this.imagesrc2 = imagesrc2;
        }

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }
    }
}
