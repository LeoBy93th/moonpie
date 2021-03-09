package com.longz.moonpie.domian.request;

/**
 * @author: sichen.yuan
 * @date: 2021/3/8 11:15
 */
public class OrderQueryRequest extends BaseRequest {

    private static final long serialVersionUID = 1169670707314922350L;

    /**
     * 我方订单号
     */
    private String orderNo;

    /**
     * 银行返回的 Ref ID
     * (orderNo、refNo、tradeNo 三个参数不能同时为空)
     */
    private String refNo;

    /**
     * 商户订单号
     * (orderNo、refNo、tradeNo 三个参数不能同时为空)
     */
    private String tradeNo;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    @Override
    public String toString() {
        return "OrderQueryRequest{" +
                "orderNo='" + orderNo + '\'' +
                ", refNo='" + refNo + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
