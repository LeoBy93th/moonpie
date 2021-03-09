package com.longz.moonpie.service;

import com.longz.moonpie.domian.CreateOrderVo;
import com.longz.moonpie.domian.Result;
import com.longz.moonpie.domian.TransferNotifyVo;
import com.longz.moonpie.domian.WithdrawNotifyVo;
import com.longz.moonpie.domian.request.CreateOrderRequest;
import com.longz.moonpie.domian.request.CreateWithdrawRequest;
import com.longz.moonpie.domian.request.OrderQueryRequest;
import com.longz.moonpie.exception.ApiException;

import javax.servlet.http.HttpServletRequest;


/**
 * @author: sichen.yuan
 * @date: 2021/3/8 10:52
 */
public interface MoonpieService {

    /**
     * 获取收款 UPI
     *
     * @return
     */
    Result<String> getUpi() throws ApiException;

    /**
     * 创建代收订单
     *
     * @param request
     * @return
     */
    Result<CreateOrderVo> createOrder(CreateOrderRequest request) throws ApiException;


    /**
     * 查询代收订单状态
     *
     * @param request
     * @return
     */
    Result<CreateOrderVo> orderQuery(OrderQueryRequest request) throws ApiException;


    /**
     * 创建代付订单
     *
     * @param request
     * @return
     */
    Result<Long> withdraw(CreateWithdrawRequest request) throws ApiException;


    /**
     * 查询代付订单-by withdrawId
     *
     * @param withdrawId
     * @return
     */

    Result<Integer> withdrawQuery(Long withdrawId) throws ApiException;


    /**
     * 查询代付订单-by tradeNo
     *
     * @param tradeNo
     * @return
     */
    Result<Integer> withdrawQuery(String tradeNo) throws ApiException;

    /**
     *  代收回调
     * @return
     * @throws ApiException
     */
    TransferNotifyVo transferNotify(HttpServletRequest request);

    /**
     * 代付回调
     * @param request
     * @return
     * @throws ApiException
     */
    WithdrawNotifyVo withdrawNotify(HttpServletRequest request);
}
