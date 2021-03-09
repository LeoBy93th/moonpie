package com.longz.moonpie.domian;

import com.longz.moonpie.config.UrlConfig;
import com.longz.moonpie.domian.request.CreateOrderRequest;
import com.longz.moonpie.domian.request.CreateWithdrawRequest;
import com.longz.moonpie.domian.request.OrderQueryRequest;
import com.longz.moonpie.exception.ApiException;
import com.longz.moonpie.service.MoonpieService;
import com.longz.moonpie.util.MoonPieUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Moonpie
 * @Author Leo
 * @Date 2021/3/9
 */
public class Moonpie implements MoonpieService {
    /**
     * URL配置
     */
    private UrlConfig urlConfig = new UrlConfig();

    /**
     * host(域名)
     */
    private String host;
    /**
     * Key
     */
    private String publicKey;

    /**
     * 密钥
     */
    private String secret;

    public Moonpie(String host, String publicKey, String secret) {
        this.host = host;
        this.publicKey = publicKey;
        this.secret = secret;
    }

    public Moonpie(UrlConfig urlConfig, String host, String publicKey, String secret) {
        this.urlConfig = urlConfig;
        this.host = host;
        this.publicKey = publicKey;
        this.secret = secret;
    }

    @Override
    public Result<String> getUpi() throws ApiException {
        String url = this.host + urlConfig.getUpiUrl();

        Result<String> upi;
        try {
            upi = MoonPieUtil.upi(url, this.publicKey);
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the UPI interface");
        }
        return upi;
    }

    @Override
    public Result<CreateOrderVo> createOrder(CreateOrderRequest request) throws ApiException {
        String url = this.host + urlConfig.getOrderCreateUrl();

        Result<String> upi = this.getUpi();
        Result<CreateOrderVo> order;
        try {
            order = MoonPieUtil.createOrder(url, this.publicKey, this.secret, request.getTradeNo(),
                    request.getRefNo(), upi.getData(), request.getNotifyUrl());
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the Create order interface");
        }

        return order;
    }
    @Override
    public Result<CreateOrderVo> orderQuery(OrderQueryRequest request) throws ApiException {
        String url = this.host + urlConfig.getOrderQueryUrl();
        Result<CreateOrderVo> createOrderVoResult;
        try {
            createOrderVoResult = MoonPieUtil.orderQuery(url, this.publicKey, this.secret,
                    request.getOrderNo(), request.getRefNo(), request.getTradeNo());
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the Query order interface");
        }
        return createOrderVoResult;
    }
    @Override
    public Result<Long> withdraw(CreateWithdrawRequest request) throws ApiException {
        String url = this.host + urlConfig.getWithdrawUrl();
        Result<Long> withdraw;
        try {
            withdraw = MoonPieUtil.withdraw(url, this.publicKey, this.secret, request.getAmount(), request.getBeneficaryName(),
                    request.getPhoneNumber(), request.getAccountType().name(), request.getBeneficaryAccount(), request.getIfsCode(),
                    request.getTradeNo(), request.getVpaAddress(), request.getNotifyUrl(), request.getEmail());
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the Withdraw interface");
        }
        return withdraw;
    }
    @Override
    public Result<Integer> withdrawQuery(Long withdrawId) throws ApiException {
        String url = this.host + urlConfig.getWithdrawIdQueryUrl();

        Result<Integer> integerResult;
        try {
            integerResult = MoonPieUtil.withdrawQuery(url, this.publicKey, this.secret, withdrawId);
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the Query withdraw interface");
        }
        return integerResult;
    }
    @Override
    public Result<Integer> withdrawQuery(String tradeNo) throws ApiException {

        String url = this.host + urlConfig.getWithdrawTradeNoQueryUrl();
        Result<Integer> integerResult;
        try {
            integerResult = MoonPieUtil.withdrawQuery(url, this.publicKey, this.secret, tradeNo);
        } catch (Exception e) {
            throw new ApiException(e.getCause(), "Exception calling the Query withdraw interface");
        }
        return integerResult;
    }

    @Override
    public TransferNotifyVo transferNotify(HttpServletRequest request) {
        return MoonPieUtil.transferNotify(request,this.secret);
    }

    @Override
    public WithdrawNotifyVo withdrawNotify(HttpServletRequest request){
        return MoonPieUtil.withdrawNotify(request,secret);
    }
}
