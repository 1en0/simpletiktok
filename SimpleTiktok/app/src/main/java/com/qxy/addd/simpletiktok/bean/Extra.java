package com.qxy.addd.simpletiktok.bean;

class Extra {
    private String logid;
    private Integer error_code;
    private String description;
    private Integer sub_error_code;
    private String sub_description;
    private Long now;

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSub_error_code() {
        return sub_error_code;
    }

    public void setSub_error_code(Integer sub_error_code) {
        this.sub_error_code = sub_error_code;
    }

    public String getSub_description() {
        return sub_description;
    }

    public void setSub_description(String sub_description) {
        this.sub_description = sub_description;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }
}
