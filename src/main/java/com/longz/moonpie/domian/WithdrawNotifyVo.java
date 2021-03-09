package com.longz.moonpie.domian;

import java.io.Serializable;

/**
 * @ClassName WithdrawNotifyVo
 * @Author Leo
 * @Date 2021/3/9
 */
public class WithdrawNotifyVo implements Serializable {
    private Integer amount;
    private String status;
    private Long withdrawId;
    private String failureReason;
    private String tradeNo;

    public WithdrawNotifyVo() {
    }

    public Integer getAmount() {
        return amount;
    }

    public WithdrawNotifyVo setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public WithdrawNotifyVo setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getWithdrawId() {
        return withdrawId;
    }

    public WithdrawNotifyVo setWithdrawId(Long withdrawId) {
        this.withdrawId = withdrawId;
        return this;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public WithdrawNotifyVo setFailureReason(String failureReason) {
        this.failureReason = failureReason;
        return this;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public WithdrawNotifyVo setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
        return this;
    }

    @Override
    public String toString() {
        return "WithdrawNotifyVo{" +
                "amount=" + amount +
                ", status='" + status + '\'' +
                ", withdrawId=" + withdrawId +
                ", failureReason='" + failureReason + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
