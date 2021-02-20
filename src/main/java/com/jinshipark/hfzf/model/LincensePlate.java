package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class LincensePlate implements Serializable {
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

    @ApiModelProperty(value = "进场图片保存路径")
    private String inpicpath;

    @ApiModelProperty(value = "出场图片保存路径")
    private String outpicpath;

    @ApiModelProperty(value = "支付ID")
    private String paymentid;

    @ApiModelProperty(value = "1-已退款 0-未退款")
    private String refundstatus;

    @ApiModelProperty(value = "退款金额")
    private String refundmoney;

    @ApiModelProperty(value = "支付平台订单ID")
    private String adaorderid;

    private static final long serialVersionUID = 1L;

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

    public String getInpicpath() {
        return inpicpath;
    }

    public void setInpicpath(String inpicpath) {
        this.inpicpath = inpicpath;
    }

    public String getOutpicpath() {
        return outpicpath;
    }

    public void setOutpicpath(String outpicpath) {
        this.outpicpath = outpicpath;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
    }

    public String getRefundstatus() {
        return refundstatus;
    }

    public void setRefundstatus(String refundstatus) {
        this.refundstatus = refundstatus;
    }

    public String getRefundmoney() {
        return refundmoney;
    }

    public void setRefundmoney(String refundmoney) {
        this.refundmoney = refundmoney;
    }

    public String getAdaorderid() {
        return adaorderid;
    }

    public void setAdaorderid(String adaorderid) {
        this.adaorderid = adaorderid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lpId=").append(lpId);
        sb.append(", lpMemberIdCar=").append(lpMemberIdCar);
        sb.append(", lpLincensePlateIdCar=").append(lpLincensePlateIdCar);
        sb.append(", lpServiceTypeCar=").append(lpServiceTypeCar);
        sb.append(", lpInboundTime=").append(lpInboundTime);
        sb.append(", lpDepartureTime=").append(lpDepartureTime);
        sb.append(", lpRentTime=").append(lpRentTime);
        sb.append(", lpCreateTime=").append(lpCreateTime);
        sb.append(", lpOrderId=").append(lpOrderId);
        sb.append(", lpCarType=").append(lpCarType);
        sb.append(", lpCarColor=").append(lpCarColor);
        sb.append(", lpLincenseType=").append(lpLincenseType);
        sb.append(", lpParkingOften=").append(lpParkingOften);
        sb.append(", lpParkingCost=").append(lpParkingCost);
        sb.append(", lpParkingRealCost=").append(lpParkingRealCost);
        sb.append(", lpInboundCname=").append(lpInboundCname);
        sb.append(", lpDepartureCname=").append(lpDepartureCname);
        sb.append(", lpParkingName=").append(lpParkingName);
        sb.append(", lpAgentName=").append(lpAgentName);
        sb.append(", lpOrderState=").append(lpOrderState);
        sb.append(", lpPaymentType=").append(lpPaymentType);
        sb.append(", lpLgId=").append(lpLgId);
        sb.append(", lpLgType=").append(lpLgType);
        sb.append(", inpicpath=").append(inpicpath);
        sb.append(", outpicpath=").append(outpicpath);
        sb.append(", paymentid=").append(paymentid);
        sb.append(", refundstatus=").append(refundstatus);
        sb.append(", refundmoney=").append(refundmoney);
        sb.append(", adaorderid=").append(adaorderid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}