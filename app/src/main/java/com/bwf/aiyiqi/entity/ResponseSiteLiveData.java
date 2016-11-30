package com.bwf.aiyiqi.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/11/29.
 */

public class ResponseSiteLiveData {

    /**
     * code : 0
     * message : success
     */

    private BaseOutputBean baseOutput;
    /**
     * buildingSite : {"buildingId":1551305743512118865,"statusId":0,"progressId":2,"acceptanceProgressId":0,"orderId":1551305743512118865,"createTime":1479440576000,"updateTime":1480410354000,"userId":1548265227095652874,"startDisclosure":2,"startDisclosureTime":1480328700000,"splitAlter":1,"splitAlterTime":1480328700000,"waterElectricity":0,"waterElectricityTime":1479440576000,"cementWood":0,"cementWoodTime":1479440576000,"paint":0,"paintTime":1479440576000,"installation":0,"installationTime":1479440576000,"finish":0,"finishTime":1479440576000,"buildingIdStr":"","acceptanceStatus":0,"bespeakExpired":0,"messageNumber":0,"scheduleStatus":0,"isShow":1}
     * orderHouse : {"orderId":1551305743512118865,"layout":"2室1厅1厨1卫","area":"82.66","doorplate":"6-2303","community":"朝阳区","address":"北苑家园绣菊园","newHouse":0,"deliveryHouse":2,"lng":116.425772,"lat":40.044762}
     * userDetail : {"userId":1548265227095652874,"realName":"霍雨佳","gender":0,"emailVerified":0,"provinceId":0,"cityId":0,"districtId":0,"userPoint":0,"userLevel":0,"hasOrder":0,"updateTime":1476540782000,"userPointIncrement":0,"userPointDate":1476540782000,"mobile":"18501168939","mobileLocation":"北京","userType":0,"bgCardNum":"0"}
     * imageUrl : http://apptest-picture.oss-cn-beijing.aliyuncs.com/yiqizhuagnxiu-gongdizhibo/tu10.png
     * members : [{"vendorId":1538350153601131312,"vendorName":"任燕","realName":"任燕","nickName":"任燕","avatar":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1469089022406991352","provinceId":0,"workYear":0,"updateTime":1467085031000,"bossId":1701},{"vendorId":227,"vendorName":"王锦姣","realName":"王锦姣","nickName":"王锦姣","avatar":"http://jiazhuang-picture.oss-cn-beijing.aliyuncs.com/jiagenjin/dd9e2008-4deb-4e71-9804-b3f45812f18f","lifePhoto":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1469093354321276636","signature":"和蔼可亲","provinceId":0,"workYear":2000,"updateTime":1455848903000,"bossId":1702},{"vendorId":1550071032683968200,"vendorName":"汪飞","realName":"汪飞","nickName":"汪飞","avatar":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1478263299616206522","lifePhoto":"http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/147826332355169429","signature":"本人于2000年来北京从事装修行业至今.最初是从事油工工种.曾在各大公司做过班长.后在工长俱乐部及互联网公司任职工长多年.拥有众多的人力资源.及对工地管理模式，对互联网模式.也是轻车熟路。","provinceId":0,"workYear":2016,"updateTime":1478262932000,"bossId":1703},{"vendorId":352,"vendorName":"房志刚","realName":"房志刚","nickName":"房志刚","provinceId":0,"workYear":2000,"updateTime":1460443881000,"bossId":1705}]
     * progress : [{"progressId":1,"progressName":"开工","progressStatus":2,"createTime":1480328700000},{"progressId":2,"progressName":"拆改","progressStatus":1,"createTime":1480328700000},{"progressId":3,"progressName":"水电","progressStatus":0,"createTime":1479440576000},{"progressId":4,"progressName":"泥木","progressStatus":0,"createTime":1479440576000},{"progressId":5,"progressName":"油漆","progressStatus":0,"createTime":1479440576000},{"progressId":6,"progressName":"安装","progressStatus":0,"createTime":1479440576000},{"progressId":7,"progressName":"竣工","progressStatus":0,"createTime":1479440576000}]
     * latestTrackProgressId : 2
     */

    private DataBean data;

    public BaseOutputBean getBaseOutput() {
        return baseOutput;
    }

    public void setBaseOutput(BaseOutputBean baseOutput) {
        this.baseOutput = baseOutput;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class BaseOutputBean {
        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class DataBean {
        /**
         * buildingId : 1551305743512118865
         * statusId : 0
         * progressId : 2
         * acceptanceProgressId : 0
         * orderId : 1551305743512118865
         * createTime : 1479440576000
         * updateTime : 1480410354000
         * userId : 1548265227095652874
         * startDisclosure : 2
         * startDisclosureTime : 1480328700000
         * splitAlter : 1
         * splitAlterTime : 1480328700000
         * waterElectricity : 0
         * waterElectricityTime : 1479440576000
         * cementWood : 0
         * cementWoodTime : 1479440576000
         * paint : 0
         * paintTime : 1479440576000
         * installation : 0
         * installationTime : 1479440576000
         * finish : 0
         * finishTime : 1479440576000
         * buildingIdStr :
         * acceptanceStatus : 0
         * bespeakExpired : 0
         * messageNumber : 0
         * scheduleStatus : 0
         * isShow : 1
         */

        private BuildingSiteBean buildingSite;
        /**
         * orderId : 1551305743512118865
         * layout : 2室1厅1厨1卫
         * area : 82.66
         * doorplate : 6-2303
         * community : 朝阳区
         * address : 北苑家园绣菊园
         * newHouse : 0
         * deliveryHouse : 2
         * lng : 116.425772
         * lat : 40.044762
         */

        private OrderHouseBean orderHouse;
        /**
         * userId : 1548265227095652874
         * realName : 霍雨佳
         * gender : 0
         * emailVerified : 0
         * provinceId : 0
         * cityId : 0
         * districtId : 0
         * userPoint : 0
         * userLevel : 0
         * hasOrder : 0
         * updateTime : 1476540782000
         * userPointIncrement : 0
         * userPointDate : 1476540782000
         * mobile : 18501168939
         * mobileLocation : 北京
         * userType : 0
         * bgCardNum : 0
         */

        private UserDetailBean userDetail;
        private String imageUrl;
        private int latestTrackProgressId;
        /**
         * vendorId : 1538350153601131312
         * vendorName : 任燕
         * realName : 任燕
         * nickName : 任燕
         * avatar : http://jiazhuangtest-picture.oss-cn-beijing.aliyuncs.com/user/1469089022406991352
         * provinceId : 0
         * workYear : 0
         * updateTime : 1467085031000
         * bossId : 1701
         */

        private List<MembersBean> members;
        /**
         * progressId : 1
         * progressName : 开工
         * progressStatus : 2
         * createTime : 1480328700000
         */

        private List<ProgressBean> progress;

        public BuildingSiteBean getBuildingSite() {
            return buildingSite;
        }

        public void setBuildingSite(BuildingSiteBean buildingSite) {
            this.buildingSite = buildingSite;
        }

        public OrderHouseBean getOrderHouse() {
            return orderHouse;
        }

        public void setOrderHouse(OrderHouseBean orderHouse) {
            this.orderHouse = orderHouse;
        }

        public UserDetailBean getUserDetail() {
            return userDetail;
        }

        public void setUserDetail(UserDetailBean userDetail) {
            this.userDetail = userDetail;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public int getLatestTrackProgressId() {
            return latestTrackProgressId;
        }

        public void setLatestTrackProgressId(int latestTrackProgressId) {
            this.latestTrackProgressId = latestTrackProgressId;
        }

        public List<MembersBean> getMembers() {
            return members;
        }

        public void setMembers(List<MembersBean> members) {
            this.members = members;
        }

        public List<ProgressBean> getProgress() {
            return progress;
        }

        public void setProgress(List<ProgressBean> progress) {
            this.progress = progress;
        }

        public static class BuildingSiteBean {
            private String buildingId;
            private int statusId;
            private int progressId;
            private int acceptanceProgressId;
            private String orderId;
            private String createTime;
            private String updateTime;
            private String userId;
            private int startDisclosure;
            private String startDisclosureTime;
            private int splitAlter;
            private String splitAlterTime;
            private int waterElectricity;
            private String waterElectricityTime;
            private int cementWood;
            private String cementWoodTime;
            private int paint;
            private String paintTime;
            private int installation;
            private String installationTime;
            private int finish;
            private String finishTime;
            private String buildingIdStr;
            private int acceptanceStatus;
            private int bespeakExpired;
            private int messageNumber;
            private int scheduleStatus;
            private int isShow;

            public String getBuildingId() {
                return buildingId;
            }

            public void setBuildingId(String buildingId) {
                this.buildingId = buildingId;
            }

            public int getStatusId() {
                return statusId;
            }

            public void setStatusId(int statusId) {
                this.statusId = statusId;
            }

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public int getAcceptanceProgressId() {
                return acceptanceProgressId;
            }

            public void setAcceptanceProgressId(int acceptanceProgressId) {
                this.acceptanceProgressId = acceptanceProgressId;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public int getStartDisclosure() {
                return startDisclosure;
            }

            public void setStartDisclosure(int startDisclosure) {
                this.startDisclosure = startDisclosure;
            }

            public String getStartDisclosureTime() {
                return startDisclosureTime;
            }

            public void setStartDisclosureTime(String startDisclosureTime) {
                this.startDisclosureTime = startDisclosureTime;
            }

            public int getSplitAlter() {
                return splitAlter;
            }

            public void setSplitAlter(int splitAlter) {
                this.splitAlter = splitAlter;
            }

            public String getSplitAlterTime() {
                return splitAlterTime;
            }

            public void setSplitAlterTime(String splitAlterTime) {
                this.splitAlterTime = splitAlterTime;
            }

            public int getWaterElectricity() {
                return waterElectricity;
            }

            public void setWaterElectricity(int waterElectricity) {
                this.waterElectricity = waterElectricity;
            }

            public String getWaterElectricityTime() {
                return waterElectricityTime;
            }

            public void setWaterElectricityTime(String waterElectricityTime) {
                this.waterElectricityTime = waterElectricityTime;
            }

            public int getCementWood() {
                return cementWood;
            }

            public void setCementWood(int cementWood) {
                this.cementWood = cementWood;
            }

            public String getCementWoodTime() {
                return cementWoodTime;
            }

            public void setCementWoodTime(String cementWoodTime) {
                this.cementWoodTime = cementWoodTime;
            }

            public int getPaint() {
                return paint;
            }

            public void setPaint(int paint) {
                this.paint = paint;
            }

            public String getPaintTime() {
                return paintTime;
            }

            public void setPaintTime(String paintTime) {
                this.paintTime = paintTime;
            }

            public int getInstallation() {
                return installation;
            }

            public void setInstallation(int installation) {
                this.installation = installation;
            }

            public String getInstallationTime() {
                return installationTime;
            }

            public void setInstallationTime(String installationTime) {
                this.installationTime = installationTime;
            }

            public int getFinish() {
                return finish;
            }

            public void setFinish(int finish) {
                this.finish = finish;
            }

            public String getFinishTime() {
                return finishTime;
            }

            public void setFinishTime(String finishTime) {
                this.finishTime = finishTime;
            }

            public String getBuildingIdStr() {
                return buildingIdStr;
            }

            public void setBuildingIdStr(String buildingIdStr) {
                this.buildingIdStr = buildingIdStr;
            }

            public int getAcceptanceStatus() {
                return acceptanceStatus;
            }

            public void setAcceptanceStatus(int acceptanceStatus) {
                this.acceptanceStatus = acceptanceStatus;
            }

            public int getBespeakExpired() {
                return bespeakExpired;
            }

            public void setBespeakExpired(int bespeakExpired) {
                this.bespeakExpired = bespeakExpired;
            }

            public int getMessageNumber() {
                return messageNumber;
            }

            public void setMessageNumber(int messageNumber) {
                this.messageNumber = messageNumber;
            }

            public int getScheduleStatus() {
                return scheduleStatus;
            }

            public void setScheduleStatus(int scheduleStatus) {
                this.scheduleStatus = scheduleStatus;
            }

            public int getIsShow() {
                return isShow;
            }

            public void setIsShow(int isShow) {
                this.isShow = isShow;
            }
        }

        public static class OrderHouseBean {
            private String orderId;
            private String layout;
            private String area;
            private String doorplate;
            private String community;
            private String address;
            private int newHouse;
            private int deliveryHouse;
            private double lng;
            private double lat;

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getLayout() {
                return layout;
            }

            public void setLayout(String layout) {
                this.layout = layout;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }

            public String getDoorplate() {
                return doorplate;
            }

            public void setDoorplate(String doorplate) {
                this.doorplate = doorplate;
            }

            public String getCommunity() {
                return community;
            }

            public void setCommunity(String community) {
                this.community = community;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getNewHouse() {
                return newHouse;
            }

            public void setNewHouse(int newHouse) {
                this.newHouse = newHouse;
            }

            public int getDeliveryHouse() {
                return deliveryHouse;
            }

            public void setDeliveryHouse(int deliveryHouse) {
                this.deliveryHouse = deliveryHouse;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }
        }

        public static class UserDetailBean {
            private String userId;
            private String realName;
            private int gender;
            private int emailVerified;
            private int provinceId;
            private int cityId;
            private int districtId;
            private int userPoint;
            private int userLevel;
            private int hasOrder;
            private String updateTime;
            private int userPointIncrement;
            private String userPointDate;
            private String mobile;
            private String mobileLocation;
            private int userType;
            private String bgCardNum;

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public int getEmailVerified() {
                return emailVerified;
            }

            public void setEmailVerified(int emailVerified) {
                this.emailVerified = emailVerified;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public int getDistrictId() {
                return districtId;
            }

            public void setDistrictId(int districtId) {
                this.districtId = districtId;
            }

            public int getUserPoint() {
                return userPoint;
            }

            public void setUserPoint(int userPoint) {
                this.userPoint = userPoint;
            }

            public int getUserLevel() {
                return userLevel;
            }

            public void setUserLevel(int userLevel) {
                this.userLevel = userLevel;
            }

            public int getHasOrder() {
                return hasOrder;
            }

            public void setHasOrder(int hasOrder) {
                this.hasOrder = hasOrder;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getUserPointIncrement() {
                return userPointIncrement;
            }

            public void setUserPointIncrement(int userPointIncrement) {
                this.userPointIncrement = userPointIncrement;
            }

            public String getUserPointDate() {
                return userPointDate;
            }

            public void setUserPointDate(String userPointDate) {
                this.userPointDate = userPointDate;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getMobileLocation() {
                return mobileLocation;
            }

            public void setMobileLocation(String mobileLocation) {
                this.mobileLocation = mobileLocation;
            }

            public int getUserType() {
                return userType;
            }

            public void setUserType(int userType) {
                this.userType = userType;
            }

            public String getBgCardNum() {
                return bgCardNum;
            }

            public void setBgCardNum(String bgCardNum) {
                this.bgCardNum = bgCardNum;
            }
        }

        public static class MembersBean {
            private String vendorId;
            private String vendorName;
            private String realName;
            private String nickName;
            private String avatar;
            private int provinceId;
            private int workYear;
            private String updateTime;
            private int bossId;

            public String getVendorId() {
                return vendorId;
            }

            public void setVendorId(String vendorId) {
                this.vendorId = vendorId;
            }

            public String getVendorName() {
                return vendorName;
            }

            public void setVendorName(String vendorName) {
                this.vendorName = vendorName;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public int getWorkYear() {
                return workYear;
            }

            public void setWorkYear(int workYear) {
                this.workYear = workYear;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getBossId() {
                return bossId;
            }

            public void setBossId(int bossId) {
                this.bossId = bossId;
            }
        }

        public static class ProgressBean {
            private int progressId;
            private String progressName;
            private int progressStatus;
            private String createTime;

            public int getProgressId() {
                return progressId;
            }

            public void setProgressId(int progressId) {
                this.progressId = progressId;
            }

            public String getProgressName() {
                return progressName;
            }

            public void setProgressName(String progressName) {
                this.progressName = progressName;
            }

            public int getProgressStatus() {
                return progressStatus;
            }

            public void setProgressStatus(int progressStatus) {
                this.progressStatus = progressStatus;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
