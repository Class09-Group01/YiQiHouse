package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class ResponsePostZan {

    /**
     * data : [{"uid":"1516666","dateline":"1480222653","username":"老房有喜","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1516666&size=big"}]
     * currentPage : 1
     * totalCount : 1
     * error : 0
     * message : 成功
     */

    private int currentPage;
    private int totalCount;
    private String error;
    private String message;
    private List<DataBean> data;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 1516666
         * dateline : 1480222653
         * username : 老房有喜
         * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1516666&size=big
         */

        private String uid;
        private String dateline;
        private String username;
        private String avtUrl;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }
    }
}
