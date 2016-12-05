package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by lingchen52 on 2016/12/1.
 */

public class ResponseArticleCommunite {

    /**
     * error : 0
     * message : ok
     * data : {"total":"3","data":[{"comment_content_id":"1695","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480493485","comment_region_city":"0","comment_content":"😊","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"},{"comment_content_id":"1694","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480492262","comment_region_city":"0","comment_content":"好","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"},{"comment_content_id":"1693","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480473994","comment_region_city":"0","comment_content":"哦哦","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"}]}
     */

    private int error;
    private String message;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 3
         * data : [{"comment_content_id":"1695","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480493485","comment_region_city":"0","comment_content":"😊","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"},{"comment_content_id":"1694","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480492262","comment_region_city":"0","comment_content":"好","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"},{"comment_content_id":"1693","is_hidden":"0","comment_obj_id":"259785","comment_column_id":"4","comment_user_id":"1634546","comment_user_ip":"192.168.1.83","comment_time":"1480473994","comment_region_city":"0","comment_content":"哦哦","comment_user_name":"里-2","userheadimage":"http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle"}]
         */

        private String total;
        private List<DataBean> data;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * comment_content_id : 1695
             * is_hidden : 0
             * comment_obj_id : 259785
             * comment_column_id : 4
             * comment_user_id : 1634546
             * comment_user_ip : 192.168.1.83
             * comment_time : 1480493485
             * comment_region_city : 0
             * comment_content : 😊
             * comment_user_name : 里-2
             * userheadimage : http://bbs.17house.com/uc_server/avatar.php?uid=1634546&size=middle
             */

            private String comment_content_id;
            private String is_hidden;
            private String comment_obj_id;
            private String comment_column_id;
            private String comment_user_id;
            private String comment_user_ip;
            private String comment_time;
            private String comment_region_city;
            private String comment_content;
            private String comment_user_name;
            private String userheadimage;

            public String getComment_content_id() {
                return comment_content_id;
            }

            public void setComment_content_id(String comment_content_id) {
                this.comment_content_id = comment_content_id;
            }

            public String getIs_hidden() {
                return is_hidden;
            }

            public void setIs_hidden(String is_hidden) {
                this.is_hidden = is_hidden;
            }

            public String getComment_obj_id() {
                return comment_obj_id;
            }

            public void setComment_obj_id(String comment_obj_id) {
                this.comment_obj_id = comment_obj_id;
            }

            public String getComment_column_id() {
                return comment_column_id;
            }

            public void setComment_column_id(String comment_column_id) {
                this.comment_column_id = comment_column_id;
            }

            public String getComment_user_id() {
                return comment_user_id;
            }

            public void setComment_user_id(String comment_user_id) {
                this.comment_user_id = comment_user_id;
            }

            public String getComment_user_ip() {
                return comment_user_ip;
            }

            public void setComment_user_ip(String comment_user_ip) {
                this.comment_user_ip = comment_user_ip;
            }

            public String getComment_time() {
                return comment_time;
            }

            public void setComment_time(String comment_time) {
                this.comment_time = comment_time;
            }

            public String getComment_region_city() {
                return comment_region_city;
            }

            public void setComment_region_city(String comment_region_city) {
                this.comment_region_city = comment_region_city;
            }

            public String getComment_content() {
                return comment_content;
            }

            public void setComment_content(String comment_content) {
                this.comment_content = comment_content;
            }

            public String getComment_user_name() {
                return comment_user_name;
            }

            public void setComment_user_name(String comment_user_name) {
                this.comment_user_name = comment_user_name;
            }

            public String getUserheadimage() {
                return userheadimage;
            }

            public void setUserheadimage(String userheadimage) {
                this.userheadimage = userheadimage;
            }
        }
    }
}
