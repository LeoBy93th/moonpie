package com.longz.moonpie.exception;

/**
 * @author: sichen.yuan
 * @date: 2021/3/8 13:41
 */
public class ApiException extends Exception {


    private static final long serialVersionUID = -7387536698822237853L;

    private String errCode;

    private String errMsg;


    public ApiException() {
        super();
    }

    public ApiException(Throwable cause, String errCode, String errMsg) {
        super(errCode + ":" + errMsg, cause);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public ApiException(Throwable cause, String errMsg) {
        super( errMsg, cause);
        this.errCode = "00";
        this.errMsg = errMsg;
    }


    public ApiException(String errCode, String errMsg) {
        super(errCode + ":" + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    public String getErrCode() {
        return errCode;
    }


    public String getErrMsg() {
        return errMsg;
    }

}
