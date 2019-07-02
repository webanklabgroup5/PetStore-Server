package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.service.PetService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
@Slf4j
public class PetServiceImpl implements PetService {
    @Autowired
    private Account accountContract;
    @Autowired
    private Transaction transactionContract;
    @Autowired
    private PetMarket petMarketContract;

    @Override
    public boolean petAdd(String userKey, String name, int species, String picPath, String birthday, String description) throws Exception {
        TransactionReceipt receipt = petMarketContract.newPet(name, BigInteger.valueOf(species),birthday,description,picPath).send();
        log.info("status: {}", receipt.getStatus());
        return true;
    }

    @Override
    public boolean petDown(String userKey, String id) throws Exception {
        TransactionReceipt receipt = petMarketContract.offSale(new BigInteger(id)).send();
        log.info("status: {}", receipt.getStatus());
        return true;
    }

    @Override
    public boolean petOn(String userKey, String id, int price) throws Exception {
        // 计算上架时间now

        TransactionReceipt receipt = petMarketContract.sellPet(new BigInteger(id),BigInteger.valueOf(price)).send();
        return false;
    }
}
