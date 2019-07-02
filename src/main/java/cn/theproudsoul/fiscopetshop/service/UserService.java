package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Admin;
import cn.theproudsoul.fiscopetshop.entity.User;


public interface UserService {
    String addUser(String userName, int initCredit); // 新增用户

    int checkPassword(int type, String userKey);//检查password

    User getUserByKey(String userKey);//根据用户的ID来返回用户的信息

    Admin getAdminByKey(String userKey);
}
