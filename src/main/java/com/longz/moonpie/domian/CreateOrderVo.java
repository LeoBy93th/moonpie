package com.longz.moonpie.domian;

import java.io.Serializable;

/**
 * @ClassName CreateOrderVo
 * @Author Leo
 * @Date 2021/2/24
 */
public class CreateOrderVo implements Serializable {
    private String orderNo;
    private Integer rechargeAmount;
    private String posetedDate;
    private String status;
    private TransferOrderVo transferOrder;

    public TransferOrderVo getTransferOrder() {
        return transferOrder;
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

}
