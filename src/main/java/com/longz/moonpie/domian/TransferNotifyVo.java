package com.longz.moonpie.domian;

import java.io.Serializable;

/**
 * @ClassName TransferNotifyVo
 * @Author Leo
 * @Date 2021/3/9
 */
public class TransferNotifyVo implements Serializable {
    private String orderNo;
    private String posetedDate;
    private String status;
    private Integer rechargeAmount;
    private String failureReason;
    private String tradeNo;

    public TransferNotifyVo() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public TransferNotifyVo setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String getPosetedDate() {
        return posetedDate;
    }

    public TransferNotifyVo setPosetedDate(String posetedDate) {
        this.posetedDate = posetedDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public TransferNotifyVo setStatus(String status) {
        this.status = status;
        return this;
    }

    public Integer getRechargeAmount() {
        return rechargeAmount;
    }

    public TransferNotifyVo setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
        return this;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public TransferNotifyVo setFailureReason(String failureReason) {
        this.failureReason = failureReason;
        return this;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public TransferNotifyVo setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    @Override
    public String toString() {
        return "TransferNotifyVo{" +
                "orderNo='" + orderNo + '\'' +
                ", posetedDate='" + posetedDate + '\'' +
                ", status='" + status + '\'' +
                ", rechargeAmount=" + rechargeAmount +
                ", failureReason='" + failureReason + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
