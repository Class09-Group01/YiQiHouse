package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by lingchen52 on 2016/11/30.
 */

public class ResponsePostCommunite {

    /**
     * data : [{"tid":"1218226","pid":"2688403","author":"奇葩朵朵","authorid":"1299744","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1299744&size=big","userSpaceUrl":"","dateline":"2天前","replyUrl":"","nofollowUrl":"","block":null,"message":[{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48}],"floor":"3","title":"","urls":"http://bbs.17house.com/forum.php?mod=viewthread&tid=1218226&extra=page=1","locationFloor":0,"atlist":[],"address":"","fid":"2","fname":"北京装修论坛","fstatus":"1","attachments":[],"houseInfo":[],"tags":[],"h5Url":"http://bbs.17house.com/thread-1218226-1-1.html","isfollow":0},{"tid":"1218226","pid":"2688267","author":"老房有喜","authorid":"1516666","avtUrl":"http://bbs.17house.com/uc_server/avatar.php?uid=1516666&size=big","userSpaceUrl":"","dateline":"3天前","replyUrl":"","nofollowUrl":"","block":null,"message":[{"msgType":0,"msg":"好工长在一起！","imgType":0,"layout":[]},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48}],"floor":"2","title":"","urls":"http://bbs.17house.com/forum.php?mod=viewthread&tid=1218226&extra=page=1","locationFloor":0,"atlist":[],"address":"","fid":"2","fname":"北京装修论坛","fstatus":"1","attachments":[],"houseInfo":{"stage":1,"community":"","layout":2,"area":92,"budget":11,"style":5},"tags":[],"h5Url":"http://bbs.17house.com/thread-1218226-1-1.html","isfollow":0}]
     * currentPage : 1
     * totalCount : 2
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
         * tid : 1218226
         * pid : 2688403
         * author : 奇葩朵朵
         * authorid : 1299744
         * avtUrl : http://bbs.17house.com/uc_server/avatar.php?uid=1299744&size=big
         * userSpaceUrl :
         * dateline : 2天前
         * replyUrl :
         * nofollowUrl :
         * block : null
         * message : [{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48},{"msgType":1,"msg":"http://bbs.17house.com/static/image/smiley/ww/4qiang.gif","imgType":3,"layout":[],"width":59,"height":48}]
         * floor : 3
         * title :
         * urls : http://bbs.17house.com/forum.php?mod=viewthread&tid=1218226&extra=page=1
         * locationFloor : 0
         * atlist : []
         * address :
         * fid : 2
         * fname : 北京装修论坛
         * fstatus : 1
         * attachments : []
         * houseInfo : []
         * tags : []
         * h5Url : http://bbs.17house.com/thread-1218226-1-1.html
         * isfollow : 0
         */

        private String tid;
        private String pid;
        private String author;
        private String authorid;
        private String avtUrl;
        private String userSpaceUrl;
        private String dateline;
        private String replyUrl;
        private String nofollowUrl;
        private Object block;
        private String floor;
        private String title;
        private String urls;
        private int locationFloor;
        private String address;
        private String fid;
        private String fname;
        private String fstatus;
        private String h5Url;
        private int isfollow;
        private List<MessageBean> message;
        private List<?> atlist;
        private List<?> attachments;
        private List<?> houseInfo;
        private List<?> tags;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getAvtUrl() {
            return avtUrl;
        }

        public void setAvtUrl(String avtUrl) {
            this.avtUrl = avtUrl;
        }

        public String getUserSpaceUrl() {
            return userSpaceUrl;
        }

        public void setUserSpaceUrl(String userSpaceUrl) {
            this.userSpaceUrl = userSpaceUrl;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getReplyUrl() {
            return replyUrl;
        }

        public void setReplyUrl(String replyUrl) {
            this.replyUrl = replyUrl;
        }

        public String getNofollowUrl() {
            return nofollowUrl;
        }

        public void setNofollowUrl(String nofollowUrl) {
            this.nofollowUrl = nofollowUrl;
        }

        public Object getBlock() {
            return block;
        }

        public void setBlock(Object block) {
            this.block = block;
        }

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrls() {
            return urls;
        }

        public void setUrls(String urls) {
            this.urls = urls;
        }

        public int getLocationFloor() {
            return locationFloor;
        }

        public void setLocationFloor(int locationFloor) {
            this.locationFloor = locationFloor;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public int getIsfollow() {
            return isfollow;
        }

        public void setIsfollow(int isfollow) {
            this.isfollow = isfollow;
        }

        public List<MessageBean> getMessage() {
            return message;
        }

        public void setMessage(List<MessageBean> message) {
            this.message = message;
        }

        public List<?> getAtlist() {
            return atlist;
        }

        public void setAtlist(List<?> atlist) {
            this.atlist = atlist;
        }

        public List<?> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<?> attachments) {
            this.attachments = attachments;
        }

        public List<?> getHouseInfo() {
            return houseInfo;
        }

        public void setHouseInfo(List<?> houseInfo) {
            this.houseInfo = houseInfo;
        }

        public List<?> getTags() {
            return tags;
        }

        public void setTags(List<?> tags) {
            this.tags = tags;
        }

        public static class MessageBean {
            /**
             * msgType : 1
             * msg : http://bbs.17house.com/static/image/smiley/ww/4qiang.gif
             * imgType : 3
             * layout : []
             * width : 59
             * height : 48
             */

            private int msgType;
            private String msg;
            private int imgType;
            private int width;
            private int height;
            private List<?> layout;

            public int getMsgType() {
                return msgType;
            }

            public void setMsgType(int msgType) {
                this.msgType = msgType;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public int getImgType() {
                return imgType;
            }

            public void setImgType(int imgType) {
                this.imgType = imgType;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public List<?> getLayout() {
                return layout;
            }

            public void setLayout(List<?> layout) {
                this.layout = layout;
            }
        }
    }
}
