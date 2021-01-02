package com.jinshipark.hfzf.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 金石停车返回封装类
 */
public class JinshiparkJSONResult {

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;
    @JsonIgnore
    private String ok;    // 不使用

    public static JinshiparkJSONResult build(Integer status, String msg, Object data) {
        return new JinshiparkJSONResult(status, msg, data);
    }

    public static JinshiparkJSONResult ok(Object data) {
        return new JinshiparkJSONResult(data);
    }

    public static JinshiparkJSONResult ok() {
        return new JinshiparkJSONResult(null);
    }

    public static JinshiparkJSONResult errorMsg(String msg) {
        return new JinshiparkJSONResult(500, msg, null);
    }

    public static JinshiparkJSONResult errorMap(Object data) {
        return new JinshiparkJSONResult(501, "error", data);
    }

    public static JinshiparkJSONResult errorTokenMsg(String msg) {
        return new JinshiparkJSONResult(502, msg, null);
    }

    public static JinshiparkJSONResult errorException(String msg) {
        return new JinshiparkJSONResult(555, msg, null);
    }

    public JinshiparkJSONResult() {

    }

    public JinshiparkJSONResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JinshiparkJSONResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

}
