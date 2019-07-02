package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import org.fisco.bcos.web3j.tuples.generated.Tuple5;
import org.fisco.bcos.web3j.tuples.generated.Tuple6;
import org.fisco.bcos.web3j.tuples.generated.Tuple7;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class PetStoreService {
    @Autowired
    private Account accountContract;
    @Autowired
    private Transaction transactionContract;
    @Autowired
    private PetMarket petMarketContract;


    public List<Order> getOrdersByOrderId(List<BigInteger> orderIndex){
        List<Order> orderList = new ArrayList<>();
        for(BigInteger i: orderIndex){
            Order order = new Order();
            order.setId(String.valueOf(i));
            try {
                Tuple6<String, String, BigInteger, BigInteger, BigInteger, String> order_tuple = transactionContract.getRecordById(i).send();
                order.setPetId(String.valueOf(order_tuple.getValue3()));
                order.setPrice(order_tuple.getValue4().intValue());
                order.setTradeStatus(order_tuple.getValue5().intValue());
                order.setDate(order_tuple.getValue6());
            }catch (Exception e){
                e.printStackTrace();
            }
            orderList.add(order);
        }
        return orderList;
    }

    public List<Pet> getPetsByPetId(List<BigInteger> petIndex){
        List<Pet> petList = new ArrayList<>();
        for(BigInteger i: petIndex){
            Pet pet = new Pet();
            pet.setPetId(String.valueOf(i));

            try {
                Tuple7 pet_tuple = petMarketContract.getPetById(i).send();

            }catch (Exception e){
                e.printStackTrace();
            }
            petList.add(pet);
        }
        return petList;
    }

}
