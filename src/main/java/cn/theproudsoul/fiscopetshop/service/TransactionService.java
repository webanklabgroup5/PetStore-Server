package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Orders;
import cn.theproudsoul.fiscopetshop.entity.Pets;

import java.math.BigInteger;
import java.util.List;

public interface TransactionService {
    int transaction(String userKey, String petId);

    Orders getOrdersByUserId(String userKey);

    Pets getPetsOnSell(String userKey);

    Orders getOrdersByOrderId(List<BigInteger> orderIndex);

    boolean arbitration(String userKey, String transactionId);

    boolean judge(String userKey, String transactionId, int result);
}
