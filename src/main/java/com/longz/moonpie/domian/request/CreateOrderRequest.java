package com.longz.moonpie.domian.request;

/**
 * @author: sichen.yuan
 * @date: 2021/3/8 11:10
 */
public class CreateOrderRequest extends BaseRequest {

    private static final long serialVersionUID = 3668201020256144302L;

    /**
     * 商户订单号
     */
    private String tradeNo;

    /**
     * 银行返回的 Ref ID
     */
    private String refNo;

    /**
     * 订单的回调地址
     */
    private String notifyUrl;

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

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "tradeNo='" + tradeNo + '\'' +
                ", refNo='" + refNo + '\'' +
                ", notifyUrl='" + notifyUrl + '\'' +
                '}';
    }
}
