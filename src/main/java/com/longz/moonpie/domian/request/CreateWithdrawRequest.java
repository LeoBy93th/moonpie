package com.longz.moonpie.domian.request;

import com.longz.moonpie.enums.AccountType;

import java.io.Serializable;

public class CreateWithdrawRequest implements Serializable {
    /**
     * 代付金额 单位为：Paisa 最小值为 100 (正整数)
     */
    private Integer amount;

    /**
     * 用户姓名 (Max length 30 Character)
     */
    private String beneficaryName;

    /**
     * 联系方式 (Max length 20 Character)
     */
    private String phoneNumber;

    /**
     * 收款人的资金账户类型（银行卡账户为 bank_account,Vpa 账户为 vpa），可选，默认为银行卡账户（bank_account）
     */
    private AccountType accountType;

    /**
     * 银行卡账号(Max length 34 Character)，默认或者 accountType 为 bank_account 时必填
     */
    private String beneficaryAccount;

    /**
     * IFSC(ifsCode Always 11 character)，默认或者 accountType 为 bank_account 时必填
     */
    private String ifsCode;

    /**
     * 商户订单号 (Max length 30 Character) 必须保证唯一
     */
    private String tradeNo;

    /**
     * 收款人的虚拟付款地址（vpa）3 至 100 个字符。支持的字符：a-z，A-Z，0-9，.，-和一个@。例如，gauravkumar@exampleupi。accountType 为 vpa 时必填
     */
    private String vpaAddress;

    /**
     * 订单的回调地址 (优先订单中的回调地址，如订单中没有，默认后台配置地址)
     */
    private String notifyUrl;
    /**
     * 邮箱
     */
    private String email;

    public CreateWithdrawRequest() {
    }

    public CreateWithdrawRequest(Integer amount, String beneficaryName, String phoneNumber, AccountType accountType, String beneficaryAccount, String ifsCode, String tradeNo, String vpaAddress, String notifyUrl, String email) {
        this.amount = amount;
        this.beneficaryName = beneficaryName;
        this.phoneNumber = phoneNumber;
        this.accountType = accountType;
        this.beneficaryAccount = beneficaryAccount;
        this.ifsCode = ifsCode;
        this.tradeNo = tradeNo;
        this.vpaAddress = vpaAddress;
        this.notifyUrl = notifyUrl;
        this.email = email;
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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CreateWithdrawRequest{" +
                "amount=" + amount +
                ", beneficaryName='" + beneficaryName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", accountType=" + accountType +
                ", beneficaryAccount='" + beneficaryAccount + '\'' +
                ", ifsCode='" + ifsCode + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", vpaAddress='" + vpaAddress + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
