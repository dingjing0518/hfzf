package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "会员名")
    private String memberId;

    @ApiModelProperty(value = "服务类型：0：月卡，1：季卡，2：年卡")
    private String serviceType;

    @ApiModelProperty(value = "加入时间")
    private Date joinTime;

    @ApiModelProperty(value = "状态：0：过期，1：未过期")
    private String state;

    @ApiModelProperty(value = "车牌号")
    private String lincensePlateId;

    @ApiModelProperty(value = "过期时间")
    private Date expirationTime;

    @ApiModelProperty(value = "会员手机号")
    private String phonenumber;

    @ApiModelProperty(value = "公司名")
    private String companyname;

    @ApiModelProperty(value = "部门名")
    private String departmentname;

    @ApiModelProperty(value = "会员地址")
    private String memberaddress;

    @ApiModelProperty(value = "公司地址")
    private String companyaddress;

    @ApiModelProperty(value = "汽车型号")
    private String carname;

    @ApiModelProperty(value = "储值金额")
    private String storedMoney;

    @ApiModelProperty(value = "汽车颜色")
    private String carcolor;

    @ApiModelProperty(value = "汽车类型")
    private String cartype;

    @ApiModelProperty(value = "区域名称")
    private String areaName;

    @ApiModelProperty(value = "车场id")
    private Integer parkId;

    @ApiModelProperty(value = "代理商id")
    private Integer agentId;

    @ApiModelProperty(value = "录入账号")
    private String enterUser;

    @ApiModelProperty(value = "车牌组id")
    private Integer lgId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLincensePlateId() {
        return lincensePlateId;
    }

    public void setLincensePlateId(String lincensePlateId) {
        this.lincensePlateId = lincensePlateId;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getMemberaddress() {
        return memberaddress;
    }

    public void setMemberaddress(String memberaddress) {
        this.memberaddress = memberaddress;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }

    public void setCompanyaddress(String companyaddress) {
        this.companyaddress = companyaddress;
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getStoredMoney() {
        return storedMoney;
    }

    public void setStoredMoney(String storedMoney) {
        this.storedMoney = storedMoney;
    }

    public String getCarcolor() {
        return carcolor;
    }

    public void setCarcolor(String carcolor) {
        this.carcolor = carcolor;
    }

    public String getCartype() {
        return cartype;
    }

    public void setCartype(String cartype) {
        this.cartype = cartype;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getParkId() {
        return parkId;
    }

    public void setParkId(Integer parkId) {
        this.parkId = parkId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getEnterUser() {
        return enterUser;
    }

    public void setEnterUser(String enterUser) {
        this.enterUser = enterUser;
    }

    public Integer getLgId() {
        return lgId;
    }

    public void setLgId(Integer lgId) {
        this.lgId = lgId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", memberId=").append(memberId);
        sb.append(", serviceType=").append(serviceType);
        sb.append(", joinTime=").append(joinTime);
        sb.append(", state=").append(state);
        sb.append(", lincensePlateId=").append(lincensePlateId);
        sb.append(", expirationTime=").append(expirationTime);
        sb.append(", phonenumber=").append(phonenumber);
        sb.append(", companyname=").append(companyname);
        sb.append(", departmentname=").append(departmentname);
        sb.append(", memberaddress=").append(memberaddress);
        sb.append(", companyaddress=").append(companyaddress);
        sb.append(", carname=").append(carname);
        sb.append(", storedMoney=").append(storedMoney);
        sb.append(", carcolor=").append(carcolor);
        sb.append(", cartype=").append(cartype);
        sb.append(", areaName=").append(areaName);
        sb.append(", parkId=").append(parkId);
        sb.append(", agentId=").append(agentId);
        sb.append(", enterUser=").append(enterUser);
        sb.append(", lgId=").append(lgId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}