package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.service.TransactionService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private ContractService contractService;
    @Autowired
    private PetStoreService petStoreService;

    @Override
    public int transaction(String petId){
        // 计算交易时间now
        long now=System.currentTimeMillis();
        String time = Utils.sdf(now);
        // 将remark删除
        try {
            TransactionReceipt receipt = contractService.getPetMarketContract().buyPet(new BigInteger(petId), time).send();
            if (receipt.isStatusOK())
                return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    @Override
    public List<Order> getOrdersByUserId() {
        List<Order> orderList = null;
        try {
            List<BigInteger> orderIndex = contractService.getTransactionContract().getMyRecords().send();
            orderList =petStoreService.getOrdersByOrderId(orderIndex);
        } catch (Exception e){
            e.printStackTrace();
            log.error("获取个人订单失败");
        }
        if (orderList==null) orderList = new ArrayList<>();
        return orderList;
    }

    @Override
    public List<Pet> getPetsOnSell() {
        List<Pet> petList = new ArrayList<>();
        try{
            List<BigInteger> petIndex = contractService.getPetMarketContract().getPetsForSale().send();
            petList = petStoreService.getPetsByPetId(petIndex);
        } catch (Exception e){
            e.printStackTrace();
        }
        return petList;
    }

    @Override
    public boolean arbitration(String transactionId) {
        // 调用合约
        try {
            TransactionReceipt receipt = contractService.getTransactionContract().requestArbitration(new BigInteger(transactionId),"").send();
            if (receipt.isStatusOK())
                return true;
        } catch (Exception e) {
            log.error("发起仲裁发生错误");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Order> arbitrationList() {
        List<Order> orderList = new ArrayList<>();
        List<BigInteger> arbitrationIndex = null;
        try {
            arbitrationIndex = contractService.getTransactionContract().getAllArbitrations().send();

        } catch (Exception e) {
            log.error("获取所有审判列表失败");
            e.printStackTrace();
        }
        if (arbitrationIndex != null) {
            orderList = petStoreService.getOrdersByOrderId(arbitrationIndex);
        }
        return orderList;
    }

    @Override
    public boolean judge(String transactionId, int result) {
        BigInteger id = new BigInteger(transactionId);
        try {
            TransactionReceipt receipt = null;
            if (result==1){
                // 同意
                receipt = contractService.getTransactionContract().approveArbitration(id).send();
            } else if (result==0){
                // 拒绝
                receipt = contractService.getTransactionContract().denyArbitration(id,"no").send();
            }
            if (receipt.isStatusOK()) return true;
        } catch (Exception e){
            log.error("审判出错！");
        }
        return false;
    }

}
