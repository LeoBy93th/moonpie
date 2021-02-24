package com.longz.moonpie.util;

import com.longz.moonpie.domian.CreateOrderVo;
import com.longz.moonpie.domian.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MoonPieUtil
 * @Author Leo
 * @Date 2021/2/23
 */
public class MoonPieUtil {

    public static Result<String>  upi(String url,String publicKey) throws Exception{
        String resultString=HttpUtils.sendHttpGet(url+"?publicKey="+publicKey);
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    public static Result<CreateOrderVo> createOrder(String url, String publicKey,String secret, String tradeNo, String refNo, String upi, String notifyUrl)throws  Exception{
        Map<String,String> map=new HashMap<String, String>();
        map.put("publicKey",publicKey);
        map.put("tradeNo",tradeNo);
        map.put("refNo",refNo);
        String signData="publicKey="+publicKey+"&refNo="+refNo+"&tradeNo="+tradeNo;
        if (notifyUrl!=null){
            signData="notifyYUrl="+notifyUrl+"&"+signData;
            map.put("notifyUrl",notifyUrl);
        }
        if (upi!=null){
            signData=signData+"&upi="+upi;
            map.put("upi",upi);
        }
        signData=signData+secret;
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

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
    public static Result<Long> withdraw(String url,String publicKey,String secret,Integer amount,String beneficaryName,String phoneNumber,String accountType,String beneficaryAccount,String ifsCode,String tradeNo,String vpaAddress,String notifyUrl) throws Exception{
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
        signData=signData+"&beneficaryName="+beneficaryName+"&clientRemark="+phoneNumber;
        if (ifsCode!=null){
            map.put("ifsCode",ifsCode);
            signData=signData+"&ifsCode="+ifsCode;
        }
        if (notifyUrl!=null){
            map.put("notifyUrl",notifyUrl);
            signData=signData+"&notifyUrl="+notifyUrl;
        }
        if (tradeNo!=null){
            map.put("tradeNo",tradeNo);
            signData=signData+"&tradeNo="+tradeNo;
        }
        if (vpaAddress!=null){
            map.put("vpaAddress",vpaAddress);
            signData=signData+"&vpaAddress="+vpaAddress;
        }
        signData=signData+secret;
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }
    public static  Result<Integer> withdrawQuery(String url,String publicKey,String secret,Long withdrawId)throws Exception{
        String resultString=HttpUtils.sendHttpGet(url+"?publicKey="+publicKey+"&withdrawId="+withdrawId,Md5Utils.hash(secret+withdrawId));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }
    public static Result<Integer> withdrawQuery(String url,String publicKey,String secret,String tradeNo) throws Exception{
        String resultString=HttpUtils.sendHttpGet(url+"?publicKey="+publicKey+"&tradeNo="+tradeNo,Md5Utils.hash(secret+tradeNo));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }
}
