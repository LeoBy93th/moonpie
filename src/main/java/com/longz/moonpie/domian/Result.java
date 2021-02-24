package com.longz.moonpie.domian;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Author Leo
 * @Date 2021/2/23
 */
public class Result <T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public Result() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}