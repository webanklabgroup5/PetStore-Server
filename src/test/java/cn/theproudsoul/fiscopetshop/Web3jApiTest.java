package cn.theproudsoul.fiscopetshop;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigInteger;
import lombok.extern.slf4j.Slf4j;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class Web3jApiTest extends DemoApplicationTests{

    //private static final Logger log = LogManager.getLogger();

    @Autowired Web3j web3j;

    @Test
    public void getBlockNumber() throws IOException {
        BigInteger blockNumber = web3j.getBlockNumber().send().getBlockNumber();
        log.info("blockNumber is {}", blockNumber);
        assertTrue(blockNumber.compareTo(new BigInteger("0")) >= 0);
    }
}
