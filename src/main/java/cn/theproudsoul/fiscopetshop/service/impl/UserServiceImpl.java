package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.*;

import cn.theproudsoul.fiscopetshop.mapper.UserRepository;
import cn.theproudsoul.fiscopetshop.service.UserService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.UserKeyUtils;
import util.Utils;

import java.math.BigInteger;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private Account accountContract;
    @Autowired
    private Transaction transactionContract;
    @Autowired
    private PetMarket petMarketContract;
    @Autowired
    private PetStoreService petStoreService;
    @Autowired
    private UserRepository repository;

    @Override
    public String addUser(String userName, String passwd, int initCredit) {
        User user = repository.findByUserName(userName);
        if (user==null) {
            // 数据库中不存在可以
        }
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
    public int checkPassword(int type, String name, String passwd) {
        if (type==1) {
            // 是否对应admin

        }

        User tmp = repository.findByUserName(name);
        if(tmp == null) {
            //不存在该机构
            log.info("用户不存在");
            return -1;
        }else {
            String password = tmp.getPassword();
            if (Utils.getSHA256Str(password).equals(passwd)){
                System.out.println("密码正确");
                return 0;
            }
            else {
                System.out.println("密码错误");
                return 1;
            }
        }
    }

    @Override
    public User getUserInfo() throws Exception {

        String name = accountContract.getName().send();
        User user = repository.findByUserName(name);
        // 区块链查询
        BigInteger credit = new BigInteger("1000");
        user.setRemainingCredit(credit.intValue());

        Pets petList = new Pets();

            List<BigInteger> petIndex = petMarketContract.getMyPets().send();
            petList.setPetList(petStoreService.getPetsByPetId(petIndex));

        //user.setPetList(petList);
        return user;
    }

    @Override
    public Admin getAdmin() {
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
            orderList.setOrderList(petStoreService.getOrdersByOrderId(orderIndex));
        }catch (Exception e) {
            e.printStackTrace();
        }

        Admin admin = new Admin(market, orderList);
        return admin;
    }
}
