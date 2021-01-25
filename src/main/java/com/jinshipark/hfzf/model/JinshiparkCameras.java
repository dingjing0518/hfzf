package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class JinshiparkCameras implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraname;

    @ApiModelProperty(value = "摄像机所属岗亭")
    private String watchhouse;

    @ApiModelProperty(value = "摄像机内部编号")
    private String cameraid;

    @ApiModelProperty(value = "摄像机ip")
    private String ipaddress;

    @ApiModelProperty(value = "网络地址")
    private String ipsubnet;

    @ApiModelProperty(value = "网络地址")
    private String ipgateway;

    @ApiModelProperty(value = "进出口")
    private String inorout;

    @ApiModelProperty(value = "0：表示远程抬杆，1：表示远程落杆（只在设备管理页面使用）")
    private String status;

    @ApiModelProperty(value = "车场id")
    private String parkid;

    @ApiModelProperty(value = "代理商id")
    private String agentid;

    @ApiModelProperty(value = "区域名称")
    private String areaname;

    @ApiModelProperty(value = "备注")
    private String remarks;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCameraname() {
        return cameraname;
    }

    public void setCameraname(String cameraname) {
        this.cameraname = cameraname;
    }

    public String getWatchhouse() {
        return watchhouse;
    }

    public void setWatchhouse(String watchhouse) {
        this.watchhouse = watchhouse;
    }

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public String getIpsubnet() {
        return ipsubnet;
    }

    public void setIpsubnet(String ipsubnet) {
        this.ipsubnet = ipsubnet;
    }

    public String getIpgateway() {
        return ipgateway;
    }

    public void setIpgateway(String ipgateway) {
        this.ipgateway = ipgateway;
    }

    public String getInorout() {
        return inorout;
    }

    public void setInorout(String inorout) {
        this.inorout = inorout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParkid() {
        return parkid;
    }

    public void setParkid(String parkid) {
        this.parkid = parkid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
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
        sb.append(", cameraname=").append(cameraname);
        sb.append(", watchhouse=").append(watchhouse);
        sb.append(", cameraid=").append(cameraid);
        sb.append(", ipaddress=").append(ipaddress);
        sb.append(", ipsubnet=").append(ipsubnet);
        sb.append(", ipgateway=").append(ipgateway);
        sb.append(", inorout=").append(inorout);
        sb.append(", status=").append(status);
        sb.append(", parkid=").append(parkid);
        sb.append(", agentid=").append(agentid);
        sb.append(", areaname=").append(areaname);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}