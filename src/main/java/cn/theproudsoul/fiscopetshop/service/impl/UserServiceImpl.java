package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.*;
import cn.theproudsoul.fiscopetshop.service.TransactionService;
import cn.theproudsoul.fiscopetshop.service.UserService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.UserKeyUtils;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    Account accountContract;
    @Autowired
    Transaction transactionContract;
    @Autowired
    PetMarket petMarketContract;
    @Autowired
    private TransactionService transactionService;

    @Override
    public String addUser(String userName, int initCredit) {
        UserKeyUtils userKeyUtils = new UserKeyUtils();
        String user_key = userKeyUtils.getPrivateKey();
        // 将用户名、公钥、积分写入区块链
        try{

        } catch(Exception e){
            e.printStackTrace();
        }

        return user_key;
    }

    @Override
    public int checkPassword(int type, String userKey) {

        // 使用user_key连接区块链
        // 在链上获取用户信息验证
        if(userKey=="") {
            //不存在该机构
            System.out.println("用户不存在");
            return 1;
        }else {
            // 验证权限
            if(type==1){
                System.out.println("用户类型不正确");
                return -2;
            }else {
                return 0;
            }
        }
    }

    @Override
    public User getUserByKey(String userKey) {
        // 区块链查询
        String username = "";
        int remainingCredit = 1000;
//        Pets =

        User user = new User(username, remainingCredit);
        return user;
    }

    @Override
    public Admin getAdminByKey(String userKey) {
        int transactionCount=0;
        int petCount=0;
        try {
            transactionCount=transactionContract.getRecordCount().send().intValue();
            petCount=petMarketContract.getSalingPetCounts().send().intValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        Market market = new Market(transactionCount,petCount);

        Orders orderList = new Orders();
        try {
            List<BigInteger> orderIndex = transactionContract.getAllArbitrations().send();
            orderList = transactionService.getOrdersByOrderId(orderIndex);
        }catch (Exception e) {
            e.printStackTrace();
        }

        Admin admin = new Admin(market, orderList);
        return admin;
    }
}
