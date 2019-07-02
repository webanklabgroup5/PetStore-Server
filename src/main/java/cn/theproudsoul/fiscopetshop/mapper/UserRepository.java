package cn.theproudsoul.fiscopetshop.mapper;

import cn.theproudsoul.fiscopetshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
//    @Query("INSERT INTO user(userName,userKey,password,remainingCredit VALUES(#{userName},#{userKey},#{password},#{remainingCredit})")
//    void addUser(User user);  // 新增用户
//
//    @Query(value = "SELECT * FROM user where userName=#{userName}")
//    User queryUserByName(String userName);  // 通过用户名查询
//
//    @Query("SELECT password FROM user WHERE userName=#{userName}")
//    String getPassword(String userName);//检查密码是否正确
//
//    @Query("SELECT * FROM user")
//    List<User> queryAllUser();
}
