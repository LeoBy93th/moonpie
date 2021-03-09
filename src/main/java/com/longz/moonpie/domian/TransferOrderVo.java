package com.longz.moonpie.domian;

import java.io.Serializable;


public class TransferOrderVo implements Serializable {
    private String publicKey;
    private String upi;
    private String tradeNo;
    private String refNo;

    public TransferOrderVo() {
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
                '}';
    }
}
