package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Order;
import cn.theproudsoul.fiscopetshop.entity.Pet;

import java.util.List;

public interface TransactionService {
    int transaction(String petId); // 申请交易

    List<Order> getOrdersByUserId(); // 根据用户获取订单列表

    List<Pet> getPetsOnSell(); // 获取在售宠物列表

    List<Order> arbitrationList(); // 获取仲裁列表

    boolean arbitration(String transactionId); // 申请仲裁

    boolean judge(String transactionId, int result); // 进行审判
}
