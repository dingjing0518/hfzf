package com.jinshipark.hfzf.model.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class LincensePlateVO {
    private Integer lpId;

    @ApiModelProperty(value = "会员名")
    private String lpMemberIdCar;

    @ApiModelProperty(value = "车牌号")
    private String lpLincensePlateIdCar;

    @ApiModelProperty(value = "服务类型：0：月卡，1：季卡，2：年卡")
    private String lpServiceTypeCar;

    @ApiModelProperty(value = "入站时间")
    private Date lpInboundTime;

    @ApiModelProperty(value = "离站时间")
    private Date lpDepartureTime;

    @ApiModelProperty(value = "租用时间")
    private String lpRentTime;

    @ApiModelProperty(value = "创建时间")
    private Date lpCreateTime;

    @ApiModelProperty(value = "订单id")
    private String lpOrderId;

    @ApiModelProperty(value = "区域名称（原来车辆类型）")
    private String lpCarType;

    @ApiModelProperty(value = "公司名称（原来是车辆颜色）")
    private String lpCarColor;

    @ApiModelProperty(value = "车牌类型")
    private String lpLincenseType;

    @ApiModelProperty(value = "停车时长")
    private String lpParkingOften;

    @ApiModelProperty(value = "停车费用")
    private String lpParkingCost;

    @ApiModelProperty(value = "实收费用")
    private String lpParkingRealCost;

    @ApiModelProperty(value = "入场口名")
    private String lpInboundCname;

    @ApiModelProperty(value = "出场口名")
    private String lpDepartureCname;

    @ApiModelProperty(value = "停车场名")
    private String lpParkingName;

    @ApiModelProperty(value = "代理商名")
    private String lpAgentName;

    @ApiModelProperty(value = "订单状态")
    private String lpOrderState;

    @ApiModelProperty(value = "支付类型")
    private String lpPaymentType;

    @ApiModelProperty(value = "车牌组表id")
    private Integer lpLgId;

    @ApiModelProperty(value = "车牌收费类型（0 表示临时车，1 表示会员车）")
    private Integer lpLgType;

    private String parkName;

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public String getLpMemberIdCar() {
        return lpMemberIdCar;
    }

    public void setLpMemberIdCar(String lpMemberIdCar) {
        this.lpMemberIdCar = lpMemberIdCar;
    }

    public String getLpLincensePlateIdCar() {
        return lpLincensePlateIdCar;
    }

    public void setLpLincensePlateIdCar(String lpLincensePlateIdCar) {
        this.lpLincensePlateIdCar = lpLincensePlateIdCar;
    }

    public String getLpServiceTypeCar() {
        return lpServiceTypeCar;
    }

    public void setLpServiceTypeCar(String lpServiceTypeCar) {
        this.lpServiceTypeCar = lpServiceTypeCar;
    }

    public Date getLpInboundTime() {
        return lpInboundTime;
    }

    public void setLpInboundTime(Date lpInboundTime) {
        this.lpInboundTime = lpInboundTime;
    }

    public Date getLpDepartureTime() {
        return lpDepartureTime;
    }

    public void setLpDepartureTime(Date lpDepartureTime) {
        this.lpDepartureTime = lpDepartureTime;
    }

    public String getLpRentTime() {
        return lpRentTime;
    }

    public void setLpRentTime(String lpRentTime) {
        this.lpRentTime = lpRentTime;
    }

    public Date getLpCreateTime() {
        return lpCreateTime;
    }

    public void setLpCreateTime(Date lpCreateTime) {
        this.lpCreateTime = lpCreateTime;
    }

    public String getLpOrderId() {
        return lpOrderId;
    }

    public void setLpOrderId(String lpOrderId) {
        this.lpOrderId = lpOrderId;
    }

    public String getLpCarType() {
        return lpCarType;
    }

    public void setLpCarType(String lpCarType) {
        this.lpCarType = lpCarType;
    }

    public String getLpCarColor() {
        return lpCarColor;
    }

    public void setLpCarColor(String lpCarColor) {
        this.lpCarColor = lpCarColor;
    }

    public String getLpLincenseType() {
        return lpLincenseType;
    }

    public void setLpLincenseType(String lpLincenseType) {
        this.lpLincenseType = lpLincenseType;
    }

    public String getLpParkingOften() {
        return lpParkingOften;
    }

    public void setLpParkingOften(String lpParkingOften) {
        this.lpParkingOften = lpParkingOften;
    }

    public String getLpParkingCost() {
        return lpParkingCost;
    }

    public void setLpParkingCost(String lpParkingCost) {
        this.lpParkingCost = lpParkingCost;
    }

    public String getLpParkingRealCost() {
        return lpParkingRealCost;
    }

    public void setLpParkingRealCost(String lpParkingRealCost) {
        this.lpParkingRealCost = lpParkingRealCost;
    }

    public String getLpInboundCname() {
        return lpInboundCname;
    }

    public void setLpInboundCname(String lpInboundCname) {
        this.lpInboundCname = lpInboundCname;
    }

    public String getLpDepartureCname() {
        return lpDepartureCname;
    }

    public void setLpDepartureCname(String lpDepartureCname) {
        this.lpDepartureCname = lpDepartureCname;
    }

    public String getLpParkingName() {
        return lpParkingName;
    }

    public void setLpParkingName(String lpParkingName) {
        this.lpParkingName = lpParkingName;
    }

    public String getLpAgentName() {
        return lpAgentName;
    }

    public void setLpAgentName(String lpAgentName) {
        this.lpAgentName = lpAgentName;
    }

    public String getLpOrderState() {
        return lpOrderState;
    }

    public void setLpOrderState(String lpOrderState) {
        this.lpOrderState = lpOrderState;
    }

    public String getLpPaymentType() {
        return lpPaymentType;
    }

    public void setLpPaymentType(String lpPaymentType) {
        this.lpPaymentType = lpPaymentType;
    }

    public Integer getLpLgId() {
        return lpLgId;
    }

    public void setLpLgId(Integer lpLgId) {
        this.lpLgId = lpLgId;
    }

    public Integer getLpLgType() {
        return lpLgType;
    }

    public void setLpLgType(Integer lpLgType) {
        this.lpLgType = lpLgType;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }
}
