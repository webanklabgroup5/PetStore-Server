package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.*;

import cn.theproudsoul.fiscopetshop.repository.ApplicantRepository;
import cn.theproudsoul.fiscopetshop.repository.UserRepository;
import cn.theproudsoul.fiscopetshop.service.UserService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.UserKeyUtils;
import util.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private ContractService contractService;

    @Autowired
    private  PetStoreService petStoreService;
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  ApplicantRepository applicantRepository;

    @Override
    public int auditUser(String userId, boolean isAgree) {
        Optional<Applicant> applicantOpt = applicantRepository.findById(Long.valueOf(userId));
        Applicant applicant;
        if (!applicantOpt.isPresent()) return 2;
        else applicant = applicantOpt.get();
        if (isAgree){ // 同意申请
            User user = userRepository.findByUserName(applicant.getUserName());
            if (user==null) {
                // 数据库中不存在可以操作
                UserKeyUtils userKeyUtils = new UserKeyUtils();
                String key = userKeyUtils.getPrivateKey();
                String address = userKeyUtils.getAddress();
                try {
                    // 将名字、积分、地址写进区块链
                    TransactionReceipt receipt = contractService.getAccountContract().newAccount(address, BigInteger.valueOf(user.getCredit())).send();
                } catch (Exception e){
                    e.printStackTrace();
                }
                user = new User();
                user.setUserName(applicant.getUserName());
                user.setUserKey(key);
                user.setPassword(Utils.getSHA256Str(applicant.getPassword()));
                userRepository.save(user);
                applicantRepository.deleteById(applicant.getId());
                return 1;
            } else return 0; // 用户名已存在
        } else { // 拒绝
            applicantRepository.deleteById(applicant.getId());
            return 1;
        }
    }

    @Override
    public int applyUser(String userName, String password, int credit) {
        User user = userRepository.findByUserName(userName);
        if (user==null) {
            // 数据库中不存在可以申请
            Applicant applicant = new Applicant();
            applicant.setPassword(password);
            applicant.setUserName(userName);
            applicant.setCredit(credit);
            applicantRepository.save(applicant);
            return 1;
        }
        return 0;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public List<Applicant> applyUserList() {
        List<Applicant> applicantList = applicantRepository.findAll();
        if (applicantList==null)
            applicantList = new ArrayList<>();
        return applicantList;
    }

    @Override
    public long checkPassword(int type, String userName, String passwd) {
        User tmp = userRepository.findByUserName(userName);
        if(tmp == null) {
            //不存在该用户
            log.info("用户不存在");
            return -1;
        } else {
            String password = tmp.getPassword();
            log.info(password);
//            if (Utils.getSHA256Str(password).equals(passwd)){
            if (password.equals(passwd)){
                System.out.println("密码正确");
                return tmp.getId();
            }
            else {
                log.info("密码错误");
                return -1;
            }
        }
    }

    @Override
    public User getUserInfo() throws Exception {

        //String name = accountContract.getMyName().send();
        String name ="test";
        User user = userRepository.findByUserName(name);
        // 区块链查询
        BigInteger credit = new BigInteger("1000");
        user.setCredit(credit.intValue());

        List<Pet> petList = null;
        List<BigInteger> petIndex = contractService.getPetMarketContract().getMyPets().send();
        petList = petStoreService.getPetsByPetId(petIndex);
        if (petList==null) petList = new ArrayList<>();


        return user;
    }

    @Override
    public User getUserById(String id) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(id));
        return userOpt.get();
    }

    @Override
    public List<Pet> getPetListByUserId(String id) {
        Optional<User> userOpt = userRepository.findById(Long.valueOf(id));
        String userName = userOpt.get().getUserName();
        // 再区块链上根据用户名查找宠物列表
        return null;
    }

    @Override
    public List<Pet> getPetListByUserName(String name) {
        // 在区块链上根据用户名查找宠物列表
        return null;
    }
}
