package com.jinshipark.hfzf.vo;

/**
 * 汇付支付的请求参数实体类
 */
public class AdapayRequstVO {
    private String order_no;//请求订单号，
    private String pay_amt;//交易金额
    private String app_id;//主页面应用的app_id
    private String pay_channel;//支付渠道
    private String goods_title;//商品标题
    private String goods_desc;//商品描述信息
    private String description;//订单附加说明
    private String div_members;//分账对象信息列表
    private String open_id;//微信公众号渠道需要传的open_id
    private String plate;//车牌
    private String parkId;//车场Id
    private String notify_url;//回调地址

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getPay_amt() {
        return pay_amt;
    }

    public void setPay_amt(String pay_amt) {
        this.pay_amt = pay_amt;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getGoods_title() {
        return goods_title;
    }

    public void setGoods_title(String goods_title) {
        this.goods_title = goods_title;
    }

    public String getGoods_desc() {
        return goods_desc;
    }

    public void setGoods_desc(String goods_desc) {
        this.goods_desc = goods_desc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiv_members() {
        return div_members;
    }

    public void setDiv_members(String div_members) {
        this.div_members = div_members;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getParkId() {
        return parkId;
    }

    public void setParkId(String parkId) {
        this.parkId = parkId;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }
}
