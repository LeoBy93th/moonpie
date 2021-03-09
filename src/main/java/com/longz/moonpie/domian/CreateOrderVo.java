package com.longz.moonpie.domian;

import java.io.Serializable;


public class CreateOrderVo implements Serializable {
    private String orderNo;
    private Integer rechargeAmount;
    private String posetedDate;
    private String status;
    private String tradeNo;
    private TransferOrderVo transferOrder;

    public TransferOrderVo getTransferOrder() {
        return transferOrder;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public CreateOrderVo setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }


    public void setTransferOrder(TransferOrderVo transferOrder) {
        this.transferOrder = transferOrder;
    }

    public CreateOrderVo() {
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getRechargeAmount() {
        return rechargeAmount;
    }

    public void setRechargeAmount(Integer rechargeAmount) {
        this.rechargeAmount = rechargeAmount;
    }

    public String getPosetedDate() {
        return posetedDate;
    }

    public void setPosetedDate(String posetedDate) {
        this.posetedDate = posetedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "CreateOrderVo{" +
                "orderNo='" + orderNo + '\'' +
                ", rechargeAmount=" + rechargeAmount +
                ", posetedDate='" + posetedDate + '\'' +
                ", status='" + status + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", transferOrder=" + transferOrder +
                '}';
    }
}
