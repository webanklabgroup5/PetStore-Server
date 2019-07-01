package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Admin;
import cn.theproudsoul.fiscopetshop.entity.User;

import java.util.concurrent.ExecutionException;

public interface UserService {
    String addUser(String userName, int initCredit); // 新增用户

    //boolean setIouLimit(int amount,String updateTime,String orgID) throws InterruptedException, ExecutionException;  // 设定白条额度

    int getIouLimit(String orgID);  // 获取白条额度

    boolean recycleIou(String iouId,int amount)throws InterruptedException, ExecutionException;  // 回收白条

    int checkPassword(int type, String userKey);//检查password

    User getUserByKey(String userKey);//根据用户的ID来返回用户的信息

    Admin getAdminByKey(String userKey);
}
