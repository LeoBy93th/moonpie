Author:Leo

获取upi:
MoonpieUtil.upi(url,publicKey);

创建代收订单：
MoonpieUtil.createOrder(url,publicKey,secret,tradeNo,refNo,upi,notifyUrl);

查询代收订单：
MoonpieUtil.orderQuery(url,publicKey,secret,orderNo,refNo,tradeNo);

创建代付订单：
第一种：MoonpieUtil.withdraw(url,publicKey,secret,amount,beneficaryName,phoneNumber,accontType,beneficaryAccount,ifsCode,tradeNo,vpaAddress,notifyUrl);
第二种： CreateWithdrawVo createWithdrawVo=CreateWithdrawVo
                .build()
                .setAccountType(accountType)
                .setAmount(amount)
                .setBeneficaryAccount(beneficaryAccount)
                .setBeneficaryName(beneficaryName)
                .setIfsCode(ifsCode)
                .setNotifyUrl(notifyUrl)
                .setPhoneNumber(phoneNumber)
                .setTradeNo(tradeNo)
                .setVpaAddress(vpaAddress)
                .end();
        MoonPieUtil.withdraw(url,publicKey,secret,createWithdrawVo);
 
 代付查询by withdrawId:
 MoonpieUtil:withdrawQuery(url,publicKey,secret,withdrawId);
 
 代付查询by tradeNo:
 MoonpieUtil.withdrawQuery(url,publicKey,secret,tradeNo);
