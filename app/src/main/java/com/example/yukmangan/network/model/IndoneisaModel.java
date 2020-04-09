package com.example.yukmangan.network.model;

import com.google.gson.annotations.SerializedName;

public class IndoneisaModel {

    @SerializedName("lastUpdate")
    private String latUpdate;
    @SerializedName("confirmed")
    private IdnConfirmed idnConfirmed;
    @SerializedName("recovered")
    private IdnRecovered idnRecovered;
    @SerializedName("deaths")
    private IdnDeaths idnDeaths;

    public String getLatUpdate() {
        return latUpdate;
    }

    public void setLatUpdate(String latUpdate) {
        this.latUpdate = latUpdate;
    }

    public IdnConfirmed getIdnConfirmed() {
        return idnConfirmed;
    }

    public void setIdnConfirmed(IdnConfirmed idnConfirmed) {
        this.idnConfirmed = idnConfirmed;
    }

    public IdnRecovered getIdnRecovered() {
        return idnRecovered;
    }

    public void setIdnRecovered(IdnRecovered idnRecovered) {
        this.idnRecovered = idnRecovered;
    }

    public IdnDeaths getIdnDeaths() {
        return idnDeaths;
    }

    public void setIdnDeaths(IdnDeaths idnDeaths) {
        this.idnDeaths = idnDeaths;
    }

    public IndoneisaModel() {
        this.latUpdate = latUpdate;
        this.idnConfirmed = idnConfirmed;
        this.idnRecovered = idnRecovered;
        this.idnDeaths = idnDeaths;
    }

    public class IdnRecovered {
        @SerializedName("value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @SerializedName("detail")
        private String detail;

        public IdnRecovered(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }
    }

    public class IdnConfirmed {
        public IdnConfirmed(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        @SerializedName("value")
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        @SerializedName("detail")
        private String detail;
    }

    public class IdnDeaths {
        @SerializedName("value")
        private String value;
        @SerializedName("detail")
        private String detail;

        public IdnDeaths(String value, String detail) {
            this.value = value;
            this.detail = detail;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }
    }

}
