package cn.theproudsoul.fiscopetshop;

import cn.theproudsoul.fiscopetshop.service.impl.ContractService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
public class ContractTest extends DemoApplicationTests{

    //@Test
    //public void deployAndCallHelloWorld() throws Exception {
        // deploy contract
//        HelloWorld helloWorld =
//                HelloWorld.deploy(
//                                web3j,
//                                credentials,
//                                new StaticGasProvider(
//                                        GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT))
//                        .send();
//        if (helloWorld != null) {
//            System.out.println("HelloWorld address is: " + helloWorld.getContractAddress());
//            // call set function
//            helloWorld.set("Hello, World!").send();
//            // call get function
//            String result = helloWorld.get().send();
//            System.out.println(result);
//            assertTrue("Hello, World!".equals(result));
//        }
//    }

    //String creditAddr = "0x916670d47aab109b6dd2fb347d0d4c9145532d40";
    //String toAddr = "0xb6be2594774bbe9c4c483d289c891e1349011713";

//    [INFO] Account Address   : 0x57953e7f7f16d257ed9e347c43e6a3e31b22d03b
//    [INFO] Private Key (pem) : accounts/0x57953e7f7f16d257ed9e347c43e6a3e31b22d03b.pem
//    [INFO] Private Key: 0x22cbf916c07a301fab85f357879d486bf14d24b192a70c25f46260e4395e6959


//    [INFO] Account Address   : 0xb6be2594774bbe9c4c483d289c891e1349011713
//    [INFO] Private Key (pem) : accounts/0xb6be2594774bbe9c4c483d289c891e1349011713.pem
//    [INFO] Private Key: 0xb6a2ac2326e0c5b82c3bed3ed0e151d7ac458bc2f156be74caf70b50d6e76079

    String creditAddr = "0xc3f091c74abb132b42322df7093c692f95e10c83";
    String fromAddr = "0x57953e7f7f16d257ed9e347c43e6a3e31b22d03b";
    String toAddr = "0xb6be2594774bbe9c4c483d289c891e1349011713";
    @Autowired
    private ContractService contractService;
    @Test
    public void testContract() {
        contractService.setCredentials("b6a2ac2326e0c5b82c3bed3ed0e151d7ac458bc2f156be74caf70b50d6e76079");
        // credentialsConfig.setUserKey("b6a2ac2326e0c5b82c3bed3ed0e151d7ac458bc2f156be74caf70b50d6e76079");
        try {
            String address = contractService.getAccountContract().myAddress().send();
            log.info("账户地址为" +address);
            log.info("成功改变地址？"+"0xb6be2594774bbe9c4c483d289c891e1349011713");
        } catch (Exception e) {
            log.error("获取地址错误！");
            e.printStackTrace();
        }
    }

//    @Test
//    public void testDeploy() {
//        LAGCredit lagCredit = LagCreditService.deploy(web3j, credentials);
//        log.info("LAGCredit address: {}", lagCredit);
//    }


}
