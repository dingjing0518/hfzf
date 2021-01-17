package com.jinshipark.hfzf.model.vo;

import io.swagger.annotations.ApiModelProperty;

public class JinshiparkAdvertImageVO {

    private String parkId;

    private String type;

    @ApiModelProperty(value = "广告图片摆放位置")
    private String address;

    @ApiModelProperty(value = "图片路径")
    private String imagepath;

    @ApiModelProperty(value = "点击图片链接到的网址")
    private String weblink;

    @ApiModelProperty(value = "地区编号")
    private String area;

    @ApiModelProperty(value = "备注")
    private String remarks;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }
}
