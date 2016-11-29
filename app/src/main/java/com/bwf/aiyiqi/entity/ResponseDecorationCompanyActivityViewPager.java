package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by lingchen52 on 2016/11/25.
 */

public class ResponseDecorationCompanyActivityViewPager {

    /**
     * error : 0
     * message : ok
     * data : [{"imagesrc":"http://appmanager.17house.com/upload/20160624/576cf9ad558bd_t.png","imagesrc2":"http://appmanager.17house.com/upload/20160624/576cfbb398185_t.png","banner_url":""},{"imagesrc":"http://appmanager.17house.com/upload/20160624/576cfbf8ab352_t.png","imagesrc2":"http://appmanager.17house.com/upload/20160624/576cfbc195e7f_t.png","banner_url":""}]
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
         * imagesrc : http://appmanager.17house.com/upload/20160624/576cf9ad558bd_t.png
         * imagesrc2 : http://appmanager.17house.com/upload/20160624/576cfbb398185_t.png
         * banner_url :
         */

        private String imagesrc;
        private String imagesrc2;
        private String banner_url;

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

        public String getBanner_url() {
            return banner_url;
        }

        public void setBanner_url(String banner_url) {
            this.banner_url = banner_url;
        }
    }
}
