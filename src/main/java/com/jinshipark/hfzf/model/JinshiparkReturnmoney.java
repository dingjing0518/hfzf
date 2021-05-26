package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class JinshiparkReturnmoney implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "车牌号")
    private String carnum;

    @ApiModelProperty(value = "订单号")
    private String orderid;

    @ApiModelProperty(value = " 汇付订单号")
    private String hforderid;

    @ApiModelProperty(value = "退款金额")
    private String returnmoney;

    @ApiModelProperty(value = "退费手续费")
    private String refundservicefee;

    @ApiModelProperty(value = "退款时间")
    private Date createtime;

    @ApiModelProperty(value = "操作员名称")
    private String username;

    @ApiModelProperty(value = "车场编号")
    private String parkid;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getHforderid() {
        return hforderid;
    }

    public void setHforderid(String hforderid) {
        this.hforderid = hforderid;
    }

    public String getReturnmoney() {
        return returnmoney;
    }

    public void setReturnmoney(String returnmoney) {
        this.returnmoney = returnmoney;
    }

    public String getRefundservicefee() {
        return refundservicefee;
    }

    public void setRefundservicefee(String refundservicefee) {
        this.refundservicefee = refundservicefee;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
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
        sb.append(", carnum=").append(carnum);
        sb.append(", orderid=").append(orderid);
        sb.append(", hforderid=").append(hforderid);
        sb.append(", returnmoney=").append(returnmoney);
        sb.append(", refundservicefee=").append(refundservicefee);
        sb.append(", createtime=").append(createtime);
        sb.append(", username=").append(username);
        sb.append(", parkid=").append(parkid);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}