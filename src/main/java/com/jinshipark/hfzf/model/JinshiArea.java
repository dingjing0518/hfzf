package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class JinshiArea implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "代理商id")
    private Integer agentId;

    @ApiModelProperty(value = "车场id")
    private Integer parkId;

    @ApiModelProperty(value = "区域编号")
    private String areaNumber;

    @ApiModelProperty(value = "车位数")
    private Integer parkingCount;

    @ApiModelProperty(value = "临时车位数")
    private Integer temporaryParkingCount;

    @ApiModelProperty(value = "包月费用")
    private Integer payMonth;

    @ApiModelProperty(value = "包季费用")
    private Integer payQuarter;

    @ApiModelProperty(value = "包年费用")
    private Integer payYear;

    @ApiModelProperty(value = "允许负车位数")
    private Integer allowNegativeCar;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public String getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(String areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Integer getParkingCount() {
        return parkingCount;
    }

    public void setParkingCount(Integer parkingCount) {
        this.parkingCount = parkingCount;
    }

    public Integer getTemporaryParkingCount() {
        return temporaryParkingCount;
    }

    public void setTemporaryParkingCount(Integer temporaryParkingCount) {
        this.temporaryParkingCount = temporaryParkingCount;
    }

    public Integer getPayMonth() {
        return payMonth;
    }

    public void setPayMonth(Integer payMonth) {
        this.payMonth = payMonth;
    }

    public Integer getPayQuarter() {
        return payQuarter;
    }

    public void setPayQuarter(Integer payQuarter) {
        this.payQuarter = payQuarter;
    }

    public Integer getPayYear() {
        return payYear;
    }

    public void setPayYear(Integer payYear) {
        this.payYear = payYear;
    }

    public Integer getAllowNegativeCar() {
        return allowNegativeCar;
    }

    public void setAllowNegativeCar(Integer allowNegativeCar) {
        this.allowNegativeCar = allowNegativeCar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", areaName=").append(areaName);
        sb.append(", agentId=").append(agentId);
        sb.append(", parkId=").append(parkId);
        sb.append(", areaNumber=").append(areaNumber);
        sb.append(", parkingCount=").append(parkingCount);
        sb.append(", temporaryParkingCount=").append(temporaryParkingCount);
        sb.append(", payMonth=").append(payMonth);
        sb.append(", payQuarter=").append(payQuarter);
        sb.append(", payYear=").append(payYear);
        sb.append(", allowNegativeCar=").append(allowNegativeCar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}