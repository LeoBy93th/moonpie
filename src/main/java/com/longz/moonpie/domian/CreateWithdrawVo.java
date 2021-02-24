package com.longz.moonpie.domian;

import java.io.Serializable;


public class CreateWithdrawVo implements Serializable {
    private Integer amount;
    private String beneficaryName;
    private String phoneNumber;
    private String accountType;
    private String beneficaryAccount;
    private String ifsCode;
    private String tradeNo;
    private String vpaAddress;
    private String notifyUrl;

    public CreateWithdrawVo() {
    }
    private CreateWithdrawVo(Build build){
        this.amount=build.amount;
        this.beneficaryName=build.beneficaryName;
        this.phoneNumber=build.phoneNumber;
        this.accountType=build.accountType;
        this.beneficaryAccount=build.beneficaryAccount;
        this.ifsCode=build.ifsCode;
        this.tradeNo=build.tradeNo;
        this.vpaAddress=build.vpaAddress;
        this.notifyUrl=build.notifyUrl;
    }

    public static Build build(){
        return new Build();
    }
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getBeneficaryName() {
        return beneficaryName;
    }

    public void setBeneficaryName(String beneficaryName) {
        this.beneficaryName = beneficaryName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBeneficaryAccount() {
        return beneficaryAccount;
    }

    public void setBeneficaryAccount(String beneficaryAccount) {
        this.beneficaryAccount = beneficaryAccount;
    }

    public String getIfsCode() {
        return ifsCode;
    }

    public void setIfsCode(String ifsCode) {
        this.ifsCode = ifsCode;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getVpaAddress() {
        return vpaAddress;
    }

    public void setVpaAddress(String vpaAddress) {
        this.vpaAddress = vpaAddress;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    public static class Build{
        private Integer amount;
        private String beneficaryName;
        private String phoneNumber;
        private String accountType;
        private String beneficaryAccount;
        private String ifsCode;
        private String tradeNo;
        private String vpaAddress;
        private String notifyUrl;

        public Build setAmount(Integer amount) {
            this.amount = amount;
            return this;
        }

        public Build setBeneficaryName(String beneficaryName) {
            this.beneficaryName = beneficaryName;
            return this;
        }

        public Build setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Build setAccountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Build setBeneficaryAccount(String beneficaryAccount) {
            this.beneficaryAccount = beneficaryAccount;
            return this;
        }

        public Build setIfsCode(String ifsCode) {
            this.ifsCode = ifsCode;
            return this;
        }

        public Build setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
            return this;
        }

        public Build setVpaAddress(String vpaAddress) {
            this.vpaAddress = vpaAddress;
            return this;
        }

        public Build setNotifyUrl(String notifyUrl) {
            this.notifyUrl = notifyUrl;
            return this;
        }

        public CreateWithdrawVo end(){
            return new CreateWithdrawVo(this);
        }
    }

    @Override
    public String toString() {
        return "CreateWithdrawVo{" +
                "amount=" + amount +
                ", beneficaryName='" + beneficaryName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", beneficaryAccount='" + beneficaryAccount + '\'' +
                ", ifsCode='" + ifsCode + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", vpaAddress='" + vpaAddress + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
