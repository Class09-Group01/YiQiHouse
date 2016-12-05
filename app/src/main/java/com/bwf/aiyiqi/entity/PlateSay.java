package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/30.
 * 功能描述：
 * 作者：
 */

public class PlateSay {

    /**
     * data : [[{"id":"4303","title":"成都装修论坛","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png","threadsnum":"2691","postsnum":"10500"},{"id":"4304","title":"成都投诉表扬","icon":"http://bbs.17house.com/data/attachment/common/7e/common_4304_icon.png","threadsnum":"36","postsnum":"147"},{"id":"4608","title":"成都业主装修日记","icon":"http://bbs.17house.com/data/attachment/common/3c/common_4608_icon.png","threadsnum":"69","postsnum":"156"},{"id":"4306","title":"成都商家交流","icon":"http://bbs.17house.com/data/attachment/common/b0/common_4306_icon.png","threadsnum":"489","postsnum":"990"}],[{"id":"22268","title":"一起美装","icon":"http://static-news.17house.com/web/bbs/201605/06/1754441718.jpg","threadsnum":"94","postsnum":191},{"id":"10027","title":"木门","icon":"http://static-news.17house.com/web/bbs/201604/20/1358187528.jpg","threadsnum":"348","postsnum":722},{"id":"10475","title":"橱柜","icon":"http://static-news.17house.com/web/bbs/201604/20/1358332470.jpg","threadsnum":"891","postsnum":1790},{"id":"5996","title":"地板","icon":"http://static-news.17house.com/web/bbs/201604/20/1357349797.jpg","threadsnum":"1172","postsnum":2369},{"id":"12087","title":"瓷砖","icon":"http://static-news.17house.com/web/bbs/201604/20/1400025645.jpg","threadsnum":"375","postsnum":753},{"id":"6172","title":"壁纸","icon":"http://static-news.17house.com/web/bbs/201604/20/1357517352.jpg","threadsnum":"461","postsnum":950}]]
     * error : 0
     * message : 成功
     */

    private String error;
    private String message;
    /**
     * id : 4303
     * title : 成都装修论坛
     * icon : http://bbs.17house.com/data/attachment/common/b0/common_4303_icon.png
     * threadsnum : 2691
     * postsnum : 10500
     */

    private List<List<DataBean>> data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String title;
        private String icon;
        private String threadsnum;
        private String postsnum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getThreadsnum() {
            return threadsnum;
        }

        public void setThreadsnum(String threadsnum) {
            this.threadsnum = threadsnum;
        }

        public String getPostsnum() {
            return postsnum;
        }

        public void setPostsnum(String postsnum) {
            this.postsnum = postsnum;
        }
    }
}
