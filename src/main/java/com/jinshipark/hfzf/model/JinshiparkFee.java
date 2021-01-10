package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class JinshiparkFee implements Serializable {
    private Integer jpsId;

    private String jpsParkId;

    private String jpsAgentId;

    @ApiModelProperty(value = "免费时间(分钟）")
    private Integer jpsFreeTime;

    @ApiModelProperty(value = "首段时间(分钟)")
    private Integer jpsFirstTime;

    @ApiModelProperty(value = "首段收费(元）")
    private Integer jpsFirstCharge;

    @ApiModelProperty(value = "后续时间(分钟）")
    private Integer jpsFollowTime;

    @ApiModelProperty(value = "后续收费(元)")
    private Integer jpsFollowCharge;

    @ApiModelProperty(value = "24小时收费上限(元)")
    private Integer jpsAlldayLimit;

    @ApiModelProperty(value = "预付款后出场时间(分钟)")
    private Integer jpsAdvanceChargeOuttime;

    @ApiModelProperty(value = "创建时间")
    private Date jpsCreatetime;

    @ApiModelProperty(value = "是否删除")
    private Integer jpsIsdelete;

    @ApiModelProperty(value = "牌照类型(0:小型车  1:中型车(黄牌)   2:新能源车   3:特种车   4:大型车(黄牌))")
    private Integer jpsCarType;

    @ApiModelProperty(value = "名称")
    private String jpsRemark;

    private static final long serialVersionUID = 1L;

    public Integer getJpsId() {
        return jpsId;
    }

    public void setJpsId(Integer jpsId) {
        this.jpsId = jpsId;
    }

    public String getJpsParkId() {
        return jpsParkId;
    }

    public void setJpsParkId(String jpsParkId) {
        this.jpsParkId = jpsParkId;
    }

    public String getJpsAgentId() {
        return jpsAgentId;
    }

    public void setJpsAgentId(String jpsAgentId) {
        this.jpsAgentId = jpsAgentId;
    }

    public Integer getJpsFreeTime() {
        return jpsFreeTime;
    }

    public void setJpsFreeTime(Integer jpsFreeTime) {
        this.jpsFreeTime = jpsFreeTime;
    }

    public Integer getJpsFirstTime() {
        return jpsFirstTime;
    }

    public void setJpsFirstTime(Integer jpsFirstTime) {
        this.jpsFirstTime = jpsFirstTime;
    }

    public Integer getJpsFirstCharge() {
        return jpsFirstCharge;
    }

    public void setJpsFirstCharge(Integer jpsFirstCharge) {
        this.jpsFirstCharge = jpsFirstCharge;
    }

    public Integer getJpsFollowTime() {
        return jpsFollowTime;
    }

    public void setJpsFollowTime(Integer jpsFollowTime) {
        this.jpsFollowTime = jpsFollowTime;
    }

    public Integer getJpsFollowCharge() {
        return jpsFollowCharge;
    }

    public void setJpsFollowCharge(Integer jpsFollowCharge) {
        this.jpsFollowCharge = jpsFollowCharge;
    }

    public Integer getJpsAlldayLimit() {
        return jpsAlldayLimit;
    }

    public void setJpsAlldayLimit(Integer jpsAlldayLimit) {
        this.jpsAlldayLimit = jpsAlldayLimit;
    }

    public Integer getJpsAdvanceChargeOuttime() {
        return jpsAdvanceChargeOuttime;
    }

    public void setJpsAdvanceChargeOuttime(Integer jpsAdvanceChargeOuttime) {
        this.jpsAdvanceChargeOuttime = jpsAdvanceChargeOuttime;
    }

    public Date getJpsCreatetime() {
        return jpsCreatetime;
    }

    public void setJpsCreatetime(Date jpsCreatetime) {
        this.jpsCreatetime = jpsCreatetime;
    }

    public Integer getJpsIsdelete() {
        return jpsIsdelete;
    }

    public void setJpsIsdelete(Integer jpsIsdelete) {
        this.jpsIsdelete = jpsIsdelete;
    }

    public Integer getJpsCarType() {
        return jpsCarType;
    }

    public void setJpsCarType(Integer jpsCarType) {
        this.jpsCarType = jpsCarType;
    }

    public String getJpsRemark() {
        return jpsRemark;
    }

    public void setJpsRemark(String jpsRemark) {
        this.jpsRemark = jpsRemark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", jpsId=").append(jpsId);
        sb.append(", jpsParkId=").append(jpsParkId);
        sb.append(", jpsAgentId=").append(jpsAgentId);
        sb.append(", jpsFreeTime=").append(jpsFreeTime);
        sb.append(", jpsFirstTime=").append(jpsFirstTime);
        sb.append(", jpsFirstCharge=").append(jpsFirstCharge);
        sb.append(", jpsFollowTime=").append(jpsFollowTime);
        sb.append(", jpsFollowCharge=").append(jpsFollowCharge);
        sb.append(", jpsAlldayLimit=").append(jpsAlldayLimit);
        sb.append(", jpsAdvanceChargeOuttime=").append(jpsAdvanceChargeOuttime);
        sb.append(", jpsCreatetime=").append(jpsCreatetime);
        sb.append(", jpsIsdelete=").append(jpsIsdelete);
        sb.append(", jpsCarType=").append(jpsCarType);
        sb.append(", jpsRemark=").append(jpsRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}