Author:Leo
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
