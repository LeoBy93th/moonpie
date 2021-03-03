package com.longz.moonpie.util;

import com.longz.moonpie.domian.CreateOrderVo;
import com.longz.moonpie.domian.CreateWithdrawVo;
import com.longz.moonpie.domian.Result;

import java.util.HashMap;
import java.util.Map;


public class MoonPieUtil {

    /**
     * 查询upi
     * @param url
     * @param publicKey
     * @return
     * @throws Exception
     */
    public static Result<String>  upi(String url,String publicKey) throws Exception{
        String resultString=HttpUtils.sendHttpGet(url+"?publicKey="+publicKey);
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 创建代收订单
     * @param url
     * @param publicKey
     * @param secret
     * @param tradeNo
     * @param refNo
     * @param upi
     * @param notifyUrl
     * @return
     * @throws Exception
     */
    public static Result<CreateOrderVo> createOrder(String url, String publicKey,String secret, String tradeNo, String refNo, String upi, String notifyUrl)throws  Exception{
        Map<String,String> map=new HashMap<String, String>();
        map.put("publicKey",publicKey);
        map.put("tradeNo",tradeNo);
        map.put("refNo",refNo);
        String signData="publicKey="+publicKey+"&refNo="+refNo+"&tradeNo="+tradeNo;
        if (notifyUrl!=null){
            signData="notifyUrl="+notifyUrl+"&"+signData;
            map.put("notifyUrl",notifyUrl);
        }
        if (upi!=null){
            signData=signData+"&upi="+upi;
            map.put("upi",upi);
        }
        signData=signData+secret;
        System.out.println(signData);
        System.out.println(Md5Utils.hash(signData));
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 代收订单查询
     * @param url
     * @param publicKey
     * @param secret
     * @param orderNo
     * @param refNo
     * @param tradeNo
     * @return
     * @throws Exception
     */
    public static Result<CreateOrderVo> orderQuery(String url,String publicKey,String secret,String orderNo,String refNo,String tradeNo)throws  Exception{
        Map<String,String> map=new HashMap<String, String>();
        map.put("publicKey",publicKey);
        String signData="publicKey="+publicKey;
        if (orderNo!=null){
            signData="orderNo="+orderNo+"&"+signData;
            map.put("orderNo",orderNo);
        }
        if (refNo!=null){
            signData=signData+"&refNo="+refNo;
            map.put("refNo",refNo);
        }
        if (tradeNo!=null){
            signData=signData+"&tradeNo="+tradeNo;
            map.put("tradeNo",tradeNo);
        }
        signData=signData+secret;
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 创建代付订单
     * @param url
     * @param publicKey
     * @param secret
     * @param withdrawVo
     * @return
     * @throws Exception
     */
    public static Result<Long> withdraw(String url, String publicKey, String secret, CreateWithdrawVo withdrawVo)throws Exception {
        if (withdrawVo==null){
            throw new Exception("Request parameters not found");
        }
        return withdraw(url,publicKey,secret,withdrawVo.getAmount(),withdrawVo.getBeneficaryName(),withdrawVo.getPhoneNumber(),withdrawVo.getAccountType(),withdrawVo.getBeneficaryAccount(),withdrawVo.getIfsCode(),withdrawVo.getTradeNo(),withdrawVo.getVpaAddress(),withdrawVo.getNotifyUrl(),withdrawVo.getEmail());
    }

    /**
     * 创建代付订单
     * @param url
     * @param publicKey
     * @param secret
     * @param amount
     * @param beneficaryName
     * @param phoneNumber
     * @param accountType
     * @param beneficaryAccount
     * @param ifsCode
     * @param tradeNo
     * @param vpaAddress
     * @param notifyUrl
     * @return
     * @throws Exception
     */

    public static Result<Long> withdraw(String url,String publicKey,String secret,Integer amount,String beneficaryName,String phoneNumber,String accountType,String beneficaryAccount,String ifsCode,String tradeNo,String vpaAddress,String notifyUrl,String email) throws Exception{
            Map<String,Object> map=new HashMap<String, Object>();
        String signData="amount="+amount;
        map.put("publicKey",publicKey);
        map.put("amount",amount);
        map.put("beneficaryName",beneficaryName);
        map.put("clientRemark",phoneNumber);
        if (accountType!=null){
            map.put("accountType",accountType);
            signData="accountType="+accountType+"&"+signData;
        }
        if (beneficaryAccount!=null){
            map.put("beneficaryAccount",beneficaryAccount);
            signData=signData+"&beneficaryAccount="+beneficaryAccount;
        }
        if (email!=null){
            map.put("email",email);
            signData=signData+"&email="+email;
        }
        signData=signData+"&beneficaryName="+beneficaryName+"&clientRemark="+phoneNumber;
        if (ifsCode!=null){
            map.put("ifsCode",ifsCode);
            signData=signData+"&ifsCode="+ifsCode;
        }
        if (notifyUrl!=null){
            map.put("notifyUrl",notifyUrl);
            signData=signData+"&notifyUrl="+notifyUrl;
        }
        signData=signData+"&publicKey="+publicKey;
        if (tradeNo!=null){
            map.put("tradeNo",tradeNo);
            signData=signData+"&tradeNo="+tradeNo;
        }
        if (vpaAddress!=null){
            map.put("vpaAddress",vpaAddress);
            signData=signData+"&vpaAddress="+vpaAddress;
        }
        signData=signData+secret;
        System.out.println(signData);
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 代付查询
     * @param url
     * @param publicKey
     * @param secret
     * @param withdrawId
     * @return
     * @throws Exception
     */
    public static  Result<Integer> withdrawQuery(String url,String publicKey,String secret,Long withdrawId)throws Exception{
        String resultString=HttpUtils.sendHttpGetSign(url+"?publicKey="+publicKey+"&withdrawId="+withdrawId,Md5Utils.hash(secret+withdrawId));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 代付查询
     * @param url
     * @param publicKey
     * @param secret
     * @param tradeNo
     * @return
     * @throws Exception
     */
    public static Result<Integer> withdrawQuery(String url,String publicKey,String secret,String tradeNo) throws Exception{
        String resultString=HttpUtils.sendHttpGetSign(url+"?publicKey="+publicKey+"&tradeNo="+tradeNo,Md5Utils.hash(secret+tradeNo));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }
}
