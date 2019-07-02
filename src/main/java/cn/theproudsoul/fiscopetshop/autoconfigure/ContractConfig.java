package cn.theproudsoul.fiscopetshop.autoconfigure;

import cn.theproudsoul.fiscopetshop.constants.GasConstants;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "contract-address")
@Slf4j
public class ContractConfig {
    private String account;
    private String petMarket;
    private String transaction;

    @Autowired private Web3j web3j;
    @Autowired private Credentials credentials;

    @Bean
    public Account getAccountContract() throws Exception {
        log.info("account : {}", account);
        return Account.load(account, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
    }

    @Bean
    public PetMarket getPetMarketContract() throws Exception {
        log.info("petMarket : {}", petMarket);
        return PetMarket.load(petMarket, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
    }

    @Bean
    public Transaction getTransactionContract() throws Exception {
        log.info("transaction : {}", transaction);
        return Transaction.load(transaction, web3j, credentials, new StaticGasProvider(
                GasConstants.GAS_PRICE,GasConstants.GAS_LIMIT));
    }

}
