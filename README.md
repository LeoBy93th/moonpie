Author:Leo

工具类
<br>
获取upi:
MoonpieUtil.upi(url,publicKey);
<br>
创建代收订单：
MoonpieUtil.createOrder(url,publicKey,secret,tradeNo,refNo,upi,notifyUrl);
<br>
查询代收订单：
MoonpieUtil.orderQuery(url,publicKey,secret,orderNo,refNo,tradeNo);
<br>
创建代付订单：
<br>第一种：MoonpieUtil.withdraw(url,publicKey,secret,amount,beneficaryName,phoneNumber,accontType,beneficaryAccount,ifsCode,tradeNo,vpaAddress,notifyUrl,email);
<br>第二种：<br>CreateWithdrawVo createWithdrawVo=CreateWithdrawVo
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.build()
                <br>          .setAccountType(accountType)
                <br>          .setAmount(amount)
                <br>          .setBeneficaryAccount(beneficaryAccount)
                <br>          .setBeneficaryName(beneficaryName)
                <br>          .setIfsCode(ifsCode)
                <br>          .setNotifyUrl(notifyUrl)
                <br>          .setPhoneNumber(phoneNumber)
                <br>          .setTradeNo(tradeNo)
                <br>          .setVpaAddress(vpaAddress)
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.end();
 <br>MoonPieUtil.withdraw(url,publicKey,secret,createWithdrawVo);
 
 代付查询by withdrawId:
 MoonpieUtil:withdrawQuery(url,publicKey,secret,withdrawId);
 
 代付查询by tradeNo:
 MoonpieUtil.withdrawQuery(url,publicKey,secret,tradeNo);

 签名生成方法：MoonpieUtil.encodeSign(SortedMap<String,Object> map, String secret);
SortedMap<String,Object>
 签名校验方法：MoonpieUtil.checkSign()


Moonpie服务使用

Spring项目：

加载进容器：
    @Bean
    public MoonpieService moonpieInit(){
        return new Moonpie(host,publicKey,secret);
    }

使用

    @Autowired
    private MoonpieService moonpie;

获取upi:

    moonpie.getUpi();

创建代收订单:

    CreateOrderRequest request = new CreateOrderRequest();
    request.setTradeNo("uudsafasd1");
    request.setRefNo("sdaq24123");
        try {
            Result<CreateOrderVo> order = moonpie.createOrder(request);
            System.out.println("---->"+ JsonUtil.objectToJson(order));
        } catch (ApiException e) {
            e.printStackTrace();
        }

查询代收订单:

    OrderQueryRequest request = new OrderQueryRequest();
    request.setTradeNo("uudsafasd1");
    try {
        Result<CreateOrderVo> query = moonpie.orderQuery(request);
        System.out.println("---->"+ JsonUtil.objectToJson(query));
    } catch (ApiException e) {
        e.printStackTrace();
    }

