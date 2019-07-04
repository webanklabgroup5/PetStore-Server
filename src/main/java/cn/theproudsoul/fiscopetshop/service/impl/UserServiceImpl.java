package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Applicant;
import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.User;
import cn.theproudsoul.fiscopetshop.repository.ApplicantRepository;
import cn.theproudsoul.fiscopetshop.repository.UserRepository;
import cn.theproudsoul.fiscopetshop.service.PetService;
import cn.theproudsoul.fiscopetshop.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.stereotype.Service;
import util.UserKeyUtils;
import util.Utils;

import java.math.BigInteger;
import java.util.*;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private final ContractService contractService;
    private final UserRepository userRepository;
    private final ApplicantRepository applicantRepository;
    private final PetService petService;

    public UserServiceImpl(ContractService contractService, UserRepository userRepository, ApplicantRepository applicantRepository, PetService petService) {
        this.contractService = contractService;
        this.userRepository = userRepository;
        this.applicantRepository = applicantRepository;
        this.petService = petService;
    }

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
                    log.info(contractService.getCredentials().getAddress());
                    TransactionReceipt receipt = contractService.getAccountContract().newAccount(address, BigInteger.valueOf(applicant.getCredit())).send();
                    if (receipt.isStatusOK()){
                        user = new User();
                        user.setUserName(applicant.getUserName());
                        user.setUserKey(key);
                        user.setPassword(Utils.getSHA256Str(applicant.getPassword()));
                        user.setAddress(address);
                        userRepository.save(user);
                        applicantRepository.deleteById(applicant.getId());
                        return 1;
                    } else {
                        return 0;
                    }
                } catch (Exception e){
                    e.printStackTrace();
                } return 0;
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
            applicant.setPassword(Utils.getSHA256Str(password));
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
            if (Utils.getSHA256Str(passwd).equals(password)){
//            if (password.equals(passwd)){
                return tmp.getId();
            } else {
                log.info("密码错误");
                return -2;
            }
        }
    }

    @Override
    public User getUserInfo(User user) {
        BigInteger credit = null;
        try {
            String address = user.getAddress();
            log.info("我是谁"+contractService.getAccountContract().myAddress().send());
            credit = contractService.getAccountContract().balanceOf(address).send();
        } catch (Exception e) {
            log.info("获取用户信息失败！");
            e.printStackTrace();
        }

        user.setCredit(credit.intValue());
//
//        List<Pet> petList;
//        List<BigInteger> petIndex = contractService.getPetMarketContract().getMyPets().send();
//        petList = petStoreService.getPetsByPetId(petIndex);
//        if (petList==null) petList = new ArrayList<>();
        return user;
    }

    @Override
    public int getMyCredit() {
        try {
            return contractService.getAccountContract().myBalance().send().intValue();
        } catch (Exception e) {
            log.info("获取本用户积分失败");
            e.printStackTrace();
        }
        return 0;
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
    public List<Pet> getPetList() {
        // 在区块链上根据用户名查找宠物列表

        return null;
    }

    @Override
    public List<User> sellers() {
        List<Pet> petList = petService.getPetsOnSale();
        Set<User> userSet= new HashSet<>();

        for (Pet pet:petList){
            userSet.add(pet.getOwner());
        }
        List<User> userList = new ArrayList<>(userSet);
        return userList;
    }
}
