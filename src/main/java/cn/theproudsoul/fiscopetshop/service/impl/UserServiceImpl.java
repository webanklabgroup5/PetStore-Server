package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Admin;
import cn.theproudsoul.fiscopetshop.entity.Judges;
import cn.theproudsoul.fiscopetshop.entity.Market;
import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.service.UserService;
import org.springframework.stereotype.Service;
import util.UserKeyUtils;
import util.Utils;

import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
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
    public int getIouLimit(String orgID) {
        return 0;
    }

    @Override
    public boolean recycleIou(String iouId, int amount) throws InterruptedException, ExecutionException {
        return false;
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
        // 区块链查询
//        Market market;
//        Judges judges;

        Admin admin = new Admin();
        return admin;
    }
}
