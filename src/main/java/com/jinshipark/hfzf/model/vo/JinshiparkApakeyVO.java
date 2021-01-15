package com.jinshipark.hfzf.model.vo;

import io.swagger.annotations.ApiModelProperty;

public class JinshiparkApakeyVO {
    private Integer id;

    @ApiModelProperty(value = "车场名称（汇付商户名称）")
    private String parkName;

    @ApiModelProperty(value = "车场编号")
    private String parkId;

    private String appId;

    @ApiModelProperty(value = "RSA私钥")
    private String rsaPrivateKey;

    private String apiKeyLive;

    private String apiKeyTest;

    @ApiModelProperty(value = "备注")
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getRsaPrivateKey() {
        return rsaPrivateKey;
    }

    public void setRsaPrivateKey(String rsaPrivateKey) {
        this.rsaPrivateKey = rsaPrivateKey;
    }

    public String getApiKeyLive() {
        return apiKeyLive;
    }

    public void setApiKeyLive(String apiKeyLive) {
        this.apiKeyLive = apiKeyLive;
    }

    public String getApiKeyTest() {
        return apiKeyTest;
    }

    public void setApiKeyTest(String apiKeyTest) {
        this.apiKeyTest = apiKeyTest;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
