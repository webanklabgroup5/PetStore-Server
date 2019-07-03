package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.entity.PetExtra;
import cn.theproudsoul.fiscopetshop.repository.PetExtraRepository;
import cn.theproudsoul.fiscopetshop.service.PetService;
import cn.theproudsoul.fiscopetshop.solidity.Account;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
import cn.theproudsoul.fiscopetshop.solidity.Transaction;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.Utils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PetServiceImpl implements PetService {

    @Autowired
    private ContractService contractService;
    @Autowired
    private PetStoreService petStoreService;

    @Override
    public boolean petAdd(String name, int species, String picPath, String birthday, String description) throws Exception {
        TransactionReceipt receipt = contractService.getPetMarketContract().newPet(name, BigInteger.valueOf(species),birthday,description,picPath).send();
        if (receipt.isStatusOK()){
            PetExtra petExtra = new PetExtra();
            petExtra.setImgUrl(picPath);
            petExtra.setPetName(name);
            //petExtraRepository.save(petExtra);
            return true;
        }else {
            log.info("status: {}", receipt.getStatus());
            return true;
        }
    }

    @Override
    public boolean petDown(String id) throws Exception {
        String petName = contractService.getPetMarketContract().getPetById(new BigInteger(id)).send().getValue4();
        TransactionReceipt receipt = contractService.getPetMarketContract().offSale(new BigInteger(id)).send();
        log.info("status: {}", receipt.getStatus());
        if (receipt.isStatusOK()){
            // 删除本地数据库
            //petExtraRepository.deleteByPetName(petName);
        }
        return receipt.isStatusOK();
    }

    @Override
    public boolean petOn(String petId, int price, String remark) throws Exception {
        // 计算上架时间now
        String now = Utils.sdf(System.currentTimeMillis());
        TransactionReceipt receipt = contractService.getPetMarketContract().sellPet(new BigInteger(petId),BigInteger.valueOf(price),now).send();
        //if ()
        return receipt.isStatusOK();
    }


    @Override
    public List<Pet> getPetsOnSale() {
        List<Pet> petList = null;
        try {
            List<BigInteger> petIndex = contractService.getPetMarketContract().getPetsForSale().send();
            if (petIndex==null){
                petList=new ArrayList<>();
            } else {
                petList = petStoreService.getPetsByPetId(petIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return petList;
    }
}
