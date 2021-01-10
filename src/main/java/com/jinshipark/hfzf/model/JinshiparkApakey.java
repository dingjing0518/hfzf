package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class JinshiparkApakey implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "车场名称（汇付商户名称）")
    private String parkname;

    @ApiModelProperty(value = "车场编号")
    private String parkid;

    private String appid;

    @ApiModelProperty(value = "RSA私钥")
    private String rsaprivatekey;

    private String apikeylive;

    private String apikeytest;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParkname() {
        return parkname;
    }

    public void setParkname(String parkname) {
        this.parkname = parkname;
    }

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getRsaprivatekey() {
        return rsaprivatekey;
    }

    public void setRsaprivatekey(String rsaprivatekey) {
        this.rsaprivatekey = rsaprivatekey;
    }

    public String getApikeylive() {
        return apikeylive;
    }

    public void setApikeylive(String apikeylive) {
        this.apikeylive = apikeylive;
    }

    public String getApikeytest() {
        return apikeytest;
    }

    public void setApikeytest(String apikeytest) {
        this.apikeytest = apikeytest;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parkname=").append(parkname);
        sb.append(", parkid=").append(parkid);
        sb.append(", appid=").append(appid);
        sb.append(", rsaprivatekey=").append(rsaprivatekey);
        sb.append(", apikeylive=").append(apikeylive);
        sb.append(", apikeytest=").append(apikeytest);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}