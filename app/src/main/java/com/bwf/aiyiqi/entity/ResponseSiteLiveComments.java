package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/27.
 */

public class ResponseSiteLiveComments {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * pageNo : 0
     * pageSize : 3
     * pageTotalNum : 2
     */

    private PageInfoBean pageInfo;
    /**
     * trackId : 1551867824855588967
     * message : 拆除
     * buildingId : 1551333240465279594
     * progressId : 1
     * acceptancePassed : 0
     * acceptanceId : 0
     * createTime : 1479976487000
     * dateStringerval : 7
     * vendorId : 1550604680929748905
     * atList : []
     * userId : 1551333240342596201
     * imgSrc : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764562595768430,http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764563212547111,http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764563813122462,http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764564366260873,http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/1479976456491196894
     * sponsorType : 1
     * address :
     * creatorName : 杨军林
     * creatorRole : 工长
     * avatar : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1478936895874345005
     * replyList : []
     * weiXinShare : {"title":"来自北蜂窝小区的装修工地直播","content":"此工地进入开工阶段，大量现场图片等您来看，目前全国已开通3256个工地","news":"来自北蜂窝小区的装修工地直播","imageUrl":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764562595768430","linkUrl":"http://wap.17house.com/zhuangxiu/gongdizhibo/1551333240465279594.html"}
     */

    private List<DataBean> data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private String code;
        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class PageInfoBean {
        private int pageNo;
        private int pageSize;
        private int pageTotalNum;

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPageTotalNum() {
            return pageTotalNum;
        }

        public void setPageTotalNum(int pageTotalNum) {
            this.pageTotalNum = pageTotalNum;
        }
    }

    public static class DataBean {
        private long trackId;
        private String message;
        private String buildingId;
        private String progressId;
        private String acceptancePassed;
        private long acceptanceId;
        private long createTime;
        private String dateStringerval;
        private long vendorId;
        private String atList;
        private long userId;
        private String imgSrc;
        private String sponsorType;
        private String address;
        private String creatorName;
        private String creatorRole;
        private String avatar;
        /**
         * title : 来自北蜂窝小区的装修工地直播
         * content : 此工地进入开工阶段，大量现场图片等您来看，目前全国已开通3256个工地
         * news : 来自北蜂窝小区的装修工地直播
         * imageUrl : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/followup/14799764562595768430
         * linkUrl : http://wap.17house.com/zhuangxiu/gongdizhibo/1551333240465279594.html
         */

        private WeiXinShareBean weiXinShare;
        private List<Reply> replyList;
        public class Reply {

            /**
             * replyId : 1551867303076839400
             * trackId : 1551508489817302000
             * buildingId : 0
             * message : 收到
             * createTime : 1479975989000
             * vendorId : 229
             * userId : 1551333240342596000
             * sponsorType : 1
             * name : 李建山
             * roleName : 监理
             */

            private long replyId;
            private long trackId;
            private String buildingId;
            private String message;
            private long createTime;
            private String vendorId;
            private long userId;
            private String sponsorType;
            private String name;
            private String roleName;

            public long getReplyId() {
                return replyId;
            }

            public void setReplyId(long replyId) {
                this.replyId = replyId;
            }

            public long getTrackId() {
                return trackId;
            }

            public void setTrackId(long trackId) {
                this.trackId = trackId;
            }

            public String getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(String buildingId) {
                this.buildingId = buildingId;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getVendorId() {
                return vendorId;
            }

            public void setVendorId(String vendorId) {
                this.vendorId = vendorId;
            }

            public long getUserId() {
                return userId;
            }

            public void setUserId(long userId) {
                this.userId = userId;
            }

            public String getSponsorType() {
                return sponsorType;
            }

            public void setSponsorType(String sponsorType) {
                this.sponsorType = sponsorType;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }
        }
        public long getTrackId() {
            return trackId;
        }

        public void setTrackId(long trackId) {
            this.trackId = trackId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getBuildingId() {
            return buildingId;
        }

        public void setBuildingId(String buildingId) {
            this.buildingId = buildingId;
        }

        public String getProgressId() {
            return progressId;
        }

        public void setProgressId(String progressId) {
            this.progressId = progressId;
        }

        public String getAcceptancePassed() {
            return acceptancePassed;
        }

        public void setAcceptancePassed(String acceptancePassed) {
            this.acceptancePassed = acceptancePassed;
        }

        public long getAcceptanceId() {
            return acceptanceId;
        }

        public void setAcceptanceId(long acceptanceId) {
            this.acceptanceId = acceptanceId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getDateStringerval() {
            return dateStringerval;
        }

        public void setDateStringerval(String dateStringerval) {
            this.dateStringerval = dateStringerval;
        }

        public long getVendorId() {
            return vendorId;
        }

        public void setVendorId(long vendorId) {
            this.vendorId = vendorId;
        }

        public String getAtList() {
            return atList;
        }

        public void setAtList(String atList) {
            this.atList = atList;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public String getImgSrc() {
            return imgSrc;
        }

        public void setImgSrc(String imgSrc) {
            this.imgSrc = imgSrc;
        }

        public String getSponsorType() {
            return sponsorType;
        }

        public void setSponsorType(String sponsorType) {
            this.sponsorType = sponsorType;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        public String getCreatorRole() {
            return creatorRole;
        }

        public void setCreatorRole(String creatorRole) {
            this.creatorRole = creatorRole;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public WeiXinShareBean getWeiXinShare() {
            return weiXinShare;
        }

        public void setWeiXinShare(WeiXinShareBean weiXinShare) {
            this.weiXinShare = weiXinShare;
        }

        public List<Reply> getReplyList() {
            return replyList;
        }

        public void setReplyList(List<Reply> replyList) {
            this.replyList = replyList;
        }

        public static class WeiXinShareBean {
            private String title;
            private String content;
            private String news;
            private String imageUrl;
            private String linkUrl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getNews() {
                return news;
            }

            public void setNews(String news) {
                this.news = news;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }
        }
    }

    public List<DataAt> dataAts;

    public List<DataAt> getDataAts() {
        return dataAts;
    }
    public void setDataAts(List<DataAt> dataAts) {
        this.dataAts = dataAts;
    }
    public static class DataAt{
        private String id;
        private String name;

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
