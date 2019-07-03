package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.constants.ContractConstants;
import cn.theproudsoul.fiscopetshop.constants.GasConstants;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.crypto.gm.GenCredential;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ContractService {
    @Autowired
    private Web3j web3j;
    private Credentials credentials;
    private Account accountContract;
    private PetMarket petMarketContract;
    private Transaction transactionContract;

    public boolean isAdmin() {
        return isAdmin;
    }

    private boolean isAdmin;

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }
    public void setCredentials(String userKey) {
        credentials = GenCredential.create(userKey);
        accountContract = Account.load(ContractConstants.account, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
        petMarketContract = PetMarket.load(ContractConstants.petMarket, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
        transactionContract = Transaction.load(ContractConstants.transaction, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
        try {
            isAdmin = accountContract.isAdmin().send().isStatusOK();
        } catch (Exception e) {
            log.info("调用管理员验证接口失败！");
            e.printStackTrace();
        }
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public Account getAccountContract() {
            return accountContract;
    }

    public PetMarket getPetMarketContract() {
        return petMarketContract;
    }

    public Transaction getTransactionContract() {
        return transactionContract;
    }
}
