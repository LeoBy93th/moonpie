package com.longz.moonpie.config;

/**
 * URL地址配置
 * @author: sichen.yuan
 * @date: 2021/3/8 14:01
 */
public class UrlConfig {

    /**
     * 获取收款 UPI
     */
    private String upiUrl = "/upi";

    /**
     * 创建代收订单地址
     */
    private String orderCreateUrl = "/order/create";

    /**
     * 查询代收订单状态地址
     */
    private String orderQueryUrl = "/order/query";

    /**
     * 创建代付订单地址
     */
    private String withdrawUrl = "/withdraw";

    /**
     * 查询代付订单-by withdrawId
     */
    private String withdrawIdQueryUrl ="/withdraw";


    /**
     * 查询代付订单-by tradeNo
     */
    private String withdrawTradeNoQueryUrl ="/withdraw/query";

    public UrlConfig() {
    }

    public UrlConfig(String upiUrl, String orderCreateUrl, String orderQueryUrl, String withdrawUrl, String withdrawIdQueryUrl, String withdrawTradeNoQueryUrl) {
        this.upiUrl = upiUrl;
        this.orderCreateUrl = orderCreateUrl;
        this.orderQueryUrl = orderQueryUrl;
        this.withdrawUrl = withdrawUrl;
        this.withdrawIdQueryUrl = withdrawIdQueryUrl;
        this.withdrawTradeNoQueryUrl = withdrawTradeNoQueryUrl;
    }

    public String getUpiUrl() {
        return upiUrl;
    }

    public void setUpiUrl(String upiUrl) {
        this.upiUrl = upiUrl;
    }

    public String getOrderCreateUrl() {
        return orderCreateUrl;
    }

    public void setOrderCreateUrl(String orderCreateUrl) {
        this.orderCreateUrl = orderCreateUrl;
    }

    public String getOrderQueryUrl() {
        return orderQueryUrl;
    }

    public void setOrderQueryUrl(String orderQueryUrl) {
        this.orderQueryUrl = orderQueryUrl;
    }

    public String getWithdrawUrl() {
        return withdrawUrl;
    }

    public void setWithdrawUrl(String withdrawUrl) {
        this.withdrawUrl = withdrawUrl;
    }

    public String getWithdrawIdQueryUrl() {
        return withdrawIdQueryUrl;
    }

    public void setWithdrawIdQueryUrl(String withdrawIdQueryUrl) {
        this.withdrawIdQueryUrl = withdrawIdQueryUrl;
    }

    public String getWithdrawTradeNoQueryUrl() {
        return withdrawTradeNoQueryUrl;
    }

    public void setWithdrawTradeNoQueryUrl(String withdrawTradeNoQueryUrl) {
        this.withdrawTradeNoQueryUrl = withdrawTradeNoQueryUrl;
    }
}
