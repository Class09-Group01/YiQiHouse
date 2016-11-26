package com.bwf.aiyiqi.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2016/11/24.
 * 功能描述：
 * 作者：
 */

public class ResponseDecorateSchoolTag {


    /**
     * error : 0
     * message : ok
     * data : {"305":"暖气","517":"验房","899":"收房","8039":"交房","8153":"验房工具","8154":"墙顶验收","8159":"地面验收","61":"门窗","8161":"上水","8163":"下水","8164":"强电","8165":"弱电","8166":"燃气","8667":"防水"}
     */

    private int error;
    private String message;
    /**
     * 305 : 暖气
     * 517 : 验房
     * 899 : 收房
     * 8039 : 交房
     * 8153 : 验房工具
     * 8154 : 墙顶验收
     * 8159 : 地面验收
     * 61 : 门窗
     * 8161 : 上水
     * 8163 : 下水
     * 8164 : 强电
     * 8165 : 弱电
     * 8166 : 燃气
     * 8667 : 防水
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        @JSONField(name="305")
        private String value305;
        @JSONField(name="517")
        private String value517;
        @JSONField(name="899")
        private String value899;
        @JSONField(name="8039")
        private String value8039;
        @JSONField(name="8153")
        private String value8153;
        @JSONField(name="8154")
        private String value8154;
        @JSONField(name="8159")
        private String value8159;
        @JSONField(name="61")
        private String value61;
        @JSONField(name="8161")
        private String value8161;
        @JSONField(name="8163")
        private String value8163;
        @JSONField(name="8164")
        private String value8164;
        @JSONField(name="8165")
        private String value8165;
        @JSONField(name="8166")
        private String value8166;
        @JSONField(name="8667")
        private String value8667;

        public String getValue305() {
            return value305;
        }

        public void setValue305(String value305) {
            this.value305 = value305;
        }

        public String getValue517() {
            return value517;
        }

        public void setValue517(String value517) {
            this.value517 = value517;
        }

        public String getValue899() {
            return value899;
        }

        public void setValue899(String value899) {
            this.value899 = value899;
        }

        public String getValue8039() {
            return value8039;
        }

        public void setValue8039(String value8039) {
            this.value8039 = value8039;
        }

        public String getValue8153() {
            return value8153;
        }

        public void setValue8153(String value8153) {
            this.value8153 = value8153;
        }

        public String getValue8154() {
            return value8154;
        }

        public void setValue8154(String value8154) {
            this.value8154 = value8154;
        }

        public String getValue8159() {
            return value8159;
        }

        public void setValue8159(String value8159) {
            this.value8159 = value8159;
        }

        public String getValue61() {
            return value61;
        }

        public void setValue61(String value61) {
            this.value61 = value61;
        }

        public String getValue8161() {
            return value8161;
        }

        public void setValue8161(String value8161) {
            this.value8161 = value8161;
        }

        public String getValue8163() {
            return value8163;
        }

        public void setValue8163(String value8163) {
            this.value8163 = value8163;
        }

        public String getValue8164() {
            return value8164;
        }

        public void setValue8164(String value8164) {
            this.value8164 = value8164;
        }

        public String getValue8165() {
            return value8165;
        }

        public void setValue8165(String value8165) {
            this.value8165 = value8165;
        }

        public String getValue8166() {
            return value8166;
        }

        public void setValue8166(String value8166) {
            this.value8166 = value8166;
        }

        public String getValue8667() {
            return value8667;
        }

        public void setValue8667(String value8667) {
            this.value8667 = value8667;
        }

        @Override
        public String toString() {
            return
                    "305=" + value305 + '\'' +
                    "517=" + value517 + '\'' +
                    "899=" + value899 + '\'' +
                    "8039=" + value8039 + '\'' +
                    "8153=" + value8153 + '\'' +
                    "8154=" + value8154 + '\'' +
                    "8159=" + value8159 + '\'' +
                    "61=" + value61 + '\'' +
                    "8161=" + value8161 + '\'' +
                    "8163=" + value8163 + '\'' +
                    "8164=" + value8164 + '\'' +
                    "8165=" + value8165 + '\'' +
                    "8166=" + value8166 + '\'' +
                    "8667=" + value8667 + '\'';
        }
    }
}
