package com.longz.moonpie.domian;

import java.io.Serializable;


public class TransferOrderVo implements Serializable {
    private String publicKey;
    private String upi;
    private String tradeNo;
    private String refNo;
    private Integer amount;
    private String email;
    private String phone;
    private String notifyUrl;
    private String name;
    public TransferOrderVo() {
    }

    public Integer getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public TransferOrderVo setName(String name) {
        this.name = name;
        return this;
    }

    public TransferOrderVo setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public TransferOrderVo setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public TransferOrderVo setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public TransferOrderVo setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
        return this;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getUpi() {
        return upi;
    }

    public void setUpi(String upi) {
        this.upi = upi;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    @Override
    public String toString() {
        return "TransferOrderVo{" +
                "publicKey='" + publicKey + '\'' +
                ", upi='" + upi + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", refNo='" + refNo + '\'' +
                ", amount=" + amount +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
