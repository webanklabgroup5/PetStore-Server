package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Admin;
import cn.theproudsoul.fiscopetshop.entity.User;


public interface UserService {

    String addUser(String userName, String passwd, int initCredit); // 新增用户

    int checkPassword(int type, String name, String passwd);//检查password

    User getUserInfo() throws Exception;

    Admin getAdmin();
}
