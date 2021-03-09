package com.longz.moonpie.util;

import com.longz.moonpie.domian.*;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class MoonPieUtil {

    /**
     * 查询upi
     *  url
     *  publicKey
     * 
     *  Exception
     */
    public static Result<String>  upi(String url,String publicKey) throws Exception{
        String resultString=HttpUtils.sendHttpGet(url+"?publicKey="+publicKey);
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 创建代收订单
     *  url
     *  publicKey
     *  secret
     *  tradeNo
     *  refNo
     *  upi
     *  notifyUrl
     * 
     *  Exception
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
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        Result<CreateOrderVo>  result= JsonUtil.jsonToPojo(resultString, Result.class);
        if (result.isSuccess()){
            String constr=JsonUtil.MAPPER.writeValueAsString(result.getData());
            CreateOrderVo data=JsonUtil.jsonToPojo(constr,CreateOrderVo.class);
            result.setData(data);
        }
        return result;
    }

    /**
     * 代收订单查询
     *  url
     *  publicKey
     *  secret
     *  orderNo
     *  refNo
     *  tradeNo
     * 
     *  Exception
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
        Result<CreateOrderVo>  result= JsonUtil.jsonToPojo(resultString, Result.class);
        if (result.isSuccess()){
            String constr=JsonUtil.MAPPER.writeValueAsString(result.getData());
            CreateOrderVo data=JsonUtil.jsonToPojo(constr,CreateOrderVo.class);
            result.setData(data);
        }
        return result;
    }

    /**
     * 创建代付订单
     *  url
     *  publicKey
     *  secret
     *  withdrawVo
     * 
     *  Exception
     */
    public static Result<Long> withdraw(String url, String publicKey, String secret, CreateWithdrawVo withdrawVo)throws Exception {
        if (withdrawVo==null){
            throw new Exception("Request parameters not found");
        }
        return withdraw(url,publicKey,secret,withdrawVo.getAmount(),withdrawVo.getBeneficaryName(),withdrawVo.getPhoneNumber(),withdrawVo.getAccountType(),withdrawVo.getBeneficaryAccount(),withdrawVo.getIfsCode(),withdrawVo.getTradeNo(),withdrawVo.getVpaAddress(),withdrawVo.getNotifyUrl(),withdrawVo.getEmail());
    }

    /**
     * 创建代付订单
     *  url
     *  publicKey
     *  secret
     *  amount
     *  beneficaryName
     *  phoneNumber
     *  accountType
     *  beneficaryAccount
     *  ifsCode
     *  tradeNo
     *  vpaAddress
     *  notifyUrl
     * 
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
        System.out.println(Md5Utils.hash(signData));
        String resultString=HttpUtils.sendHttpPostSign(url,JsonUtil.objectToJson(map),Md5Utils.hash(signData));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 代付查询
     *  url
     *  publicKey
     *  secret
     *  withdrawId
     * 
     *  Exception
     */
    public static  Result<Integer> withdrawQuery(String url,String publicKey,String secret,Long withdrawId)throws Exception{
        String resultString=HttpUtils.sendHttpGetSign(url+"?publicKey="+publicKey+"&withdrawId="+withdrawId,Md5Utils.hash(secret+withdrawId));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 代付查询
     *  url
     *  publicKey
     *  secret
     *  tradeNo
     * 
     *  Exception
     */
    public static Result<Integer> withdrawQuery(String url,String publicKey,String secret,String tradeNo) throws Exception{
        String resultString=HttpUtils.sendHttpGetSign(url+"?publicKey="+publicKey+"&tradeNo="+tradeNo,Md5Utils.hash(secret+tradeNo));
        assert resultString!=null;
        return JsonUtil.jsonToPojo(resultString,Result.class);
    }

    /**
     * 签名生成
     *  map
     *  secret
     * 
     */
    public static String encodeSign(SortedMap<String,Object> map, String secret){
        if(StringUtils.isEmpty(secret)){
            throw new RuntimeException("secret is required");
        }
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        List<String> values = new ArrayList<String>();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            String k = String.valueOf(entry.getKey());
            String v = String.valueOf(entry.getValue());
            if (StringUtils.isNotEmpty(v) && entry.getValue() !=null && !"sign".equals(k) && !"secret".equals(k)) {
                values.add(k + "=" + v);
            }
        }
        String sign = StringUtils.join(values, "&")+secret;
        return Md5Utils.hash(sign);
    }

    /**
     * 校验签名
     *  sign
     *  map
     *  secret
     * 
     */
    public static boolean checkSign(String sign,SortedMap<String,Object> map,String secret){
        if (StringUtils.isEmpty(sign)){
            throw new RuntimeException("sign is required");
        }
        return sign.equals(encodeSign(map,secret));
    }

    /**
     * 代付回调
     *  request
     *  secret
     * 
     */
    public static WithdrawNotifyVo withdrawNotify(HttpServletRequest request,String secret){
        String sign=request.getHeader("Sign");
        String jsonString=requestForJsonString(request);
        if (StringUtils.isEmpty(jsonString)){
            return null;
        }
        if (checkSign(sign,JsonUtil.jsonToMap(jsonString),secret)){
            return JsonUtil.jsonToPojo(jsonString,WithdrawNotifyVo.class);
        }
        return null;
    }

    /**
     * 代收回调
     *  request
     *  secret
     * 
     */
    public static TransferNotifyVo transferNotify(HttpServletRequest request,String secret){
        String sign=request.getHeader("Sign");
        String jsonString=requestForJsonString(request);
        if (StringUtils.isEmpty(jsonString)){
            return null;
        }
        if (checkSign(sign,JsonUtil.jsonToMap(jsonString),secret)){
            return JsonUtil.jsonToPojo(jsonString,TransferNotifyVo.class);
        }
        return null;
    }

    private static String requestForJsonString(HttpServletRequest request){
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
            StringBuffer buffer=new StringBuffer();
            String inputString;
            while ((inputString=reader.readLine())!=null){
                buffer.append(inputString);
            }
            return buffer.toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
