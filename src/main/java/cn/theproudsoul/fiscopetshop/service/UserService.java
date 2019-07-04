package cn.theproudsoul.fiscopetshop.service;

import cn.theproudsoul.fiscopetshop.entity.Applicant;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.User;

import java.util.List;


public interface UserService {

    int auditUser(String userId, boolean isAgree); // 同意或拒绝用户开户申请

    int applyUser(String userName, String passwd, int credit);

    List<User> userList();

    List<Applicant> applyUserList();

    long checkPassword(int type, String name, String passwd);//检查password

    User getUserInfo(User user);

    int getMyCredit();

    User getUserById(String id); // 使用id获取用户信息

    List<Pet> getPetListByUserId(String id); // 获取用户宠物列表

    List<Pet> getPetList();

    List<User> sellers();

}
