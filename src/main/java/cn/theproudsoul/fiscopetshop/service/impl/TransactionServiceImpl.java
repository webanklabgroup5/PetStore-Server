package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.constants.GasConstants;
import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Orders;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.Pets;
import cn.theproudsoul.fiscopetshop.service.TransactionService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Utils;

import java.math.BigInteger;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    Account accountContract;
    @Autowired
    Transaction transactionContract;
    @Autowired
    PetMarket petMarketContract;

    @Override
    public int transaction(String userKey, String petId){
        // 计算交易时间now
        long now=System.currentTimeMillis();
        String time = Utils.sdf(now);
        return 0;
    }

    public Orders getOrdersByOrderId(List<BigInteger> orderIndex){
        Orders orderList = new Orders();
        for(BigInteger i: orderIndex){
            Order order = new Order();
            order.setId(String.valueOf(i));
            try {
                Tuple5<String, String, BigInteger, BigInteger, BigInteger> order_tuple = transactionContract.getRecordById(i).send();
                order.setPet_id(String.valueOf(order_tuple.getValue3()));
                order.setPrice(order_tuple.getValue4().intValue());
            }catch (Exception e){
                e.printStackTrace();
            }
            orderList.getOrderList().add(order);
        }
        return orderList;
    }

    @Override
    public Orders getOrdersByUserId(String userKey) {
        Orders orderList = null;
        try {
            List<BigInteger> orderIndex = transactionContract.getMyRecords().send();
            orderList = getOrdersByOrderId(orderIndex);
        } catch (Exception e){
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public Pets getPetsOnSell(String userKey) {
        Pets petList = null;
        try{
            List petIndex = petMarketContract.getPetsForSale().send();
            String[] temp = (String[]) petIndex.toArray();
            petList = new Pets();
            for (int i = 0; i < petIndex.size(); i ++){
                Pet pet = new Pet();
                pet.setPetId(temp[i]);
                Tuple7<Boolean, BigInteger, BigInteger, String, String, String, String> pet_tuple = petMarketContract.getPetById( new BigInteger(temp[i])).send();
                pet.setStatus(pet_tuple.getValue1());
                pet.setSpecies(pet_tuple.getValue2().intValue());
                pet.setPrice(pet_tuple.getValue3().intValue());
                pet.setName(pet_tuple.getValue4());
                pet.setBirthday(pet_tuple.getValue5());
                pet.setDescription(pet_tuple.getValue6());
                pet.setImgUrl(pet_tuple.getValue7());
                petList.getPetList().add(pet);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return petList;
    }

    @Override
    public boolean arbitration(String userKey, String transactionId) {
        // 调用合约
        return false;
    }

    @Override
    public boolean judge(String userKey, String transactionId, int result) {
        return false;
    }

}
