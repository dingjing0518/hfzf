package com.jinshipark.hfzf.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class JinshiparkCameras implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "摄像机名称")
    private String cameraname;

    @ApiModelProperty(value = "摄像机内部编号")
    private String cameraid;

    @ApiModelProperty(value = "进出口")
    private String inorout;

    @ApiModelProperty(value = "0：表示远程抬杆，1：表示远程落杆（只在设备管理页面使用）")
    private String status;

    @ApiModelProperty(value = "车场id")
    private String parkid;

    @ApiModelProperty(value = "区域名称")
    private String areaname;

    @ApiModelProperty(value = "生成的时间")
    private Date createtime;

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

    public String getCameraid() {
        return cameraid;
    }

    public void setCameraid(String cameraid) {
        this.cameraid = cameraid;
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

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
        sb.append(", cameraid=").append(cameraid);
        sb.append(", inorout=").append(inorout);
        sb.append(", status=").append(status);
        sb.append(", parkid=").append(parkid);
        sb.append(", areaname=").append(areaname);
        sb.append(", createtime=").append(createtime);
        sb.append(", remarks=").append(remarks);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}