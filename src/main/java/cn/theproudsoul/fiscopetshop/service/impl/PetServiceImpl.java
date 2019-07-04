package cn.theproudsoul.fiscopetshop.service.impl;

import cn.theproudsoul.fiscopetshop.entity.Pet;
import cn.theproudsoul.fiscopetshop.service.PetService;
import cn.theproudsoul.fiscopetshop.solidity.PetMarket;
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
    @Autowired
    private PetService petService;

    @Override
    public boolean petAdd(String name, int species, String picPath, String birthday, String description) throws Exception {
        TransactionReceipt receipt = contractService.getPetMarketContract().newPet(name, BigInteger.valueOf(species),birthday,description,picPath).send();
        if (receipt.isStatusOK()){
            return true;
        }else {
            log.info("status: {}", receipt.getStatus());
            return false;
        }
    }

    @Override
    public boolean petDown(String id) throws Exception {
        TransactionReceipt receipt = contractService.getPetMarketContract().offSale(new BigInteger(id)).send();
        log.info("status: {}", receipt.getStatus());
        return receipt.isStatusOK();
    }

    @Override
    public boolean petOn(String petId, int price, String remark) throws Exception {
        // 计算上架时间now
        String now = Utils.sdf(System.currentTimeMillis());
        TransactionReceipt receipt = contractService.getPetMarketContract().sellPet(new BigInteger(petId),BigInteger.valueOf(price),now,remark).send();

        //TransactionReceipt receipt = contractService.getPetMarketContract().sellPet(new BigInteger(petId),BigInteger.valueOf(price),now).send();
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

    @Override
    public int getPetCount(String address) {
        try {
            BigInteger petCount = contractService.getPetMarketContract().ownerPetCount(address).send();
            return petCount.intValue();
        } catch (Exception e) {
            log.info("获取用户宠物数量错误！！！");
            e.printStackTrace();
        }
        return 0;
    }

//    @Override
//    public List<Pet> getPetList() {
//        //petMarket.
//        return null;
//    }
}
